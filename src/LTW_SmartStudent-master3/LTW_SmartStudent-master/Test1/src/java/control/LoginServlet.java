/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Model.Message;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mothod.ViewLogin;
import mothod.ViewMessage;

/**
 *
 * @author LuongThanh
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
       String url = "/login.jsp";
        ServletContext sc = getServletContext();

        // connect database
        Configuration con = new Configuration();

        //kiem tra login
        String action = request.getParameter("action");
        if (action.equals("Login")) {
            String id = request.getParameter("username");
            String pass = request.getParameter("password");
            String message;
            
            HttpSession session = request.getSession();
            
            Student user = (Student) session.getAttribute("user");
            if (id == null || pass == null) {
                url = "/login.jsp";
                message = "Please input user and password";
            } else {
                user = new ViewLogin().checkUser(con.getConnetion(),id,pass);
                if (user == null) {
                    url = "/login.jsp";
                    message = "user or password faile or not exist";
                } else {
                    url = "/home.jsp";
                    message = "";
                    session.setAttribute("connectionDB", con.getConnetion());
                    
                    ViewMessage vm = new ViewMessage();
                    try {
                        ArrayList<Message> listMess = vm.getMessageByCurrentDate(con.getConnetion(), user.getIdSV());
                        Collections.sort(listMess);
                        for(Message i: listMess)
                            System.out.println(i.toString());
                        session.setAttribute("newMessage", listMess);
                    } catch (ParseException ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                }
            }
            session.setAttribute("user", user);
            session.setAttribute("message", message);
        }
        sc.getRequestDispatcher(url).forward(request, response);
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
