<%-- 
    Document   : checkout
    Created on : Jul 6, 2024, 10:22:21 PM
    Author     : Trần Ngọc Huyền
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="boostrap/bootstrap.min.css"/>
        <script src="boostrap/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
        <style>
            .shopping-cart-body .quantity a:hover {
                color: black;
            }

            .shopping-cart-body .quantity a {
                color: black;
            }
            .shopping-cart-body .quantity {
                display: flex;
                /*align-items: center;*/
                justify-content: center;
            }
            .shopping-cart-body .quantity button {
                width: 32px;
                height: 32px;
                border: 0;
                background: #fff;
                border: 1px solid rgba(0, 0, 0, .09);
                display: flex;
                align-items: center;
                justify-content: center;
            }
            .shopping-cart-body .quantity input {
                width: 50px;
                height: 32px;
                border: 1px solid rgba(0, 0, 0, .09);
                border-left: 0;
                border-right: 0;
                text-align: center;
            }

        </style>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <div class="container mt-4">
            <table class="table align-middle table-borderless shopping-cart-table text-center">
                <thead class="">
                    <tr>
                        <th>Num</th>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Line total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <c:set var="cart" value="${sessionScope.cart}"/>
                <c:set var="t" value="0"/>
                <tbody class="shopping-cart-body">
                    <c:forEach items="${cart.items}" var="i">
                        <c:set var="t" value="${t + 1}" />
                        <tr>
                            <td>${t}</td>
                            <td class="text-start">
                                <img src="${i.product.image}" alt="alt" width="100px" height="100px">
                                ${i.product.name}
                            </td>
                            <td>
                                <c:if test="${i.product.discount != 0}">
                                    <del class="text-danger pe-2">
                                        $<fmt:formatNumber pattern="#,##0" value="${i.product.price}"/>
                                    </del>
                                </c:if>
                                $<fmt:formatNumber pattern="#,##0" value="${i.price}"/>
                            </td>
                            <td class="quantity">
                                <button><a href="process?num=-1&pid=${i.product.id}">-</a></button>
                                <input type="text" value="${i.quantity}" readonly>
                                <button><a href="process?num=1&pid=${i.product.id}">+</a></button>
                            </td>
                            <td>
                                $<fmt:formatNumber pattern="#,##0" value="${i.price * i.quantity}"/></td>
                            <td>
                                <form action="process" method="post">
                                    <input type="hidden" name="pid" value="${i.product.id}"/>
                                    <input type="submit" value="Remove item" class="btn btn-danger rounded"/>
                                </form>
                            </td>
                        </tr>
                            <c:if test="${cart != null}">
                            <tr >
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>   
                                <td class="text-center">

                                    <div class="subtotal">
                                        Subtotal: <span class="fw-bold" style="color: #FFC600">$<fmt:formatNumber pattern="#,##0" value="${cart.totalMoney}"/></span>
                                    </div>
                                    <div class="checkout ps-3 mt-3">
                                        <form action="checkout" method="post">
                                            <input type="submit" value="Checkout" class="px-4 btn btn-warning rounded">
                                        </form>
                                    </div>


                                </td>
                            </tr>
                              </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <section>
                <div class="subtotal-container text-end" style="font-size: 20px;">


                </div>
                <div class="action-button-container">
                </div>
            </section>
        </div>
    </body>
</html>
