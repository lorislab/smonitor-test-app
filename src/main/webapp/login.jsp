<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Login</title>
    </head>
    <body id="login">
        <form action="j_security_check" method="POST">
            <p>
                <label>Username</label>
                <input value="" name="j_username" type="text"/>
            </p>
            <br style="clear: both;"/>
            <p>
                <label>Password</label>
                <input name="j_password" type="password"/>
            </p>
            <br style="clear: both;"/>
            <p>
                <input class="button" type="submit" value="Sign In"/>
            </p>
        </form>
    </body>
</html>