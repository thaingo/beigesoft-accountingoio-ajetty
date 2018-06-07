package org.beigesoft.ajetty;

/*
 * Copyright (c) 2016 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import java.io.IOException;
import java.util.List;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import org.beigesoft.log.ILogger;
import org.beigesoft.exception.ExceptionWithCode;
import org.beigesoft.service.ISrvI18n;
import org.beigesoft.factory.IFactoryAppBeans;
import org.beigesoft.handler.IHandlerRequest;
import org.beigesoft.web.model.HttpRequestData;
import org.beigesoft.web.service.UtlJsp;
import org.beigesoft.web.service.IMngDatabaseExt;

/**
 * <p>
 * Database manager for file-based RDBMS (SQLite/H2).
 * It can create and change current database (file),
 * backup DB to global storage and restore from it,
 * also can delete database.
 * </p>
 *
 * @author Yury Demidenko
 */
@SuppressWarnings("serial")
public class WMngDatabaseExt extends HttpServlet {

  /**
   * <p>HEX letters for encoding.<p>
   **/
  private final String[] ecncodingLetters = {"0", "1", "2", "3", "4", "5",
      "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

  /**
   * <p>Folder for redirected JSP, e.g. "JSP WEB-INF/jsp/".
   * Settled through init params.</p>
   **/
  private String dirJsp;

  @Override
  public final void init() throws ServletException {
    this.dirJsp = getInitParameter("dirJsp");
  }

  @Override
  public final void doGet(final HttpServletRequest pReq,
    final HttpServletResponse pResp) throws ServletException, IOException {
    pReq.setCharacterEncoding("UTF-8");
    pResp.setCharacterEncoding("UTF-8");
    IFactoryAppBeans factoryAppBeans = null;
    try {
      factoryAppBeans = (IFactoryAppBeans) getServletContext()
          .getAttribute("IFactoryAppBeans");
      HashMap<String, Object> reqVars = new HashMap<String, Object>();
      HttpRequestData requestData = new HttpRequestData(pReq, pResp);
      requestData.setAttribute("reqVars", reqVars);
      IHandlerRequest hndlI18nRequest = (IHandlerRequest)
        factoryAppBeans.lazyGet("hndlI18nRequest");
      hndlI18nRequest.handle(reqVars, requestData);
      IMngDatabaseExt mngDatabase = (IMngDatabaseExt) factoryAppBeans
        .lazyGet("IMngDatabaseExt");
      ICryptoHelper ch = (ICryptoHelper) factoryAppBeans.
        lazyGet("ICryptoHelper");
      String nameAction = pReq.getParameter("nameAction");
      String nameDatabase = pReq.getParameter("nameDatabase");
      if (nameDatabase != null && nameDatabase.length() > 2) {
        if ("change".equals(nameAction)) {
          mngDatabase.changeDatabase(nameDatabase);
          pReq.getSession().invalidate();
        } else if ("delete".equals(nameAction)) {
          mngDatabase.deleteDatabase(nameDatabase);
        } else if ("backup".equals(nameAction)) {
          mngDatabase.backupDatabase(nameDatabase);
        } else if ("restore".equals(nameAction)) {
          mngDatabase.restoreDatabase(nameDatabase);
        }
      } else if ("encryptLogs".equals(nameAction)) {
          mngDatabase.encryptLogs();
      } else if ("decryptLogs".equals(nameAction)) {
          mngDatabase.decryptLogs();
      }
      if (ch.lazyGetOurPublicKey() != null) {
        byte[] ourPublicKey = ch.lazyGetOurPublicKey().getEncoded();
        byte[] ourPkSha1 = ch.calculateSha1(ourPublicKey);
        String ourPublicKeyStr = toHexString(ourPkSha1);
        pReq.setAttribute("ourPublicKeyStr", ourPublicKeyStr);
      }
      if (ch.lazyGetPublicKeyAnotherAjetty() != null) {
        byte[] foreignPublicKey = ch.lazyGetPublicKeyAnotherAjetty()
          .getEncoded();
        byte[] forPkSha1 = ch.calculateSha1(foreignPublicKey);
        String foreignPublicKeyStr = toHexString(forPkSha1);
        pReq.setAttribute("foreignPublicKeyStr", foreignPublicKeyStr);
      }
      List<String> databases = mngDatabase.retrieveList();
      List<String> bkDatabases = mngDatabase.retrieveBackupList();
      ISrvI18n srvI18n = (ISrvI18n) factoryAppBeans.lazyGet("ISrvI18n");
      UtlJsp utlJsp = (UtlJsp) factoryAppBeans.lazyGet("UtlJsp");
      pReq.setAttribute("databases", databases);
      pReq.setAttribute("bkDatabases", bkDatabases);
      pReq.setAttribute("backupDir", mngDatabase.getBackupDir());
      pReq.setAttribute("currDb", mngDatabase.retrieveCurrentDbName());
      pReq.setAttribute("srvI18n", srvI18n);
      pReq.setAttribute("utlJsp", utlJsp);
      String nmRnd = pReq.getParameter("nmRnd");
      String path = dirJsp + nmRnd + ".jsp";
      RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
      rd.include(pReq, pResp);
    } catch (Exception e) {
      if (factoryAppBeans != null) {
        ILogger logger = null;
        try {
          logger = (ILogger) factoryAppBeans.lazyGet("ILogger");
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        if (logger != null) {
          logger.error(null, getClass(), "WORK", e);
        } else {
          e.printStackTrace();
        }
      } else {
        e.printStackTrace();
      }
      if (e instanceof ExceptionWithCode) {
        pReq.setAttribute("error_code",
          ((ExceptionWithCode) e).getCode());
        pReq.setAttribute("short_message",
          ((ExceptionWithCode) e).getShortMessage());
      } else {
        pReq.setAttribute("error_code",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
      pReq.setAttribute("javax.servlet.error.status_code",
        HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      pReq.setAttribute("javax.servlet.error.exception", e);
      pReq.setAttribute("javax.servlet.error.request_uri",
        pReq.getRequestURI());
      pReq.setAttribute("javax.servlet.error.servlet_name", this.getClass()
        .getCanonicalName());
      pResp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
  }


  @Override
  public final void doPost(final HttpServletRequest pReq,
    final HttpServletResponse pResp) throws ServletException, IOException {
    pReq.setCharacterEncoding("UTF-8");
    pResp.setCharacterEncoding("UTF-8");
    IFactoryAppBeans factoryAppBeans = null;
    try {
      factoryAppBeans  = (IFactoryAppBeans) getServletContext()
          .getAttribute("IFactoryAppBeans");
      IMngDatabaseExt mngDatabase = (IMngDatabaseExt) factoryAppBeans
        .lazyGet("IMngDatabaseExt");
      String nameAction = pReq.getParameter("nameAction");
      String nameDatabase = pReq.getParameter("nameDatabase");
      if (nameDatabase != null && nameDatabase.length() > 2) {
        if ("create".equals(nameAction)) {
          String idDatabaseStr = pReq.getParameter("idDatabase");
          int idDatabase = Integer.parseInt(idDatabaseStr);
          mngDatabase.createDatabase(nameDatabase, idDatabase);
        } else if ("change".equals(nameAction)) {
          mngDatabase.changeDatabase(nameDatabase);
          pReq.getSession().invalidate();
        }
      }
      List<String> databases = mngDatabase.retrieveList();
      List<String> bkDatabases = mngDatabase.retrieveBackupList();
      ISrvI18n srvI18n = (ISrvI18n) factoryAppBeans.lazyGet("ISrvI18n");
      UtlJsp utlJsp = (UtlJsp) factoryAppBeans.lazyGet("UtlJsp");
      pReq.setAttribute("databases", databases);
      pReq.setAttribute("bkDatabases", bkDatabases);
      pReq.setAttribute("backupDir", mngDatabase.getBackupDir());
      pReq.setAttribute("currDb", mngDatabase.retrieveCurrentDbName());
      pReq.setAttribute("srvI18n", srvI18n);
      pReq.setAttribute("utlJsp", utlJsp);
      String nmRnd = pReq.getParameter("nmRnd");
      String path = dirJsp + nmRnd + ".jsp";
      RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
      rd.include(pReq, pResp);
    } catch (Exception e) {
      if (factoryAppBeans != null) {
        ILogger logger = null;
        try {
          logger = (ILogger) factoryAppBeans.lazyGet("ILogger");
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        if (logger != null) {
          logger.error(null, getClass(), "WORK", e);
        } else {
          e.printStackTrace();
        }
      } else {
        e.printStackTrace();
      }
      if (e instanceof ExceptionWithCode) {
        pReq.setAttribute("error_code",
          ((ExceptionWithCode) e).getCode());
        pReq.setAttribute("short_message",
          ((ExceptionWithCode) e).getShortMessage());
      } else {
        pReq.setAttribute("error_code",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
      pReq.setAttribute("javax.servlet.error.status_code",
        HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      pReq.setAttribute("javax.servlet.error.exception", e);
      pReq.setAttribute("javax.servlet.error.request_uri",
        pReq.getRequestURI());
      pReq.setAttribute("javax.servlet.error.servlet_name", this.getClass()
        .getCanonicalName());
      pResp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * <p>Encoding bytes to hex string.</p>
   * @param pSource bytes
   * @return encoded string
   **/
  public final String toHexString(final byte[] pSource) {
    StringBuffer sb = new StringBuffer();
    for (byte b : pSource) {
      int bi = b;
      bi &= 0x000000FF;
      sb.append(ecncodingLetters[(bi >> 4) & 0x0F]);
      sb.append(ecncodingLetters[bi & 0x0F]);
      sb.append(" ");
    }
    return sb.toString();
  }

  //Simple getters and setters:
  /**
   * <p>Geter for dirJsp.</p>
   * @return String
   **/
  public final String getDirJsp() {
    return this.dirJsp;
  }

  /**
   * <p>Setter for dirJsp.</p>
   * @param pDirJsp reference
   **/
  public final void setDirJsp(final String pDirJsp) {
    this.dirJsp = pDirJsp;
  }
}
