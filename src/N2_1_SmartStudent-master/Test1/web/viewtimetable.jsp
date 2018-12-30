<%-- 
    Document   : viewtimetable
    Created on : Dec 25, 2018, 3:44:33 AM
    Author     : LuongThanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-8 col-md-offset-2">
                    <form action="Timetable" method="post">
                        <input type="hidden" name="action" value="Xoa"> 
                        <h1>PERSONAL TIMETABLE</h1>
                          <div class="col-xs-12 col-sm-4 col-md-4">
                              <label for="weeks">theo tuần</label>
                            <select id="weeks" name="week_id" class="form-control">
                                <option value="1">Tuần 1</option>
                                <option value="2">Tuần 2</option> 
                            </select>

                        </div>
                        <div class="col-xs-12 col-sm-2 col-md-2"style="margin-top: 25px;">
                            <button type="submit" class="btn btn-primary">Xem</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container" style="margin-top:30px;">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-8 col-md-offset-2">
                    <h2 class="text-center">Lịch học</h2>
                    <table  class="table-bordered table-hover table-responsive" style="width: 100%">
                        <thead >
                           <tr>
                                <th width="20%" class="text-center">Thu</th>
                                <th width="10%" class="text-center">Ca</th>
                                <th width="25%" class="text-center">Mon Hoc</th>
                                <th width="15%" class="text-center">Phong Hoc</th>
                                <th width="30%" class="text-center">Giang Vien</th>
                            </tr>
                        </thead>
                        <tbody>
                             <c:forEach var="element" items="${Lesson}">
                                <tr class="text-center">
                                    <td><c:out value = "${element.getDay()}"/></td>
                                    <td><c:out value = "${element.getShift()}" /></td>
                                    <td><c:out value = "${element.getSubject()}"/></td>
                                    <td><c:out value = "${element.getRoom()}"/></td>
                                    <td><c:out value = "${element.getTeacher()}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-center">
                    <a style="font-weight: bold" href="home.jsp">Quay lại</a>
                </div>
                </div>
            </div>
        </div>
           
     </body>
     </html>
