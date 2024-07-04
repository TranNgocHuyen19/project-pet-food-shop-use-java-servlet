<%-- 
    Document   : menu
    Created on : Jul 2, 2024, 5:12:58 PM
    Author     : Trần Ngọc Huyền
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="boostrap/bootstrap.min.css"/>
        <script src="boostrap/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
        <style>
            a {
                text-decoration: none;
                color: white;
            }
            ul {
                margin: 0;
                padding: 0;
                list-style-type: none;
            }
            li {
                padding: 0 20px;
            }
        </style>
    </head>

    <body>
        <header class="bg-dark">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <div class="left">
                    <img src="images/logo.svg" alt="alt" width="80px" height="50px">
                </div>
                <div class="center text-white">
                    <a href="shop">Shopping</a>
                </div>
                <div class="right">
                    <ul class="d-flex">
                        <c:if test="${sessionScope.user == null}">
                            <li>
                                <a href="login" class="text-white">Login</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <li>
                                <a href="#" class="text-white">${sessionScope.user.fullName}</a>
                            </li>
                            <li>
                                <a href="logout" class="text-white">Logout</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </header>
    </body>
</html>
