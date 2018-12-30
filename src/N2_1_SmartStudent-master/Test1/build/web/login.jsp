<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <style>
             body {
                background: url('image/1.jpg') no-repeat fixed center center;
                background-size: cover;
            }
        </style>
    </head>
    <body>
       <!-- form login --> 
       <div class="container">
           <div class="row" style="padding-top: 80px">
               <div class="col-xs-12 col-sm-4 col-sm-offset-4" id="form-registered">
                    <div class="thumbnail">
                        <img src="image/2.png" alt="..." style="display:block; width: 200px; height: 200px; border-radius: 50%; margin: 20px auto">
                        <div class="caption">
                            <form action="LoginServlet" method="POST" role="form">
                              <div class="form-group has-feedback">
                                  <input type="hidden" name="action" value="Login">   
                                </div>
                                <div class="form-group has-feedback">
                                    <div class="input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-user"></span>
                                    </span>
                                        <input type="text" class="form-control" name ="username"   placeholder="username -- masv">
                                        <span class="glyphicon form-control-feedback"></span>
                                    </div>
                                </div>
                                <div class="form-group has-feedback">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-eye-open"></span>
                                    </span>
                                        <input type="password" class="form-control" name ="password"  placeholder="password">
                                        <span class="glyphicon form-control-feedback"></span>
                                    </div>
                                </div>
                                <div class="form-group has-feedback">
                                
        
                                <div class="form-group">
                                    <button type="submit" class="btn btn-warning" id="btn-click-creat-account" style="width: 100%"><strong>ĐĂNG NHAP</strong></button>
                                </div>
                                
                            </form>
                        </div>
                    </div>
            </div>
               
           </div>
       </div>
       
       <!-- end -form -->
    </body>
</html>