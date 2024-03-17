<%-- 
    Document   : login
    Created on : Mar 15, 2024, 8:36:17 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="" /> <br></br>
            Password: <input type="password" name="password" value="" /> <br></br>
        <input type="submit" value="login" />
        </form>
    </body>
</html>
