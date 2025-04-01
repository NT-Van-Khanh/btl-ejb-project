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
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=add_box" />
    <title>Danh sách sản phẩm</title>
    <style>
        
        
    </style>
</head>
<body class="p-6 flex flex-col justify-center min-h-screen w-full">
    <h2 class="text-3xl font-bold text-clifford">Danh sách sản phẩm</h2>
    <div class ="flex justify-between py-3">
        <div class ="flex justify-center pr-3">
            <input type="search" class="w-[200px]"placeholder="Nhập nội dung tìm kiếm">
            <button type="button" class="bg-orange-400 text-[16px] rounded hover:bg-orange-500 transition
                    text-white px-[0.6em] py-[0.2em] border border-gray-400 shadow-md" >Tìm kiếm</button>
        </div>
        <div class ="flex justify-center items-center ">
            <button type="button" class="text-[16px] rounded hover:bg-blue-400 transition
                    px-[0.6em] py-[0.2em] border border-gray-200 flex items-center bg-blue-500 text-gray-100">
                <span class="material-symbols-outlined pr-2"> add_box </span> Thêm sản phẩm</button>
            <label class="ml-5 pr-2">Sắp xếp: </label>
            <select class="text-[16px] rounded hover:bg-gray-100 transition
                    px-[0.6em] py-[0.2em] border border-gray-400 flex items-center">Theo ngày tạo
                <option value="first">Theo ngày tạo</option>
                <option value="second">Theo tên</option>
                <option value="third">Theo lần cập nhật cuối</option>
                <option value="f">Theo số lượng</option>
            </select>

        </div>
    </div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Đơn vị</th>
            <th>Số lượng</th>
            <th>Ngày cập nhật</th>
            <th>Cập nhật</th>
            <th>Trạng thái </th>
        </tr>
        <c:choose>
            <c:when test="${not empty products}">
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.unit.name}</td>
                        <td>${product.price} VND</td>
                        <td>${product.quantity}</td>
                        <td>${product.lastUpdate}</td>
                        <td><button>Cập nhật</button></td>
                        <td><button>Ngừng bán</button><td/>
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

