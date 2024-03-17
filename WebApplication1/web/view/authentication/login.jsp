<%-- 
    Document   : login
    Created on : Mar 5, 2024, 10:39:50 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-image: url("https://image.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg");
                background-size: cover;
                background-position: center;
            }

            .login-form {
                max-width: 400px;
                padding: 20px;
                border-radius: 10px;
                background-color: #f9f9f9;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .login-table {
                width: 100%;
            }

            .input-label {
                font-weight: bold;
                padding: 10px 0;
            }

            .input-field {
                padding: 10px 0;
            }

            .input-field input[type="text"],
            .input-field input[type="password"] {
                width: calc(100% - 10px);
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .input-field input[type="checkbox"] {
                vertical-align: middle;
                margin-right: 5px;
            }

            .submit-button input[type="submit"] {
                background-color: #4caf50;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s;
            }

            .submit-button input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>

        <form action="login" method="POST" class="login-form">
            <table border="0" class="login-table">
                <tbody>
                    <tr>
                        <td class="input-label">Username:</td>
                        <td class="input-field">
                            <input type="text" name="username" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td class="input-label">Password:</td>
                        <td class="input-field">
                            <input type="password" name="password" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="input-field">
                            <input type="checkbox" name="remember" id="remember" />
                            <label for="remember">Remember me!</label>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="submit-button">
                            <input type="submit" value="Login" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>

