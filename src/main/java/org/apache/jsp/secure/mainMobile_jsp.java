/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspCServletContext/1.0
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainMobile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n\n<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n  <script type=\"text/javascript\" src=\"../static/js/beige.ajax.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/beige.form.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/beige.accounting.js\"></script>\n  <script type=\"text/javascript\" src=\"../static/js/beige.i18n.en.js\"></script>\n  <link rel=\"icon\" type=\"image/png\" href=\"../static/img/favicon.png\">\n  <link rel=\"stylesheet\" href=\"../static/css/beige.common.css\" />\n  <title>Beige Accounting</title>\n</head>\n<body>\n\n  <div class=\"navbar\">\n    <div class=\"dropdown\">\n      <a href=\"#\" class=\"dropdown-btn\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Work\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      <div class=\"dropdown-content\">\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=DebtorCreditorCategory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"DebtorCreditorCategorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=DebtorCreditor&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"DebtorCreditors\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=ServicePurchasedCategory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"ServicePurchasedCategorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=ServicePurchased&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"ServicePurchaseds\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=PrepaymentTo&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"PrepaymentTos\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=PurchaseInvoice&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"PurchaseInvoices\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=PaymentTo&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"PaymentTos\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=PurchaseReturn&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"PurchaseReturns\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=PrepaymentFrom&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"PrepaymentFroms\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=ServiceToSaleCategory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"ServiceToSaleCategorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=ServiceToSale&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"ServiceToSales\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=SalesInvoice&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"SalesInvoices\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=PaymentFrom&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"PaymentFroms\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=SalesReturn&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"SalesReturns\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=ManufacturingProcess&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"ManufacturingProcesss\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Manufacture&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Manufactures\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=EmployeeCategory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"EmployeeCategorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Employee&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Employees\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=WageType&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"WageTypes\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=WageTaxTable&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"WageTaxTables\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Wage&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Wages\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      </div>\n    </div>\n    <div class=\"dropdown\">\n      <a href=\"#\" class=\"dropdown-btn\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Warehouse\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      <div class=\"dropdown-content\">\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Warehouse&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Warehouses\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=WarehouseSite&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"WarehouseSites\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=InvItemType&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"InvItemTypes\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=InvItemCategory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"InvItemCategorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=InvItemTaxCategory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"InvItemTaxCategorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=InvItem&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"InvItems\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=BeginningInventory&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"BeginningInventorys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=GoodsLoss&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"GoodsLosss\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=MoveItems&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"MoveItemss\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"warehouseRests/?nmRnd=warehouseRests\" target=\"_blank\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"warehouse_rests\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"warehouseSiteRests/?nmRnd=warehouseSiteRests\" target=\"_blank\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"warehouse_site_rests\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      </div>\n    </div>\n    <div class=\"dropdown\">\n      <a href=\"#\" class=\"dropdown-btn\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Accounting\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      <div class=\"dropdown-content\">\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=AccSettings&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"AccSettings\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Expense&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Expenses\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=BankAccount&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"BankAccounts\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Property&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Propertys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=UnitOfMeasure&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"UnitOfMeasures\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Tax&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Taxs\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Currency&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Currencys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=Account&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Accounts\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=AccountingEntries&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"AccountingEntriess\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listWholeJson&nmEnt=ReplicationAccMethod&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"ReplicationAccMethods\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmHnd=handlerEntityRequest&nmsAct=list&nmRnd=listAccEntriesWholeJson&nmEnt=AccountingEntry&page=1&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"AccountingEntrys\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'report/?nmRnd=replicateAccFormJson');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Import_acc_entries\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'report/?nmRnd=ledgerFormJson&mobile=mobile/');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Ledger\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'report/?nmRnd=balanceFormJson');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"TrialBalance\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n         <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'report/?nmRnd=balanceSheetFormJson');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"balance_sheet\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n      </div>\n    </div>\n    <div class=\"dropdown\">\n      <a href=\"#\" class=\"dropdown-btn\">...</a>\n      <div class=\"dropdown-content\">\n        <a href=\"#\" onclick=\"getHtmlByAjax('GET', 'service/?nmRnd=aboutJson&nmHnd=hndAbout');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"about\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n        ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n      </div>\n    </div>\n  </div>  \n\n  <div id=\"lstMainPlace\">\n  </div>\n  \n  <div id=\"frmMainPlace\">\n  </div>\n\n  <div id=\"frmSubPlace\">\n  </div>\n\n  <div id=\"frmReport\">\n  </div>\n\n  <div id=\"frmReplicate\">\n  </div>\n\n  <div id=\"pickersPlace\">\n  </div>\n\n  <div id=\"pickersPlaceDub\">\n  </div>\n\n  <div id=\"targetInfo\">\n  </div>\n\n  <dialog id=\"dlgConfirm\" class=\"dlg dlg-alert\">\n      <div class=\"confirm\">\n        <div class=\"dialog-title confirm-title\">\n          Conformation.\n          <button onclick=\"document.getElementById('dlgConfirm').close();\" class=\"btn-close btn-confirm\">x</button>\n        </div>\n        <div id=\"confirmPlace\" class=\"msg-place\">\n        </div>\n        <div class=\"dlg-actions\">\n          <button id=\"confirmYes\" class=\"btn btn-act btn-confirm\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"Yes\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</button>\n          <button onclick=\"document.getElementById('dlgConfirm').close();\" class=\"btn btn-act btn-confirm\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"No\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
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
    // /secure/mainMobile.jsp(85,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty pageContext['request'].userPrincipal}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n          <a href=\"../index.jsp?logoff=true\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext['request'].userPrincipal.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write(' ');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"logout\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
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

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /secure/mainMobile.jsp(88,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty pageContext['request'].userPrincipal}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n          <a href=\"../\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.getAttribute(\"srvI18n\").getMsg(\"exit\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</a>\n        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
