package org.beigesoft.ajetty;

/*
 * Copyright (c) 2017 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.security.KeyStore;

import org.eclipse.jetty.security.DataBaseLoginService;

import org.beigesoft.delegate.IDelegateExc;
import org.beigesoft.service.ISrvDatabase;
import org.beigesoft.orm.service.ASrvOrm;
import org.beigesoft.web.model.FactoryAndServlet;
import org.beigesoft.web.service.SrvAddTheFirstUser;
import org.beigesoft.web.factory.AFactoryAppBeans;
import org.beigesoft.accounting.service.ISrvAccSettings;
import org.beigesoft.accounting.service.HndlAccVarsRequest;

/**
 * <p>
 * Initialize app-factory A-Jetty with servlet parameters.
 * </p>
 *
 * @param <RS> platform dependent RDBMS recordset
 * @author Yury Demidenko
 */
public class InitAppFactory<RS> implements IDelegateExc<FactoryAndServlet> {

  /**
   * <p>Make something with a model.</p>
   * @throws Exception - an exception
   * @param pFactoryAndServlet with make
   **/
  @Override
  public final synchronized void makeWith(
    final FactoryAndServlet pFactoryAndServlet) throws Exception {
    @SuppressWarnings("unchecked")
    AFactoryAppBeans<RS> factoryAppBeans =
      (AFactoryAppBeans<RS>) pFactoryAndServlet.getFactoryAppBeans();
    File webAppPath = new File(pFactoryAndServlet.getHttpServlet()
      .getServletContext().getRealPath(""));
    factoryAppBeans.setWebAppPath(webAppPath.getPath());
    String isShowDebugMessagesStr = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("isShowDebugMessages");
    factoryAppBeans.setIsShowDebugMessages(Boolean
      .valueOf(isShowDebugMessagesStr));
    String newDatabaseIdStr = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("newDatabaseId");
    factoryAppBeans.setNewDatabaseId(Integer.parseInt(newDatabaseIdStr));
    String ormSettingsDir = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("ormSettingsDir");
    factoryAppBeans.setOrmSettingsDir(ormSettingsDir);
    String ormSettingsBaseFile = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("ormSettingsBaseFile");
    factoryAppBeans.setOrmSettingsBaseFile(ormSettingsBaseFile);
    String uvdSettingsDir = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("uvdSettingsDir");
    factoryAppBeans.setUvdSettingsDir(uvdSettingsDir);
    String uvdSettingsBaseFile = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("uvdSettingsBaseFile");
    factoryAppBeans.setUvdSettingsBaseFile(uvdSettingsBaseFile);
    String jdbcUrl = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("databaseName");
    if (jdbcUrl != null && jdbcUrl.contains(ASrvOrm.WORD_CURRENT_DIR)) {
      jdbcUrl = jdbcUrl.replace(ASrvOrm.WORD_CURRENT_DIR,
        factoryAppBeans.getWebAppPath() + File.separator);
    } else if (jdbcUrl != null
      && jdbcUrl.contains(ASrvOrm.WORD_CURRENT_PARENT_DIR)) {
      File fcd = new File(factoryAppBeans.getWebAppPath());
      jdbcUrl = jdbcUrl.replace(ASrvOrm.WORD_CURRENT_PARENT_DIR,
        fcd.getParent() + File.separator);
    }
    String langCountriesStr = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("langCountries");
    List<String> lngCntLst = new ArrayList<String>();
    for (String str : langCountriesStr.split(",")) {
      lngCntLst.add(str);
    }
    String[] lngCntArr = new String[lngCntLst.size()];
    factoryAppBeans.lazyGetSrvI18n().add(lngCntLst.toArray(lngCntArr));
    LstnDbChanged<RS> lstnDbChanged = new LstnDbChanged<RS>();
    lstnDbChanged.setFactoryAndServlet(pFactoryAndServlet);
    factoryAppBeans.getListenersDbChanged().add(lstnDbChanged);
    factoryAppBeans.setDatabaseName(jdbcUrl);
    String databaseUser = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("databaseUser");
    factoryAppBeans.setDatabaseUser(databaseUser);
    String databasePassword = pFactoryAndServlet.getHttpServlet()
      .getInitParameter("databasePassword");
    factoryAppBeans.setDatabasePassword(databasePassword);
    pFactoryAndServlet.getHttpServlet().getServletContext()
      .setAttribute("srvI18n", factoryAppBeans.lazyGet("ISrvI18n"));
    pFactoryAndServlet.getHttpServlet().getServletContext()
      .setAttribute("sessionTracker",
        factoryAppBeans.lazyGet("ISessionTracker"));
    HndlAccVarsRequest<RS> hndlAccVarsRequest = new HndlAccVarsRequest<RS>();
    hndlAccVarsRequest.setLogger(factoryAppBeans.lazyGetLogger());
    hndlAccVarsRequest.setSrvDatabase(factoryAppBeans.lazyGetSrvDatabase());
    hndlAccVarsRequest.setSrvOrm(factoryAppBeans.lazyGetSrvOrm());
    hndlAccVarsRequest.setSrvAccSettings((ISrvAccSettings) factoryAppBeans
      .lazyGet("ISrvAccSettings"));
    factoryAppBeans.lazyGetHndlI18nRequest()
      .setAdditionalI18nReqHndl(hndlAccVarsRequest);
    //to create/initialize database if need:
    factoryAppBeans.lazyGet("ISrvOrm");
    @SuppressWarnings("unchecked")
    ISrvDatabase<RS> srvDb = (ISrvDatabase<RS>)
      factoryAppBeans.lazyGet("ISrvDatabase");
    SrvAddTheFirstUser<RS> srvAddFiU = new SrvAddTheFirstUser<RS>();
    srvAddFiU.setSrvDatabase(srvDb);
    pFactoryAndServlet.getHttpServlet().getServletContext()
      .setAttribute("srvAddTheFirstUser", srvAddFiU);
    DataBaseLoginService srvDbl = (DataBaseLoginService)
      pFactoryAndServlet.getHttpServlet().getServletContext()
        .getAttribute("JDBCRealm");
    if (srvDbl != null) {
      SrvGetUserCredentials<RS> srvCr = new SrvGetUserCredentials<RS>();
      srvCr.setSrvDatabase(srvDb);
      srvDbl.setSrvGetUserCredentials(srvCr);
    }
    //crypto init:
    CryptoHelper ch = (CryptoHelper) factoryAppBeans.lazyGet("ICryptoHelper");
    KeyStore ks = (KeyStore) pFactoryAndServlet.getHttpServlet()
      .getServletContext().getAttribute("ajettyKeystore");
    ch.setKeyStore(ks);
    String passw = (String) pFactoryAndServlet.getHttpServlet()
      .getServletContext().getAttribute("ksPassword");
    ch.setKsPassword(passw.toCharArray());
    Integer ajettyIn = (Integer) pFactoryAndServlet.getHttpServlet()
      .getServletContext().getAttribute("ajettyIn");
    ch.setAjettyIn(ajettyIn);
  }
}
