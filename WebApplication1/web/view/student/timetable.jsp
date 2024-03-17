<%-- 
    Document   : student
    Created on : Mar 17, 2024, 9:45:10 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timetable</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f1f1f1;
            }

            form {
                margin-bottom: 20px;
            }

            input[type="date"],
            input[type="submit"] {
                padding: 8px;
                margin: 5px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            table {
                border-collapse: collapse;
                width: 80%;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 10px;
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

            td a {
                color: #007bff;
                text-decoration: none;
            }

            td a:hover {
                text-decoration: underline;
            }
            #c {
                background-color: #9966CC;
                color: black;
            }

            img{
                position: fixed;
                top: 20px;
                left: 20px;
                width: 100px;
                height: auto;
                z-index: 9999;
            }
            #header {
                text-align: center;
                color: #0077FF;
                margin-top: 20px;
            }

            .top-right {
                position: absolute;
                top: 10px;
                right: 15px;
            }
        </style>
    </head>
</head>
<h1 id="header">TimeTable</h1>
<img src="https://upload.wikimedia.org/wikipedia/vi/2/2d/Logo_Tr%C6%B0%E1%BB%9Dng_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.svg"/>
<body style="text-align: center;  ">
    <div style="text-align: center; margin-bottom: 11%">
        <form action="timetable" method="GET" >
            <input type="hidden" name="id" value="${param.id}"/>
            From : <input type="date" name="from" value="${requestScope.from}" /> -
            <input type="date" name="to" value="${requestScope.to}"/>
            <input type="submit" value="View"/>
        </form>
        <div class="top-right">
            <a href="/PRJ301_Assignment_Last_HE170601/login">Logout</a> 
        </div>
    </div>
    <div style="display: flex; justify-content: center; align-items: center; height: 200px;">
        <table>
            <tr>
                <td></td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td id="c">${d}</td>
                </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="slot">
                <tr>
                    <td>${slot.name}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.lessions}" var="les">
                                <c:if test="${(les.date eq d) and (les.slot.id eq slot.id)}">
                                    ${les.group.name} - ${les.group.subject.name}
                                    <c:if test="${les.attended}">
                                        Edit
                                    </c:if>
                                    <c:if test="${!les.attended}">
                                        Not yet
                                    </c:if>
                                    </a>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

