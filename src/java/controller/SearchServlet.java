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
import java.util.List;
import model.Brand;
import model.Category;
import model.Product;

/**
 *
 * @author Trần Ngọc Huyền
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet SearchServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get keyword from form search
        String key = request.getParameter("keyword");
        if (key == null) {
            key = "";
        }

        //Get selected category ids from checkbox in a left sidebar
        String[] cids_raw = request.getParameterValues("cid");
        long[] cids1 = null;
        if (cids_raw != null) {
            cids1 = new long[cids_raw.length];
            for (int i = 0; i < cids1.length; i++) {
                cids1[i] = Long.parseLong(cids_raw[i]);
            }
        }
        
        //Get selected brand ids from checkbox in a left sidebar
        String[] bids_raw = request.getParameterValues("bid");
        long[] bids1 = null;
        if (bids_raw != null) {
            bids1 = new long[bids_raw.length];
            for (int i = 0; i < bids1.length; i++) {
                bids1[i] = Long.parseLong(bids_raw[i]);
            }
        }
        
        //Sort
        String sort = request.getParameter("sort");
        if(sort == null) {
            sort = "id_asc";
        }
        String sortBy = sort.split("_")[0];
        String order = sort.split("_")[1];
        
        ProductDAO pdb = new ProductDAO();
        List<Product> listp = pdb.seachProductsByCriteria(key, cids1, bids1, sortBy, order);
        
        //Maintain checked state of category checkboxes
        CategoryDAO cdb = new CategoryDAO();
        List<Category> listc = cdb.getAll();
        boolean[] cid2 = new boolean[listc.size()];
        for (int i = 0; i < cid2.length; i++) {
            if(isCheck(listc.get(i).getId(), cids1)) {
                cid2[i] = true;
            } else {
                cid2[i] = false;
            }
        }
        
        //Maintain checked state of category checkboxes
        BrandDAO bdb = new BrandDAO();
        List<Brand> listb = bdb.getAll();
        boolean[] bid2 = new boolean[listb.size()];
        for (int i = 0; i < bid2.length; i++) {
            if(isCheck(listb.get(i).getId(), bids1)) {
                bid2[i] = true;
            } else {
                bid2[i] = false;
            }
        }
        
        //Pagination
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
        List<Product> listt = pdb.getListByPage(listp, start, end);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        
        request.setAttribute("keyword", key);
        request.setAttribute("listp", listt);
     
        request.setAttribute("listc", listc);
        request.setAttribute("cid", cid2);

        request.setAttribute("listb", listb);
        request.setAttribute("bid", bid2);
        
        request.setAttribute("sort", sort);
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
    
     private boolean isCheck(long d, long[] id) {
        if(id == null)
            return false;
        else {
            for (int i = 0; i < id.length; i++) {
                if(id[i] == d)
                    return true;
            }
            return false;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
