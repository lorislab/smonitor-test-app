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
package org.lorislab.smonitor.test.web.app.factory;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.lorislab.smonitor.test.web.app.model.TestPojo;
import org.lorislab.smonitor.test.web.app.model.TestPojoSerializable;
import org.lorislab.smonitor.test.web.app.model.TreeNode;

/**
 *
 * @author Andrej Petras
 */
public final class ObjectFactory {

    private ObjectFactory() {
        // empty constructor
    }
    
    public static TestPojo createTestPojo() {
        TestPojo result = new TestPojo();
        result.setName(UUID.randomUUID().toString());
        Date now = new Date();
        result.setCount(now.getTime());
        result.setValue(UUID.randomUUID().toString());    
        return result;
    }
    
    public static TestPojoSerializable createTestPojoSerializable() {
        TestPojoSerializable result = new TestPojoSerializable();
        result.setName(UUID.randomUUID().toString());
        Date now2 = new Date();
        result.setCount(now2.getTime());
        result.setValue(UUID.randomUUID().toString());
        return result;
    }
    
    public static TreeNode createTreeNode(int level, int count) {
        TreeNode result = new TreeNode();
        result.setName("Level:" + level);
        if (level > 0) {
            for (int index = 0; index < count; index++) {
                result.getChildren().add(createTreeNode(level - 1, count));
            }
        }
        return result;
    }    
}
