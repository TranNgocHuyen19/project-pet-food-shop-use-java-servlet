<%-- 
    Document   : home
    Created on : Jul 3, 2024, 9:49:21 AM
    Author     : Trần Ngọc Huyền
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="boostrap/bootstrap.min.css"/>
        <script src="boostrap/bootstrap.bundle.min.js"></script>
        <style>
            /* Pagination */
            .pagination {
                display: inline-block;
            }

            .pagination a {
                color: black;
                font-size: 14px;
                float: left;
                padding: 8px 16px;
                font-weight: bold;
                text-decoration: none;
            }

            .pagination a.active {
                text-decoration: underline;
            }

            .pagination a:hover {
                color: #000;
            }

            .pagination a:hover:not(.active) {
                text-decoration: underline;
            }
        </style>
    </head>


    <body>
        <%@include file="menu.jsp"%>
        <main class="container-fluid d-flex mt-3">
            <c:set var="listc" value="${requestScope.listc}"/>
            <c:set var="listp" value="${requestScope.listp}"/>
            <c:set var="listb" value="${requestScope.listb}"/>
            <div class="sidebar" style="width: 25%">
                <h3>Categories</h3>
                <img src="images/divide.svg" alt="alt"/>
                <form action="">
                    <c:forEach begin="0" end="${listc.size() - 1}" var="i"> 
                        <div class="mb-1">
                            <input type="checkbox" name="id" id="cat" value="${listc.get(i).getId()}">
                            <label for="cat" class="form-label ps-2">${listc.get(i).getName()}</label>
                        </div>
                    </c:forEach>
                </form>
                <h3>Filter by price</h3>
                <img src="images/divide.svg" alt="alt"/>
                <form action="search">
                    <input type="range" min="0" max="50">
                </form>
                <h3>Product brands</h3>
                <img src="images/divide.svg" alt="alt"/>
                <form action="search">
                    <c:forEach begin="0" end="${listb.size() - 1}" var="i"> 
                        <div class="mb-1">
                            <input type="checkbox" name="id" id="brand" value="${listb.get(i).getId()}">
                            <label for="brand" class="form-label ps-2">${listb.get(i).getName()}</label>
                        </div>
                    </c:forEach>
                </form>

            </div>
            <div class="listproduct" style="width: 75%">
                <select name="sort" style="float: right" class="my-2">
                    <option value="df">Default sorting</option>
                    <option value="second">text2</option>
                    <option value="third">text3</option>
                </select>
                <div class="clearfix" style="clear: both">

                </div>
                <hr>
                <div class="row">
                    <c:forEach items="${requestScope.listp}" var="p">
                        <div class="col-4 mb-4 text-center position-relative">
                            <div class="box border border-1">
                                <img src="${p.image}" alt="alt" class="w-75"/>
                                <p>${p.name}</p>
                                <p class="d-flex justify-content-center align-items-center fw-bold">
                                    <c:if test="${p.discount != 0}">
                                        <del class="text-danger pe-2 fs-6">
                                            $<fmt:formatNumber value="${p.price}" pattern="##,##" />
                                        </del>
                                    </c:if>
                                    <span class="fs-5">
                                        $<fmt:formatNumber value="${p.price * (100-p.discount) / 100}" pattern="##,##" />
                                    </span>
                                </p>
                            </div>
                            <c:if test="${p.discount != 0}">
                                <div class="discount position-absolute top-0 left-0 bg-danger text-white rounded">
                                    <p class="m-0 p-2 fw-bold">
                                        - <fmt:formatNumber value="${p.discount}" pattern="##"/>%
                                    </p>
                                </div>
                            </c:if>
                        </div>
                    </c:forEach>
                    <div class="pagination">
                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                            <a class="${i == page ? "active" : ""}" href="home?page=${i}">${i}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
