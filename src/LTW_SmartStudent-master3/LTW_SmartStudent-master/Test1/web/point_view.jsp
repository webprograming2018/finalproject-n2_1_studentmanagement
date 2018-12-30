<%-- 
    Document   : point_view
    Created on : Dec 26, 2018, 10:01:35 AM
    Author     : LuongThanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem Diem</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container" style="margin-top: 30px;">
            <div class="row">
                <!--form nhap ten sinh vien + ki hoc-->

                <form  role="form" action="Timetable" method="post">
                    <div  class="col-xs-12 col-sm-8 col-md-8 col-md-offset-2">

                        <div class="col-xs-12 col-sm-8 col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" name="masv" placeholder="Enter Your Username">
                            </div>
                        </div>


                        <div class="col-xs-12 col-sm-2 col-md-2">
                            <select class="form-control">
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
        <!---- end form nhap usser name + ki hoc -->
        <span>${message}</span>

        <!--- bang diem -->
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-8 col-md-offset-2">
                    <h2 class="text-center">Bảng điểm</h2>
                    <table  class="table-bordered table-hover table-responsive" style="width: 100%">
                        <thead >
                            <tr>
                                <th width="20%" class="text-center">MÔN HỌC</th>
                                <th width="15%" class="text-center">CC</th>
                                <th width="15%" class="text-center">TH</th>
                                <th width="15%" class="text-center">BT</th>
                                <th width="15%" class="text-center">KT</th>
                                <th width="20%" class="text-center">TRUNG BÌNH</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="element" items="${Subject}">
                                <tr class="text-center">
                                    <td><c:out value = "${element.getNameSub()}"/></td>
                                    <td><c:out value = "${element.getCc()}"/></td>
                                    <td><c:out value = "${element.getTh()}"/></td>
                                    <td><c:out value = "${element.getBt()}"/></td>
                                    <td><c:out value = "${element.getKi()}"/></td>
                                    <td><c:out value = "${element.getAverage()}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                </div>
            </div>
        </div>

        <!--- ket thuc bang diem he 10 -->

        <!-- bang diem he 4 -->
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-4 col-md-offset-5" style="margin-top:30px">

                    <table  class="table-bordered table-hover table-responsive">
                        <thead >
                            <tr>
                                <th width="50%" class="text-center">HỆ SỐ 4</th>
                                <th width="50%" class="text-center">TRUNG BÌNH</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td class="text-center">${averageF}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
                <div class="text-center">
                    <a style="font-weight: bold" href="home.jsp">Quay lại</a>
                </div>
        </div>
        <!-- end bang diem he 4 -->


    </body>