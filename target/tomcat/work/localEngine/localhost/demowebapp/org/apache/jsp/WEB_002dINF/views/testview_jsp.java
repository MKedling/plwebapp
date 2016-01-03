package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userSession.user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"list-group\">\r\n");
      out.write("\t<div class=\"pagination\">\r\n");
      out.write("\t\t<span class=\"plus_minus\" data-name=\"quantity\" data-value=\"0\" data-id=\"10\"></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${matches}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" var=\"match\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"list-group-item\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.starttime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t   \t\t<span class=\"team_name\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.homeTeam}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t   \t\t<span id=\"home_team_match_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"plus_minus home_team\" data-name=\"score_home\" data-value=\"0\" data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></span>\r\n");
      out.write("\t\t   \t</div>\r\n");
      out.write("\t\t   \t<div>\r\n");
      out.write("\t\t   \t\t<span class=\"team_name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.awayTeam}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t   \t\t<span id=\"away_team_match_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"plus_minus away_team\" data-name=\"score_away\" data-value=\"0\" data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></span>\r\n");
      out.write("\t\t   \t</div>\r\n");
      out.write("\t\t   \t\r\n");
      out.write("\t\t   \t\t<input type=\"hidden\" name=\"match_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /> \r\n");
      out.write("\t\t   \t\t<button type=\"button\" class=\"btn btn-primary bet\" value=\"\">Primary</button> \t\r\n");
      out.write("\t\t   \t\t\r\n");
      out.write("\t   \t</div>\t\r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t   \t\r\n");
      out.write("\t   \t \r\n");
      out.write("\t</c:forEach>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t<form method=\"post\" action=\"/demowebapp/plapp/admin\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Admin\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t<c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bets}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" var=\"bet\">\r\n");
      out.write("\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bet.ID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t</c:forEach>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
