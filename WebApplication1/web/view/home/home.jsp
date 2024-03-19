<%-- 
    Document   : home
    Created on : Mar 19, 2024, 10:02:39 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .container {
                text-align: center;
            }

            .center-image {
                max-width: 50%;
                max-height: 50%; /* Chỉnh kích thước tấm ảnh tùy thích */
            }

            .links {
                margin-top: 20px; /* Khoảng cách giữa hình ảnh và các liên kết */
            }

            a {
                display: inline-block;
                padding: 10px 20px;
                margin: 10px;
                text-decoration: none;
                color: #fff;
                background-color: #007bff;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            a:hover {
                background-color: #0056b3;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <img src="https://upload.wikimedia.org/wikipedia/vi/2/2d/Logo_Tr%C6%B0%E1%BB%9Dng_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.svg" class="center-image">
            <div class="links">
                <a href="/PRJ301_Assignment_Last_HE170601/lecturer/timetable?id=1">TimeTable</a>
                <a href="/PRJ301_Assignment_Last_HE170601/lecturer/att?id=1">Attendence</a>
                <a href="/PRJ301_Assignment_Last_HE170601/login">Logout</a>
            </div>
        </div>
    </body>
</html>
