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
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <main class="container-fluid d-flex mt-3">
            <div class="sidebar" style="width: 30%">

            </div>
            <div class="listproduct" style="width: 70%">
                <div class="row">
                    <c:forEach items="${requestScope.listp}" var="p">
                        <div class="col-4 mb-4 text-center position-relative">
                            <div class="box border border-1">
                                <img src="${p.image}" alt="alt" class="w-75"/>
                                <p>${p.name}</p>
                                <p class="d-flex justify-content-center align-items-center fw-bold">
                                    <c:if test="${p.discount != 0}">
                                        <del class="text-secondary pe-2 fs-6">
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

                </div>
            </div>
        </main>
    </body>
</html>
