<%@page import="Model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <script src="bootstrap/js/bootstrap.min.js"></script>

        <title>Ke hoach ca nhan</title>
        <style>
            ._in{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            button, #_creat {
                border: 1px solid black;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 49%;
            }
            button:hover {
                opacity: 0.5;
                color: red;
                font-size: 100%;
            }
            #_creat:hover{
                font-size: 100%;
                color: red;
                opacity: 0.5;
            }

            .modal {
                display: none; 
                position: fixed; 
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%; 
                height: 100%; 
                overflow: auto; 
                background-color: rgb(0,0,0); 
                background-color: rgba(0,0,0,0.4);
                padding-top: 60px;
            }
            ._head {
                font-size: 150%;
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
            }
            .cancelbtn {
                width: auto;
                padding: 14px 20px;
                margin: 8px 0;
                width: 49%;
            }
            .container {
                padding: 16px;
            }

            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; 
                border: 1px solid #888;
                width: 80%; 
            }

            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }
            table{
                border: 1px solid black;
            }
            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }
            @-webkit-keyframes animatezoom {
                from {-webkit-transform: scale(0)} 
                to {-webkit-transform: scale(1)}
            }
            @keyframes animatezoom {
                from {transform: scale(0)} 
                to {transform: scale(1)}
            }
        </style>
    </head>
    <body>
        
        <!-- gioa dien update- -->
        <div class="container">
            <div class="row col-md-8 col-md-offset-2 custyle" style="margin-top:50px">
                <form action="#" method="post" >
                    <input type="hidden" name="action" value="search">
                    <div class="pull-left col-md-4">
                        <div class="form-group">
                            <input type="date" class="form-control"  name="date" required="true" id="setDefault">
                        </div>

                    </div>
                    <div class="pull-left col-md-2">
                        <div class="form-group">
                            <input type="submit" value="Search" class="form-control">
                        </div>
                    </div>

                </form>

                <script>
                    
                    
                </script>

                <button class="btn btn-primary pull-right" onclick="document.getElementById('formADD').style.display = 'block'" style="width:auto;"><strong>+ </strong>Add Message</button>

                <%
                    ArrayList<Message> list = (ArrayList< Message>) request.getSession().getAttribute("listMessage");
                    if (list.isEmpty()) {
                %>
                <span>${message}</span>
                <% } else {%>   
                <table class="table table-striped custab">

                    <thead>						
                        <tr>
                            <th>STT</th>
                            <th>Dealine</th>
                            <th>Content</th>
                            <th class="text-center">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String keyDateSearch = (String) request.getSession().getAttribute("keyDateSearch");
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println(list.get(i).toString());
                        %>
                        <tr>
                            <td><span id="stt" ><%= i + 1%></span></td>
                            <td><span id="deadline"> <%= list.get(i).getDeadline_date()%></span></td>
                            <td><span><%= list.get(i).getContent()%></td>
                            <td class="text-center">
                                <form action="MessageServlet" method="post">

                                    <input type="hidden" name="sttMessage" value="<%= i%>">
                                    <input type="hidden" name="id_message" value="<%= list.get(i).getId()%>">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="date" value="<%= keyDateSearch%>" >
                                    <button class="btn btn-danger"  type="submit"><span class="glyphicon glyphicon-remove"> Delete</span></button>
                                </form>
                            </td>

                        </tr>
                        <% }%>

                    </tbody>

                </table>
                <% }%>
                <div class="text-center">
                    <a style="font-weight: bold" href="home.jsp">Quay lại</a>
                </div>
            </div>
        </div>
        <!-- end giao dien update -->


        <div id="formADD" class="modal">
            <form class="modal-content animate" action="MessageServlet" method="post">
                <div class="_head">
                    <span>ADD MESSAGE</span> 
                    <span onclick="document.getElementById('formADD').style.display = 'none'" class="close" title="Close Modal" >&times;</span>              
                </div>

                <div class="container">
                    <input type="hidden" name="action" value="create">

                    <label for="date"><b>Date: </b></label>
                    <input type="date" name="date" required class="_in" style="width: 80%"><br/>
                    <label for="content"><b>Content: </b></label>
                    <textarea row="5" cols="50" name="content" required class="_in" style="width: 80%"></textarea>
                    <br/>
                </div>

                <div class="container" style="width: 80%">
                    <input type="submit" value="Create" id="_creat">
                    <button type="button" onclick="document.getElementById('formADD').style.display = 'none'" class="cancelbtn">Cancel</button>     
                </div>
            </form>
            <script>
                var modal = document.getElementById('formADD');
                window.onclick = function (event) {
                    if (event.target === modal)
                        modal.style.display = "none";

                };
            </script>
        </div>
    </body>
</html>

