/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspCServletContext/1.0
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class replicateAccForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n\n\n<dialog id=\"frmReplicateEditDlg\" class=\"dlg\" oncancel=\"return false;\">\n  <div class=\"form-std\">\n    <div class=\"dialog-title\">\n      ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg('Import_acc_entries')}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n      <button onclick=\"closeDlgCareful('frmReplicateEdit')\" class=\"btn-close\">x</button>\n    </div>\n    <form id=\"frmReplicateEditFrm\" action=\"replicator\" method=\"POST\" target=\"_blank\">\n      <table class=\"tbl-fieldset\">\n        <tr>\n          <td>\n            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"user_name\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(":</label>\n          </td>\n          <td>\n            <div style=\"display: flex;\">\n              <input name=\"userName\" value=\"\">\n            </div>\n          </td>\n        </tr>\n        <tr>\n          <td>\n            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"user_pass\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(":</label>\n          </td>\n          <td>\n            <div style=\"display: flex;\">\n              <input type=\"password\" name=\"userPass\" value=\"\">\n            </div>\n          </td>\n        </tr>\n        <tr>\n          <td>\n            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"url_source\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(":</label>\n          </td>\n          <td>\n            <div style=\"display: flex;\">\n              <b>https://</b> <input name=\"urlSource\" required value=\"localhost:8433/beige-accounting-web/secure/sendEntities\">\n            </div>\n          </td>\n        </tr>\n        <tr>\n          <td>\n            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"max_records_per_transaction\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(":</label>\n          </td>\n          <td>\n            <div style=\"display: flex;\">\n              <input type=\"number\" required name=\"maxRecords\" value=\"100\">\n              <input type=\"hidden\" name=\"replicatorName\" value=\"replicatorTaxMarket\">\n              <input type=\"hidden\" name=\"writerName\" value=\"dbWriterXmlReplTaxMarket\">\n            </div>\n          </td>\n        </tr>\n        <tr>\n          <td>\n            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"requestedDatabaseId\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(":</label>\n          </td>\n          <td>\n            <div style=\"display: flex;\">\n              <input type=\"number\" required name=\"requestedDatabaseId\">\n            </div>\n          </td>\n        </tr>\n        <tr>\n          <td>\n            <label for=\"replicationMethodId\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg('ReplicationAccMethod')}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(":</label>\n          </td>\n          <td>\n            <div class=\"input-line\">\n              <input class=\"picked-appearence\" id=\"replicationMethodAppearanceVisible\" disabled=\"disabled\" type=\"text\" onchange=\"inputHasBeenChanged(this);\">\n              <input id=\"replicationMethodId\" required type=\"hidden\" name=\"replicationMethodId\">\n              <button type=\"button\" class=\"btn\" onclick=\"openEntityPicker('ReplicationAccMethod', 'replication', 'Method', '&nmHnd=handlerEntityRequest&mobile=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.mobile}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\">...</button>\n              <button type=\"button\" class=\"btn\" onclick=\"clearSelectedEntity('replicationMethod');\">X</button>\n            </div>\n          </td>\n        </tr>\n      </table>\n      <div class=\"form-actions\">\n        <button type=\"button\" onclick=\"submitFormForNewWindow('frmReplicateEditFrm', false)\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"Replicate\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</button>\n        <button type=\"button\" onclick=\"closeDlgCareful('frmReplicateEdit');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"Close\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n        <input style=\"display: none\" id=\"frmReplicateEditFrmFakeSubmit\" type=\"submit\"/>\n      </div>\n    </form>\n  </div>\n</dialog>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
