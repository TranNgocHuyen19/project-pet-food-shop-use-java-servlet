<%-- 
    Document   : login
    Created on : Jul 2, 2024, 5:23:21 PM
    Author     : Trần Ngọc Huyền
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="boostrap/bootstrap.min.css"/>
        <script src="boostrap/bootstrap.bundle.min.js"></script>
        <title>Login Page</title>
    </head>
    <style>
        form {
            width: 30%;
            margin: auto;
        }
        a{
            text-decoration: none;
            color: black;
        }
    </style>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container mt-5">
            <h5 class="text-danger text-center">${requestScope.error}</h5>
            <h3 class="text-center">Login</h3>
            <form action="login" method="post">
                <h6 class="text-danger"></h6>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" name="email" id="email" class="form-control" placeholder="Email"/>
                </div>
                <div class="mb-3">
                    <label for="pass" class="form-label">Password</label>
                    <input type="password" name="pass" id="pass" class="form-control" placeholder="Password"/>
                </div>
                <div class="mb-3">
                    <input type="submit" value="Login" class="border-0 rounded p-1 px-3 text-center" style="background: #FFC600">
                </div>
            </form>
            <p class="text-center"><a href="signup.jsp">Create an Account</a></p>
        </div>
    </body>
</html>
