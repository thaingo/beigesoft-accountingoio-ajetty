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

public final class wsSeSeller_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n  <script type=\"text/javascript\" src=\"../static/js/beige.ajax.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/beige.form.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/beige.accounting.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/jquery-3.3.1.min.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/autoNumeric.js\"></script>\n  <link rel=\"icon\" type=\"image/png\" href=\"../static/img/favicon.png\">\n  <script type=\"text/javascript\" src=\"../static/js/beige.i18n.");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reqVars.lang}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(".js\"></script>\n  <link rel=\"stylesheet\" href=\"../static/css/beige.common.css\" />\n  <title>Beigesoft™ Web Store Admin</title>\n</head>\n<body>\n\n  <div class=\"navbar\">\n    <div class=\"dropdown\">\n      <a href=\"#\" class=\"dropdown-btn\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"CatalogGs\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      <div class=\"dropdown-content\">\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeGoods&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeGoodss\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeService&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeServices\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=I18nSeGoods&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"I18nSeGoodss\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=I18nSeService&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"I18nSeServices\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeGoodsPlace&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeGoodsPlaces\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeServicePlace&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeServicePlaces\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeGoodsSpecifics&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeGoodsSpecificss\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeServiceSpecifics&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeServiceSpecificss\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=SeGoodsPrice&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeGoodsPrices\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmsAct=list&nmRnd=listWholeJson&nmEnt=ServicePrice&page=1');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"SeServicePrices\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      </div>\n    </div>\n    <div class=\"dropdown\">\n      <a href=\"#\" class=\"dropdown-btn\">...</a>\n      <div class=\"dropdown-content\">\n        <a href=\"../\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"exit\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n      </div>\n    </div>\n  </div>  \n\n  <div id=\"lstMainPlace\">\n  </div>\n  \n  <div id=\"frmMainPlace\">\n  </div>\n\n  <div id=\"frmSubPlace\">\n  </div>\n\n  <div id=\"frmReport\">\n  </div>\n\n  <div id=\"frmReplicate\">\n  </div>\n\n  <div id=\"pickersPlace\">\n  </div>\n\n  <div id=\"pickersPlaceDub\">\n  </div>\n\n  <div id=\"targetInfo\">\n  </div>\n\n  <dialog id=\"dlgConfirm\" class=\"dlg dlg-alert\">\n      <div class=\"confirm\">\n        <div class=\"dialog-title confirm-title\">\n          Conformation.\n          <button onclick=\"document.getElementById('dlgConfirm').close();\" class=\"btn-close btn-confirm\">x</button>\n        </div>\n        <div id=\"confirmPlace\" class=\"msg-place\">\n        </div>\n        <div class=\"dlg-actions\">\n          <button id=\"confirmYes\" class=\"btn btn-act btn-confirm\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"Yes\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</button>\n          <button onclick=\"document.getElementById('dlgConfirm').close();\" class=\"btn btn-act btn-confirm\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"No\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</button>\n        </div>\n     </div>\n  </dialog>\n\n  <dialog id=\"dlgError\" class=\"dlg dlg-alert\">\n    <div class=\"error\">\n      <div class=\"dialog-title error-title\">\n        Error!\n        <button onclick=\"document.getElementById('dlgError').close()\" class=\"btn-close btn-error\">x</button>\n      </div>\n      <div id=\"errorPlace\" class=\"msg-place\">\n      </div>\n   </div>\n  </dialog>\n\n  <dialog id=\"dlgWarning\" class=\"dlg dlg-alert\">\n    <div class=\"warning\">\n      <div class=\"dialog-title warning-title\">\n        Warning!\n        <button onclick=\"document.getElementById('dlgWarning').close()\" class=\"btn-close btn-warning\">x</button>\n      </div>\n      <div id=\"warningPlace\" class=\"msg-place\">\n      </div>\n   </div>\n  </dialog>\n\n  <div id=\"dlgSuccess\" class=\"dlg-notifier\">\n    <div class=\"success\">\n      <div class=\"dialog-title success-title\">\n        Success!\n        <button onclick=\"document.getElementById('dlgSuccess').close()\" class=\"btn-close btn-success\">x</button>\n      </div>\n      <div id=\"successPlace\" class=\"msg-place\">\n");
      out.write("      </div>\n   </div>\n  </div>\n\n</body>\n</html>\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/wsSeSeller.jsp(40,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty pageContext['request'].userPrincipal}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n          <a href=\"../?logoff=true\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext['request'].userPrincipal.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write(' ');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${srvI18n.getMsg(\"logout\", reqVars.lang)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</a>\n        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}