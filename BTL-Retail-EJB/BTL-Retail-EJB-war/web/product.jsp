<%@page import="dto.ProductDTO"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=add_box" />
        <style>
            .custom-file-upload {
                height: 70%;
                width: 100%;
                display: flex;
                flex-direction: column;
                gap: 20px;
                cursor: pointer;
                align-items: center;
                justify-content: center;
                border: 2px dashed #cacaca;
                background-color: rgba(255, 255, 255, 1);
                padding: 1.5rem;
                box-sizing: border-box;
                border-radius: 10px;
                box-shadow: 0px 48px 35px -48px rgba(0,0,0,0.1);
              }

              .custom-file-upload .icon {
                max-height: 100%;
                max-width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
              }

              .custom-file-upload .icon img {
                min-height: 80px;
                max-height: 100%;
                max-width: 100%;
                color: rgba(75, 85, 99, 1);
              }

              .custom-file-upload .text {
                display: flex;
                align-items: center;
                justify-content: center;
              }

              .custom-file-upload .text span {
                font-weight: 400;
                color: rgba(75, 85, 99, 1);
              }

              .custom-file-upload input {
                display: none;
              }
        </style>
        
        <title>Sản phẩm</title>
    </head>
    <body class="p-12 flex flex-col justify-between min-h-screen w-full bg-gray-200">
        <div class="px-10 py-5  border-2 border-gray-100 shadow-md rounded-lg bg-white">
            <h2 class="text-3xl font-bold text-clifford text-orange-500 h-10 pb-5 ">Thông tin sản phẩm</h2>
            <form id="productForm" enctype="multipart/form-data" action="/BTL-Retail-EJB-war/product" method="${methodType}"
                class ="flex flex-row justify-between text-lg text-gray-800">
                    <div class ="flex flex-col justify-around  min-w-[300px] w-[60%] pl-10 py-5 pr-20">
                            <div class ="flex flex-col justify-center">
                                <input type="hidden" name="productId" id="productId" value="${product.id}">
                                <label class="font-semibold">Tên sản phẩm</label>
                                <input  type="text" name="productName" id="productName" value="${product.name}"
                                        placeholder="Vui lòng nhập tên sản phẩm..."
                                        class=" px-3 py-[8px] 
                                            border border-gray-300 rounded bg-white shadow-sm
                                            focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">
                            </div>
                            <div class="flex justify-between pt-3">
                                <div class ="flex flex-col justify-center min-w-[45%]">
                                    <label >Giá</label>
                                    <input type="number" name="productPrice"  value="${product.price}" 
                                        placeholder="10.000" step="1000"
                                        class="px-3 py-1 border border-gray-300 rounded bg-white shadow-sm
                                                focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">
                                </div>
                                <div class ="flex flex-col justify-center min-w-[38%]">
                                    <label>Đơn vị</label>
                                    <select id="unitSelected" name="productUnit"
                                        class=" px-3 py-1 border border-gray-300 rounded bg-white shadow-sm
                                                focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">
                                        <c:choose>
                                            <c:when test="${not empty units}">
                                                <c:forEach var="unit" items="${units}">
                                                    <option value="${unit.id}" ${unit.id == product.unit.id ? 'selected="selected"' : ''}>${unit.name}</option>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <option>Không có đơn vị hợp lệ.</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>  
                            </div>
                            <div class="flex justify-between pt-3">
                                <div class ="flex flex-col justify-center min-w-[35%]">
                                    <label >Số lượng</label>
                                    <input  type="number"  name="productQuantity" value="${product.quantity}"
                                            placeholder="0" min="0" max="100000"
                                            class=" px-3 py-1  border border-gray-300 rounded bg-white shadow-sm
                                                    focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">
                                </div>
                                <div class ="flex flex-col justify-center min-w-[38%]">
                                    <label >Phân loại</label>
                                    <select name="productCategory" 
                                        class=" px-3 py-1  border border-gray-300 rounded bg-white shadow-sm
                                                    focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">
                                        <c:choose>
                                            <c:when test="${not empty categories}">
                                                <c:forEach var="category" items="${categories}">
                                                    <option value="${category.id}" ${category.id == product.category.id ? 'selected="selected"' : ''}>${category.name}</option>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <option>Không có phân loại hợp lệ.</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>  
                            </div>


                            <div class="flex flex-col justify-center pt-3">
                                <label >Nhà cung cấp</label>
                                <select name="productBrand"
                                    class=" px-3 py-1  border border-gray-300 rounded bg-white shadow-sm
                                                    focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">
                                    <c:choose>
                                        <c:when test="${not empty brands}">
                                            <c:forEach var="brand" items="${brands}">
                                                <option value="${brand.id}" ${brand.id == product.brand.id ? 'selected="selected"' : ''}>${brand.name}</option>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <option>Không có nhà cung cấp hợp lệ.</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                            <div class="flex flex-col justify-center pt-3">
                                <label class="font-semibold">Mô tả sản phẩm</label>
                                <textarea name="productDetail"  placeholder="Nhập mô tả sản phẩm ở đây..." rows="6"
                                            class=" px-3 py-1  border border-gray-300 rounded bg-white shadow-sm
                                                focus:outline-none focus:ring-2 focus:ring-orange-200 focus:shadow-md">${product.detail}</textarea>
                             </div>
                    </div>
                    <div class="flex flex-col w-[38%] px-8 py-5 ">
                        <div class="h-[100%]">
                            <div class="pb-5">
                                <label  class="font-semibold">Hình ảnh sản phẩm</label>   
                            </div>
                            <label class="custom-file-upload">
                                <div class="icon">
<!--                                    <img id="preview" src="<%= request.getContextPath() %>/resources/icons/icon.svg" alt="My Icon"  height="150px">-->
                                    <img id="preview" 
                                        src="<%= request.getAttribute("productImage") != null ? "data:image/png;base64," + request.getAttribute("productImage") : request.getContextPath() + "/resources/icons/icon.svg" %>" 
                                        alt="My Icon" height="150px">
                                </div>
                                <div class="text" <%= request.getAttribute("productImage") != null ? "style='display: none;'" : "" %>>
                                   <span>Nhấn vào để chọn ảnh</span>
                                   </div>
                                    <input name="productImage" type="file" id="productImage" onchange="previewImage(event)">
                            </label>
                                <div class="w-[100%] pl-5 py-3 ">
                                    <label class="file_name_title text-gray-600 pr-2"style="display: none;"> Tên file:</label>
                                    <label class="file_name  w-[100%] text-blue-700" style="display: none;"></label>
                                </div>
                        </div>
                        <div class="">
                            <input type="hidden" id="methodType" name="methodType" value="${methodType}">
                            <button type="button"  onclick="submitForm()"
                                    class=" px-4 py-1 border border-gray-300 rounded bg-blue-600 shadow-sm text-white mr-5
                                           hover:outline-none hover:ring-2 hover:ring-blue-200 hover:bg-blue-500" >
                                Lưu sản phẩm</button>
                            <button type="button" onclick="history.back()"
                                    class=" px-8 py-1 border border-gray-300 rounded bg-gray-300 shadow-sm text-gray-600
                                            hover:outline-none hover:ring-2 hover:ring-gray-200 hover:bg-gray-200">
                                Quay lại</button>
                        </div>
                    </div>
            </form>
        </div>
    </body>
    
    <script>
    function previewImage(event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new   FileReader();
            reader.onload = function (e) {
                let img = document.getElementById("preview");
                img.src = e.target.result;
                img.width = 500;
                img.height = 500;
                document.querySelector(".custom-file-upload .text").style.display = "none";
                document.querySelector(".file_name").textContent = file.name;
                document.querySelector(".file_name_title").style.display ="inline";
                document.querySelector(".file_name").style.display ="inline";
                
            };
            reader.readAsDataURL(file);
        }
    }
    
    function submitForm() {
        event.preventDefault(); // Ngăn chặn submit mặc định

        var form = document.getElementById("productForm");
        var formData = new FormData(form);

        fetch(form.action, {
            method: "POST", // Lấy phương thức (POST, PUT,...)
            body: formData
        })
        .then(response => response.json()) 
        .then(data => {
            alert(data.message); // Hiển thị thông báo
            if(data.redirect){
                window.location.href = data.redirect; 
            }
        })
        .catch(error => console.error("Lỗi:", error));

    }
    
    function convertToJpg(file, quality = 1) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = function (event) {
                const img = new Image();
                img.src = event.target.result;
                img.onload = function () {
                    const canvas = document.createElement("canvas");
                    const ctx = canvas.getContext("2d");

                    // Giữ nguyên kích thước ảnh
                    canvas.width = img.width;
                    canvas.height = img.height;
                    ctx.drawImage(img, 0, 0);

                    // Chuyển đổi sang JPG
                    canvas.toBlob(blob => resolve(blob), "image/jpeg", quality);
                };
            };
            reader.onerror = reject;
            reader.readAsDataURL(file);
        });
    }
    
    
  
</script>
</html>
