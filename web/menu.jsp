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
            .right i {
                color: #ffc600;
            }
        </style>
    </head>

    <body>
        <header class="bg-dark">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <div class="left">
                    <a href="home"><img src="images/logo.svg" alt="alt" width="80px" height="50px"></a>
                </div>
                <div class="center text-white">
                    <form action="">
                        <div class="mb-1">
                            <input type="text" name="keyword" placeholder="Search...">
                            <input type="submit" value="Search" class="bg-success text-white border-0" onclick="search()">
                        </div>
                    </form>
                </div>
                <div class="right">
                    <ul class="d-flex">
                        <c:if test="${sessionScope.user == null}">
                            <li>
                                <a href="login" class="text-white"><i class="fa-solid fa-user pe-2"></i>Sign in</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <li>
                                <a href="#" class="text-white"><i class="fa-solid fa-user pe-2"></i>${sessionScope.user.fullName}</a>
                            </li>
                            <li>
                                <a href="#" class="text-white"><i class="fa-solid fa-cart-shopping pe-2"></i>Cart</a>
                                <a href="cart.jsp" style="background: #ffc600; color: #000" class="px-1 rounded-circle text-center">${sessionScope.size}</a>
                            </li>
                            <li>
                                <a href="logout" class="text-white"><i class="fa-solid fa-arrow-right-from-bracket pe-2"></i>Logout</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </header>
    </body>
</html>
