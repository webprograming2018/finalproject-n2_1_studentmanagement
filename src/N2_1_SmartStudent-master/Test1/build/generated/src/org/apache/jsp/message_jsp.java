package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Message;
import java.util.ArrayList;
import java.util.ArrayList;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\"/>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Ke hoach ca nhan</title>\n");
      out.write("        <style>\n");
      out.write("            ._in{\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                display: inline-block;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("            button, #_creat {\n");
      out.write("                border: 1px solid black;\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 49%;\n");
      out.write("            }\n");
      out.write("            button:hover {\n");
      out.write("                opacity: 0.5;\n");
      out.write("                color: red;\n");
      out.write("                font-size: 100%;\n");
      out.write("            }\n");
      out.write("            #_creat:hover{\n");
      out.write("                font-size: 100%;\n");
      out.write("                color: red;\n");
      out.write("                opacity: 0.5;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .modal {\n");
      out.write("                display: none; \n");
      out.write("                position: fixed; \n");
      out.write("                z-index: 1;\n");
      out.write("                left: 0;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%; \n");
      out.write("                height: 100%; \n");
      out.write("                overflow: auto; \n");
      out.write("                background-color: rgb(0,0,0); \n");
      out.write("                background-color: rgba(0,0,0,0.4);\n");
      out.write("                padding-top: 60px;\n");
      out.write("            }\n");
      out.write("            ._head {\n");
      out.write("                font-size: 150%;\n");
      out.write("                text-align: center;\n");
      out.write("                margin: 24px 0 12px 0;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .cancelbtn {\n");
      out.write("                width: auto;\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                width: 49%;\n");
      out.write("            }\n");
      out.write("            .container {\n");
      out.write("                padding: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .modal-content {\n");
      out.write("                background-color: #fefefe;\n");
      out.write("                margin: 5% auto 15% auto; \n");
      out.write("                border: 1px solid #888;\n");
      out.write("                width: 80%; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .close {\n");
      out.write("                position: absolute;\n");
      out.write("                right: 25px;\n");
      out.write("                top: 0;\n");
      out.write("                color: #000;\n");
      out.write("                font-size: 35px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("            .close:hover,\n");
      out.write("            .close:focus {\n");
      out.write("                color: red;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .animate {\n");
      out.write("                -webkit-animation: animatezoom 0.6s;\n");
      out.write("                animation: animatezoom 0.6s\n");
      out.write("            }\n");
      out.write("            @-webkit-keyframes animatezoom {\n");
      out.write("                from {-webkit-transform: scale(0)} \n");
      out.write("                to {-webkit-transform: scale(1)}\n");
      out.write("            }\n");
      out.write("            @keyframes animatezoom {\n");
      out.write("                from {transform: scale(0)} \n");
      out.write("                to {transform: scale(1)}\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- gioa dien update- -->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row col-md-8 col-md-offset-2 custyle\" style=\"margin-top:50px\">\n");
      out.write("                <form action=\"#\" method=\"post\" >\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"search\">\n");
      out.write("                    <div class=\"pull-left col-md-4\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"date\" class=\"form-control\"  name=\"date\" required=\"true\" id=\"setDefault\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"pull-left col-md-2\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"submit\" value=\"Search\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    var today = moment().format('YYYY-MM-DD');\n");
      out.write("                    document.getElementById(\"setDefault\").value = today;\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("                <button class=\"btn btn-primary pull-right\" onclick=\"document.getElementById('formADD').style.display = 'block'\" style=\"width:auto;\"><strong>+ </strong>Add Message</button>\n");
      out.write("\n");
      out.write("                ");

                    ArrayList<Message> list = (ArrayList< Message>) request.getSession().getAttribute("listMessage");
                    if (list.isEmpty()) {
                
      out.write("\n");
      out.write("                <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                ");
 } else {
      out.write("   \n");
      out.write("                <table class=\"table table-striped custab\">\n");
      out.write("\n");
      out.write("                    <thead>\t\t\t\t\t\t\n");
      out.write("                        <tr>\n");
      out.write("                            <th>STT</th>\n");
      out.write("                            <th>Dealine</th>\n");
      out.write("                            <th>Content</th>\n");
      out.write("                            <th class=\"text-center\">Action</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            String keyDateSearch = (String) request.getSession().getAttribute("keyDateSearch");
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println(list.get(i).toString());
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span id=\"stt\" >");
      out.print( i + 1);
      out.write("</span></td>\n");
      out.write("                            <td><span id=\"deadline\"> ");
      out.print( list.get(i).getDeadline_date());
      out.write("</span></td>\n");
      out.write("                            <td><span>");
      out.print( list.get(i).getContent());
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">\n");
      out.write("                                <form action=\"MessageServlet\" method=\"post\">\n");
      out.write("\n");
      out.write("                                    <input type=\"hidden\" name=\"sttMessage\" value=\"");
      out.print( i);
      out.write("\">\n");
      out.write("                                    <input type=\"hidden\" name=\"id_message\" value=\"");
      out.print( list.get(i).getId());
      out.write("\">\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("                                    <input type=\"hidden\" name=\"date\" value=\"");
      out.print( keyDateSearch);
      out.write("\" >\n");
      out.write("                                    <button class=\"btn btn-danger\"  type=\"submit\"><span class=\"glyphicon glyphicon-remove\"> Delete</span></button>\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- end giao dien update -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"formADD\" class=\"modal\">\n");
      out.write("            <form class=\"modal-content animate\" action=\"MessageServlet\" method=\"post\">\n");
      out.write("                <div class=\"_head\">\n");
      out.write("                    <span>ADD MESSAGE</span> \n");
      out.write("                    <span onclick=\"document.getElementById('formADD').style.display = 'none'\" class=\"close\" title=\"Close Modal\" >&times;</span>              \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"create\">\n");
      out.write("\n");
      out.write("                    <label for=\"date\"><b>Date: </b></label>\n");
      out.write("                    <input type=\"date\" name=\"date\" required class=\"_in\" style=\"width: 80%\"><br/>\n");
      out.write("                    <label for=\"content\"><b>Content: </b></label>\n");
      out.write("                    <textarea row=\"5\" cols=\"50\" name=\"content\" required class=\"_in\" style=\"width: 80%\"></textarea>\n");
      out.write("                    <br/>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"container\" style=\"width: 80%\">\n");
      out.write("                    <input type=\"submit\" value=\"Create\" id=\"_creat\">\n");
      out.write("                    <button type=\"button\" onclick=\"document.getElementById('formADD').style.display = 'none'\" class=\"cancelbtn\">Cancel</button>     \n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <script>\n");
      out.write("                var modal = document.getElementById('formADD');\n");
      out.write("                window.onclick = function (event) {\n");
      out.write("                    if (event.target === modal)\n");
      out.write("                        modal.style.display = \"none\";\n");
      out.write("\n");
      out.write("                };\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
