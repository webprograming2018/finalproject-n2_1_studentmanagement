<%-- 
    Document   : timetable
    Created on : Dec 23, 2018, 9:29:41 AM
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
        <title>Timetable</title>
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
        </form>
        
</html>
