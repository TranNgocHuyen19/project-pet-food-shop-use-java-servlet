/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BrandDAO;
import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Brand;
import model.Cart;
import model.CartItem;
import model.Category;
import model.Product;

/**
 *
 * @author Trần Ngọc Huyền
 */
@WebServlet(name="BuyServlet", urlPatterns={"/buy"})
public class BuyServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuyServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if(o == null) {
            cart = new Cart();
        } else {
            cart = (Cart) o; 
        }
        String id_raw = request.getParameter("pid");
        ProductDAO pdb = new ProductDAO();
        long id = 0;
        try {
            id = Long.parseLong(id_raw);
            
            Product p = pdb.getProductById(id);
            CartItem i = new CartItem(p, 1, p.getPrice() * (100 - p.getDiscount()) / 100);
            cart.addItem(i);
            request.setAttribute("id", p);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        List<Product> listp = pdb.getAll();
        int page, numperpage = 6;
        int size = listp.size();
        int num = (size % numperpage == 0 ?  size / numperpage : size / numperpage + 1);
        String xpage = request.getParameter("page");
        if(xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Product> list = pdb.getListByPage(listp, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("listp", list);
        
        List<CartItem> listC = cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("size", listC.size());
        
        CategoryDAO cdb = new CategoryDAO();
        List<Category> listc = cdb.getAll();
        request.setAttribute("listc", listc);
        
        BrandDAO bdb = new BrandDAO();
        List<Brand> listb = bdb.getAll();
        request.setAttribute("listb", listb);
        
         request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
