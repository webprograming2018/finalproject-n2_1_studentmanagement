/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import mothod.ViewMessage;
import Model.Message;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SONY
 */
@WebServlet(name = "MessageServlet", urlPatterns = {"/MessageServlet"})
public class MessageServlet extends HttpServlet {

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
            out.println("<title>Servlet MessageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MessageServlet at " + request.getParameter("date") + "</h1>");
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
//        processRequest(request, response);
        doPost(request, response);
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
//        processRequest(request, response);
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String url = "/message.jsp";
        String message = "";

        String action = request.getParameter("action");
        if (action.isEmpty()) {
            action = "search";
        }

        // lay thanh vien dang su dung
        Student sv = (Student) session.getAttribute("user");

        // lay ngay tim kiem hoac tao moi message
        java.sql.Date currentDay = new java.sql.Date(System.currentTimeMillis());
        String date = request.getParameter("date").isEmpty() ? currentDay.toString() : request.getParameter("date");
        log(date);

        // ngay tim kiem message truoc do
        String keyDateSearch = (String) session.getAttribute("keyDateSearch");
        if (keyDateSearch.isEmpty()) {
            keyDateSearch = currentDay.toString();
        }

        //doi string thanh date 
        java.sql.Date sqlDate = new java.sql.Date(0);
        java.sql.Date sqlDateKey = new java.sql.Date(0);
        try {
            java.util.Date sdf1;
            if (date.indexOf("-") == 2) {
                sdf1 = new SimpleDateFormat("MM-dd-yyyy").parse(date);
            } else {
                sdf1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
            java.util.Date sdf2 = new SimpleDateFormat("yyyy-MM-dd").parse(keyDateSearch);
            sqlDate.setTime(sdf1.getTime());
            sqlDateKey.setTime(sdf2.getTime());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        // so sanh 2 ngay sqlDate va sqlDateKey
        boolean flag = sqlDate.after(sqlDateKey);
        if (sqlDate.equals(sqlDateKey)) {
            flag = true;
        }

        // lay danh sach message tim truoc do
        ArrayList<Message> listMessage = (ArrayList<Message>) session.getAttribute("listMessage");
        if (listMessage.isEmpty()) {
            listMessage = new ArrayList<>();
        }

        // khoi tao ket noi DB
        ViewMessage vm = new ViewMessage();
        Connection connection = (Connection) session.getAttribute("connectionDB"); // connectionDB tao khi login 

        if (action.equals("create")) {
            //xu ly tao message moi
            String content = request.getParameter("content");
            Message msg = new Message();
            msg.setContent(content);
            msg.setDeadline_date(sqlDate);
            msg.setStudent_id(sv.getIdSV());
            System.out.println(vm.insertMessage(connection, msg));
            if (!flag) {
                // search theo sqlDate < sqlDateKey
                listMessage.add(msg);
                Collections.sort(listMessage);
                session.setAttribute("listMessage", listMessage);
            }
        } else if (action.equals("delete")) {
            int id_message = Integer.parseInt(request.getParameter("id_message"));
            int stt = Integer.parseInt(request.getParameter("sttMessage"));
            listMessage.remove(stt);
            System.out.println(vm.deleteMessage(connection, id_message));
            session.setAttribute("listMessage", listMessage);
        }

        if (action.equals("search")) {
            if (flag) {
                session.setAttribute("keyDateSearch", sqlDate.toString());
            }
            if (!flag && !listMessage.isEmpty()) {  // xu ly ngay dang ky khi sqlDate  <= sqlDateKey
                ArrayList<Message> newListMessage = new ArrayList<>();
                for (Message i : listMessage) {
                    if (i.getDeadline_date().compareTo(sqlDate) != 1) {
                        newListMessage.add(i);
                    } else {
                        break;
                    }
                }
                session.setAttribute("listMessage", newListMessage);
                if (newListMessage.size() == 0) {
                    message = "Hay tao them thong bao moi cua ban vao ngay nay !!!";
                }
            } else {
//                try {
//                    // xu ly ngay dang ky khi sqlDate  > sqlDateKey
//                    listMessage.clear();
//                    listMessage = vm.getMessage(connection, sqlDate.toString(), sv.getIdSV());
//                    Collections.sort(listMessage);
//                    session.setAttribute("listMessage", listMessage);
//                    if (listMessage.size() == 0) {
//                        System.out.println(listMessage.size());
//                        message = "Hay tao them thong bao moi cua ban vao ngay nay !!!";
//                    }
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
            }

            session.setAttribute("message", message);
        }
        try {
            // xu ly ngay dang ky khi sqlDate  > sqlDateKey
            listMessage.clear();
            listMessage = vm.getMessage(connection, sqlDate.toString(), sv.getIdSV());
            Collections.sort(listMessage);
            session.setAttribute("listMessage", listMessage);
            if (listMessage.size() == 0) {
                System.out.println(listMessage.size());
                message = "Hay tao them thong bao moi cua ban vao ngay nay !!!";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
