<%-- 
    Document   : list
    Created on : Mar 15, 2024, 8:28:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Published_date</th>
                    <th>Online</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="article" items="${articles}">
                    <tr>
                        <td>${article.aid}</td>
                        <td>${article.title}</td>
                        <td>${article.published_date}</td>
                        <td>${article.online}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>