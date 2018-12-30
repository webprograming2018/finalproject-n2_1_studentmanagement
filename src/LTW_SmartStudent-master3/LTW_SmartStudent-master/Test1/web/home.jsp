<%@page import="java.sql.Connection"%>
<%@page import="mothod.ViewMessage"%>
<%@page import="Model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="Model.Student" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Trang chủ</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <style>
        .iconTB{
            font-size: 30px;
        }
        .tbTop{
            font-size: 20px;
            font-weight: bold;
            color: red;
        }
        .tenUser{
            background: #9e9e9e36;
            border-radius: 5px;
            padding: 20px;
            font-size: 120%;
        }
       
    </style>
    <body>
        <%
            Date d = new Date(System.currentTimeMillis());
            request.getSession().setAttribute("keyDateSearch", d.toString());
            ArrayList<Message> list = new ArrayList<Message>();
            request.getSession().setAttribute("listMessage", list);
            String linkMessage = "MessageServlet?action=search&date=" + d.toString();

            Student s = (Student) session.getAttribute("user");
            ArrayList<Message> listMess = (ArrayList<Message>) request.getSession().getAttribute("newMessage");
        %>
        <h2 class="text-center"style="font-weight: bold;">Quản lý sinh viên</h2>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="text-center tenUser">
                        <span style="font-weight: bold;border-bottom: red 2px solid;">Hello <%= s.getName()%><span>
                    </div>
                    <div class="text-center menu">
                        <ul class="nav">
                            <li><a href="home.jsp">Trang chủ</a></li>
                            <li><a href="http://www.myptit.net/">Ôn thi cùng MyPTIT</a></li>

                            <li><a href="<%= linkMessage%>">Quản lý cá nhân</a></li>
                            <li><a href="timetable.jsp">Xem thời khóa biểu</a></li>
                            <li><a href="point_table.jsp">Xem điểm</a></li>
                            <li class=""><a href="login.jsp">Logout</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-9 main ">
                    
                    <%
                        if (listMess.size() >= 1) {
                    %>
                    <div class="sukienTop">

                        <div class="tbsukienTop"style="padding: 20px;">
                            <div class="text-center iconTB">
                                  <p class="glyphicon glyphicon-bell"></p>
                                </div>
                            <div class="text-center">
                                <span class="tbTop"><%= listMess.get(0).getContent()%></span>
                                <span class="tbTop"> <%= listMess.get(0).getDeadline_date()%> </span>
                            </div>
                        </div>
                    </div>
                    <div class="sukien">
                        <%
                            for (int i = 1; i < listMess.size() ; i++) {
                        %>
                        <div>
                            <span><%= listMess.get(i).getContent()%></span>
                            <span> <%= listMess.get(i).getDeadline_date()%> </span>
                        </div>
                        <% }%>
                    </div>
                    <%  
                        } else { 
                    %>
                    <span class="text-center" style="font-style:normal;color: blue; font-weight: bold;"> Ban chua co thong bao </span>
                    <% } %>
                </div>
            </div>
        </div>

    </body>
</html>
