/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dto.BrandDTO;
import dto.CategoryDTO;
import dto.ProductDTO;
import dto.UnitDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import service.BrandService;
import service.CategoryService;
import service.EmployeeService;
import service.ProductService;
import service.UnitService;
import servicebean.ImageStorageBean;
//



@WebServlet("/product")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class EditProductServlet extends HttpServlet{
    
    @EJB 
    private ProductService productService;
    
    @EJB
    private UnitService unitService;
    
    @EJB
    private BrandService brandService;
    
    @EJB
    private CategoryService categoryService;
    
    @EJB
    private EmployeeService employeeService;
    @EJB
    private ImageStorageBean imageStorageBean;
        
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String methodType = req.getParameter("methodType");
//        
//        if(methodType.equals("POST"))
//        {
//            doPost(req, resp);
//            return;
//        }
//        if(!methodType.equals("PUT")) return;
        System.out.println("Content-Type: " + req.getContentType());       
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8"); 
        
        Part filePart = req.getPart("productImage");
        boolean uploaded = uploadProductImage(filePart);
        
        if(!uploaded){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Lưu thất bại. Vui lòng chọn ảnh sản phẩm.\"}");
            return;
        }
        
        ProductDTO p = extractProduct(req, resp);
        if (p == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Lưu thất bại. Dữ liệu không hợp lệ.\"}");
            
            return;
        }
        if(p.getId()==null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Lưu thất bại. Dữ liệu sản phẩm này chưa được tạo.\"}");
            return;
        }
        if(productService.findById(p.getId()) == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Lưu thất bại. Không tìm thấy mã sản phẩm này.\"}");
            return;
        }
        updateProduct(p);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("{\"message\": \"Cập nhật sản phẩm thành công.\", \"redirect\": \"/BTL-Retail-EJB-war/product-manage\"}");     
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodType = req.getParameter("methodType");
        if ("PUT".equals(methodType)) {
            doPut(req, resp);
            return;
        }
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        Part filePart = req.getPart("productImage");
        boolean uploaded = uploadProductImage(filePart);
        if(!uploaded){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Thêm thất bại. Vui lòng chọn ảnh sản phẩm.\"}");
            return;
        } 
        
        ProductDTO p  = extractProduct(req, resp);
        if (p == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\": \"Thêm thất bại. Không tìm thấy dữ liệu của sản phẩm để lưu.\"}");
            return;
        }
        addProduct(p);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("{\"message\": \"Thêm sản phẩm thành công!\", \"redirect\": \"/BTL-Retail-EJB-war/product-manage\"}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id");

        if(productId == null){
            req.setAttribute("product", new ProductDTO());
            req.setAttribute("methodType", "POST");
        }else{
            ProductDTO p = productService.findById(productId);
            if(p == null){
                req.setAttribute("message", "Không tìm thấy sản phẩm để chỉnh sửa.");
                req.setAttribute("alertType", "error");
                req.getRequestDispatcher("/product-manage").forward(req, resp);
                return;
            }
            InputStream imageFile = imageStorageBean.getImage(p.getId());
            if(imageFile != null){
                String productImage =imageStorageBean.convertToBase64(imageFile);
                req.setAttribute("productImage", productImage);
            }

            req.setAttribute("product", p);
            req.setAttribute("methodType", "PUT");
        }
        
        
        List<UnitDTO> units = unitService.findAll();
        if(units != null) req.setAttribute("units", units);
        
        List<CategoryDTO> categories = categoryService.findAll();
        if(categories !=null )req.setAttribute("categories",  categories);

        List<BrandDTO> brands = brandService.findAll();
        if(brands != null ) req.setAttribute("brands", brands);
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    
    private void updateProduct(ProductDTO product){
        productService.update(product);
    }
    
    private void addProduct(ProductDTO product){
        productService.add(product);
    }
    
    private boolean uploadProductImage(Part filePart) throws IOException{
        if(filePart == null || filePart.getSize()<1) return false;
        
        String fileName = getFileName(filePart);
        if(fileName == null ) return false;    
        
        try(InputStream input = filePart.getInputStream()){
            imageStorageBean.saveImage(fileName, input);
        }
        return true;
    }
    
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }

    
    private ProductDTO extractProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        ProductDTO p = new ProductDTO();
        String productId = req.getParameter("productId");

        String productName = extractProductName(req);
        if(productName == null) return null;

        Integer productPrice = extractProductPrice(req);
        if(productPrice == null ) return null;

        UnitDTO productUnit = extractProductUnit(req);
        if(productUnit == null ) return null;
        
        Short productQuantity = extractProductQuantity(req);
        if(productQuantity == null) return null;

        CategoryDTO productCategory = extractProductCategory(req);
        if(productCategory == null) return null;

        BrandDTO productBrand = extractProductBrand(req);
        if(productBrand == null) return null;

        String productDetail = extractedProductDetail(req);
        if(productDetail == null) return null;
        
        p.setId(productId);
        p.setName(productName);
        p.setPrice(productPrice);
        p.setUnit(productUnit);
        p.setQuantity(productQuantity);
        p.setCategory(productCategory);
        p.setBrand(productBrand);
        p.setDetail(productDetail);
        p.setLastUpdate(new Date());
        if(p.getCreatedAt() == null) p.setCreatedAt(p.getLastUpdate());
        p.setEmployee(employeeService.findById("NV001"));
        
        return p;
    }

    private String extractProductName(HttpServletRequest req) {
        String dFromReq = req.getParameter("productName");
        if(dFromReq == null ||dFromReq.trim().isEmpty()) 
        {
            System.err.println("Product null: " +dFromReq);
            
//            req.setAttribute("message", "Tên của sản phẩm không được để trống.");
            return null;
        } 
        return dFromReq.trim();
    }

    private Integer extractProductPrice(HttpServletRequest req) {
        String dFromReq = req.getParameter("productPrice");
        if(dFromReq == null || dFromReq.trim().isEmpty()) 
        {
            req.setAttribute("message", "Giá của sản phẩm không được để trống.");
            return null;
        }
        try{
            return Integer.valueOf(dFromReq.trim());
        }catch (NumberFormatException e){
            System.err.println("Không thể chuyển giá sản phẩm thành số: " + e);
            req.setAttribute("message", "Giá sản phẩm chỉ bao gồm các chữ số.");
            return null;
        }
    }

    private UnitDTO extractProductUnit(HttpServletRequest req) {
        String dFromReq = req.getParameter("productUnit");
        if(dFromReq == null || dFromReq.trim().isEmpty()) 
        {
            req.setAttribute("message", "Vui lòng chọn đơn vị cho sản phẩm.");
            return null;
        }
        
        UnitDTO u = unitService.findById(dFromReq.trim());
        if(u == null) {
            req.setAttribute("message", "Đơn vị không hợp lệ. Vui lòng chọn lại.");
            return null;
        }    
        return u;
    }

    private Short extractProductQuantity(HttpServletRequest req) {
        String dFromReq = req.getParameter("productQuantity");
        if(dFromReq == null || dFromReq.trim().isEmpty()) 
        {
            req.setAttribute("message", "Vui lòng nhập số lượng sản phẩm.");
            return null;
        }
        try{
            return Short.valueOf(dFromReq.trim());
        }catch (NumberFormatException e)
        {
            System.err.println("Lỗi chuyển số lượng sản phẩm thành số: " + e);
            req.setAttribute("message", "Số lượng sản phẩm chỉ bao gồm các chữ số nguyên.");
            return null;
        }    
    }

    private CategoryDTO extractProductCategory(HttpServletRequest req) {
        String dFromReq = req.getParameter("productCategory");
        if(dFromReq == null || dFromReq.trim().isEmpty()) 
        {
            req.setAttribute("message", "Vui lòng chọn phân loại sản phẩm.");
            return null;
        }
        CategoryDTO c = categoryService.findById(dFromReq.trim());
        if(c == null) {
            req.setAttribute("message", "Phân loại sản phẩm không hợp lệ. Vui lòng chọn lại.");
            return null;
        }
        return c;  
    }

    private BrandDTO extractProductBrand(HttpServletRequest req) {
        String dFromReq = req.getParameter("productBrand");
        if(dFromReq == null || dFromReq.trim().isEmpty()) {
            req.setAttribute("message", "Vui lòng chọn nhà cung cấp sản phẩm.");
            return null;
        }
        BrandDTO b = brandService.findById(dFromReq);
        if(b == null) {
            req.setAttribute("message", "Nhà cung cấp sản phẩm không hợp lệ. Vui lòng chọn lại.");
            return null;
        }
        return b;
    }

    private String extractedProductDetail(HttpServletRequest req) { 
        String dFromReq = req.getParameter("productDetail");//Duoc null
        return dFromReq;    
    }
    
    
}
//        if(productId == null || productId.isEmpty()){
//            p = new ProductDTO();
//        }else{
//            p = productService.findById(productId);
//            if(p == null){
//                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Lưu thất bại. Sản phẩm này không tồn tại.");
//                return null;
//            }
//        }


//        BufferedReader reader = req.getReader();
//        StringBuilder json = new StringBuilder();
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            json.append(line);
//        }
//        System.out.println("Received JSON: " + json.toString());
//        System.err.println("Giá trị id: "+req.getParameter("productId"));
//        System.out.println("Giá trị tên của product: " + req.getParameter("productName"));
//        System.err.println("Giá trị tên của product: " + req.getParameter("productCategory"));
//        System.err.println("Giá trị tên của product: " + req.getParameter("productBrand"));
//        System.err.println("Giá trị tên của product: " + req.getParameter("productDetail"));