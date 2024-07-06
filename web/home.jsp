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
        <title>Home Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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

            .box {
                position: relative;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
            }

            .box:hover{
                border: 3px solid #FFC600;
                border-radius: 10px;
                background: transparent;
                transition: all 0.3s ease-in-out;
            }

            .box:hover .shop-menu {
                visibility: visible;
                transform: translateY(-50px);
                transition: all 0.3s ease-in-out;
            }

            .shop-menu {
                z-index: 999;
                position: absolute;
                top: 50%;
                left: 0%;
                visibility: hidden;
            }

            .shop-menu i {
                color: #000;
            }

            .shop-menu a {
                width: 40px;
                height: 40px;
                padding: 2px;
                display: flex;
                justify-content: center;
                align-items: center;
                border-radius: 50%;
                background: #fff;
            }

            .shop-menu a:hover {
                background: #FFC600;
            }

            .box .discount {
                top: 5%;
                left: 10%;
                font-size: 12px;
                padding: 0px 4px;
                border-radius: 40px;
            }

            .cart input {
                background: #ffc600;
                border: none;
                padding: 10px 20px;
                border-radius: 20px;
                font-weight: 500;
            }

            .blank {
                visibility: hidden;
                width: 100%;
                height: 100% ;
                position: absolute;
                background-color: #fff;
                opacity: 0.5;
                transition: all 0.3s;
                top: 0%;
                border-radius: 10px;
            }

            /*            .box:hover .blank {
                            visibility: visible;
                        }*/

            /*            .cart {
                            visibility: hidden;
                        }*/

            /*            .box:hover .cart {
                            visibility: visible;
                            transform: translateY(-10px);
                            transition: all 0.3s ease-in-out;
                        }*/


            .box:hover .price {
                display: none;
            }
        </style>
    </head>


    <body>
        <%@include file="menu.jsp"%>
        <main class="container-fluid d-flex mt-3 justify-content-between">
            <c:set var="listc" value="${requestScope.listc}"/>
            <c:set var="cid" value="${requestScope.cid}"/>
            <c:set var="listp" value="${requestScope.listp}"/>
            <c:set var="listb" value="${requestScope.listb}"/>
            <c:set var="bid" value="${requestScope.bid}"/>
            <div class="sidebar" style="width: 20%">
                <h3>Categories</h3>
                <img src="images/divide.svg" alt="alt"/>
                <c:if test="${listc != null }">
                    <c:forEach begin="0" end="${listc.size() - 1}" var="i"> 
                        <div class="mb-1">
                            <input type="checkbox" name="cid" value="${listc.get(i).getId()}"
                                   ${cid[i] ? "checked" : ""} onclick="search()">
                            ${listc.get(i).getName()}
                        </div>
                    </c:forEach>
                </c:if>
                <h3>Filter by price</h3>
                <img src="images/divide.svg" alt="alt"/>
                <form action="search">
                    <input type="range" min="0" max="50">
                </form>
                <h3>Product brands</h3>
                <img src="images/divide.svg" alt="alt"/>
                <c:if test="${listc != null }">
                    <c:forEach begin="0" end="${listb.size() - 1}" var="i"> 
                        <div class="mb-1">
                            <input type="checkbox" name="bid" value="${listb.get(i).getId()}"
                                   ${bid[i] ? "checked" : ""} onclick="search()">
                            ${listb.get(i).getName()}
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            <div class="listproduct" style="width: 75%">
                <c:set var="sort" value="${requestScope.sort}"/>
                <form action="">
                    <select name="sort" style="float: right" class="my-2" onchange="search()">
                        <option value="id_asc" ${param.sort == 'id_asc' ? 'selected' : ''}>Default sorting</option>
                        <option value="price_asc" ${param.sort == 'price_asc' ? 'selected' : ''}>Price: Low to High</option>
                        <option value="price_desc" ${param.sort == 'price_desc' ? 'selected' : ''}>Price: High to Low</option>
                    </select>
                </form>
                <div class="clearfix" style="clear: both">

                </div>
                <hr>
                <div class="row">
                    <c:forEach items="${requestScope.listp}" var="p">
                        <div class="col-4 mb-4 pt-4 text-center position-relative">
                            <div class="box w-75">
                                <div class="blank"></div>
                                <img src="${p.image}" alt="alt" class="w-100"/>
                                <ul class="shop-menu d-flex justify-content-center">
                                    <li>
                                        <a href="#"><i class="fa-solid fa-expand text-black"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa-regular fa-heart text-black"></i></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa-solid fa-code-compare text-black"></i></i></a>
                                    </li>
                                </ul>
                                <p>${p.name}</p>
                                <p class="price d-flex justify-content-center align-items-center fw-bold">
                                    <c:if test="${p.discount != 0}">
                                        <del class="text-danger pe-2">
                                            $<fmt:formatNumber value="${p.price}" pattern="##.#" />
                                        </del>
                                    </c:if>
                                    <span class="fs-5">
                                        $<fmt:formatNumber value="${p.price * (100-p.discount) / 100}" pattern="##.#" />
                                    </span>
                                </p>
                                <c:if test="${p.discount != 0}">
                                    <div class="discount position-absolute bg-danger text-white">
                                        <p class="m-0 p-1 fw-bold">
                                            - <fmt:formatNumber value="${p.discount}" pattern="##"/>%
                                        </p>
                                    </div>
                                </c:if>
                                <div class="cart">
                                    <form action="buy?pid=${p.id}" method="post">
                                        <input type="submit" value="Add to cart 🛒">
                                    </form>
                                </div>
                            </div>
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

<script>
    function search() {
    }

</script>
