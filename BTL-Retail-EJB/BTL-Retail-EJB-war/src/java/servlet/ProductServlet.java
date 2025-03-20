/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dto.ProductDTO;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductService;

@WebServlet("/product-manage")
public class ProductServlet extends HttpServlet{
    @EJB
    private ProductService productService;

    public ProductServlet() {
        super();
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        List<ProductDTO> products = productService.findAll();
        request.setAttribute("products",products);
            request.getRequestDispatcher("/product-manage.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
