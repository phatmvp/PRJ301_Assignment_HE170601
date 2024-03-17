<%-- 
    Document   : attendence
    Created on : Mar 5, 2024, 10:42:00 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance Form</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 50px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #f1f1f1;
            }

            input[type="text"] {
                padding: 5px;
                width: 100%;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 15px;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            #header {
                text-align: center; /* Căn giữa văn bản */
                color: #0077FF; /* Màu đại dương */
                margin-top: 40px; /* Khoảng cách từ đỉnh trang */
            }
            img{
                position: fixed;
                top: 20px;
                left: 20px;
                width: 100px;
                height: auto;
                z-index: 9999;
            }

            .top-right {
                position: absolute;
                top: 10px;
                right: 15px;
            }
        </style>
    </head>
    <body>
        <h1 id="header">Attendence</h1>
        <img src="https://upload.wikimedia.org/wikipedia/vi/2/2d/Logo_Tr%C6%B0%E1%BB%9Dng_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.svg"  />
        <div class="top-right">
            <a href="/PRJ301_Assignment_Last_HE170601/login">Logout</a> 
        </div>
        <form action="attendence" method="POST"> 
            <input type="hidden" name="id" value="${param.id}"/>
            <table border="1px">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Is Presented</td>
                    <td>Description</td>
                    <td>Att Time</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.student.id}</td>
                        <td>${a.student.name}</td>
                        <td>
                            ${a.present}
                            <input type="radio" 
                                   ${!a.present ?"checked=\"checked\"":""}
                                   name="present${a.student.id}" value="no"  /> No
                            <input type="radio" 
                                   ${a.present ?"checked=\"checked\"":""}
                                   name="present${a.student.id}" value ="yes" /> Yes
                        </td>
                        <td><input name="description${a.student.id}" type="text" value="${a.description}"></td>
                        <td>${a.time}</td>
                    </tr> 
                </c:forEach>
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

