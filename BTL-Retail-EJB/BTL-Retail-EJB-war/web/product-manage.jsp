<%-- 
    Document   : product-manage
    Created on : Mar 20, 2025, 6:22:30 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <h2>Danh sách sản phẩm</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Ngày cập nhật</th>
        </tr>
        <c:choose>
            <c:when test="${not empty products}">
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price} VND</td>
                        <td>${product.quantity}</td>
                        <td>${product.lastUpdate}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr><td colspan="5">Không có sản phẩm nào</td></tr>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>

