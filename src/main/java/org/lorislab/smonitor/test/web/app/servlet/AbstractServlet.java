/*
 * Copyright 2013 Andrej Petras.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lorislab.smonitor.test.web.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.lorislab.smonitor.test.web.app.factory.ObjectFactory;

/**
 *
 * @author Andrej Petras
 */
public class AbstractServlet extends HttpServlet {
    
    private static final long serialVersionUID = -7485624663932950866L;
    
    protected void writeOutput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ResetSession</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<ul>");
            Enumeration enumerator = session.getAttributeNames();
            while (enumerator.hasMoreElements()) {
                String name = (String) enumerator.nextElement();
                out.println("<li>");
                out.println(name + ": " + session.getAttribute(name).toString());
                out.println("</li>");
            }
            out.println("</ul>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            if (out != null) {
                out.close();
            }
        }        
        
    }
    
    protected void fillSession(HttpServletRequest request) {
        HttpSession session = request.getSession();

        // string
        session.setAttribute("TextAttribute", "Text");

        // list
        session.setAttribute("ListAttribute", Arrays.asList("Item1", "Item2", "Item3", "Item4", "Item5", "Item6"));

        // pojo
        session.setAttribute("PojoAttribute", ObjectFactory.createTestPojo());

        // pojo serializable
        session.setAttribute("TestPojoSerializable", ObjectFactory.createTestPojoSerializable());
        
        // create tree
        for (int i=0; i<100; i++) {
            session.setAttribute("Tree" + i, ObjectFactory.createTreeNode(5, 5));             
        }
       
    }
}
