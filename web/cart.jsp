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
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <div class="container">
            <table class="table align-middle table-borderless shopping-cart-table text-center">
                <thead class="text-center">
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
                            <td>
                                <img src="${i.product.image}" alt="alt" width="100px" height="100px">
                                ${i.product.name}
                            </td>
                            <td><fmt:formatNumber pattern="##.#" value="${i.price}"/></td>
                            <td>
                                <input type="number" value="${i.quantity}">
                            </td>
                            <td><fmt:formatNumber pattern="##.#" value="${i.price * i.quantity}"/></td>
                            <td>
                                <form action="process" method="post">
                                    <input type="hidden" name="id" value="${i.product.id}"/>
                                    <input type="submit" value="Return item"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <section>
                <div class="subtotal-container">
                </div>
                <div class="action-button-container">
                </div>
            </section>
        </div>
    </body>
</html>
