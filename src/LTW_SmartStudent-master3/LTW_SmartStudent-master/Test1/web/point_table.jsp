<%-- 
    Document   : point_table
    Created on : Dec 26, 2018, 9:57:20 AM
    Author     : LuongThanh
--%>

<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem Điểm</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!--        <form action="Point" mothod="post">
                    <input type="text" placeholder="Enter Your Username" name="masv" value="Manh">
                    <input type="submit" value="Xem">
                    <select id="semesters" name="semester">
                        <option value="1">Ki 1</option>
                        <option value="2">Ki 2</option>
                    </select>
        
                </form>-->
        <div class="container" style="margin-top: 30px;">
            <div class="row">
                <!--form nhap ten sinh vien + ki hoc-->

                <form action="Point" mothod="post">
                    <div  class="col-xs-12 col-sm-8 col-md-8 col-md-offset-2">

                        <div class="col-xs-12 col-sm-8 col-md-8">
                            <div class="form-group">
                                <%
                                    Student s = (Student) session.getAttribute("user");
                                    
                                %>
                                <input type="text" class="form-control" name="masv" placeholder="Enter Your Username" value="<%= s.getUser()%>">
                            </div>
                        </div>


                        <div class="col-xs-12 col-sm-2 col-md-2">
                            <select class="form-control" id="semesters" name="semester">
                                <option value="1">Ki 1</option>
                                <option value="2">Ki 2</option> 
                            </select>

                        </div>


                        <div class="col-xs-12 col-sm-2 col-md-2">
                            <button type="submit" class="btn btn-primary">Xem</button>
                        </div>


                    </div>

                </form>

            </div>
        </div>
        <!--        hết from nhap tên sinh viên với kỳ học-->
    </body>
</html>