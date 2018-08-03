package org.beigesoft.ajetty;

/*
 * Copyright (c) 2017 Beigesoft™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import java.io.File;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.beigesoft.replicator.service.PrepareDbAfterGetCopy;
import org.beigesoft.orm.service.SrvOrmSqlite;
import org.beigesoft.web.factory.AFactoryAppBeansJdbc;
import org.beigesoft.accounting.factory.FactoryAccDatabaseWriterXml;
import org.beigesoft.accounting.factory.FactoryAccReplicatorXmlHttps;
import org.beigesoft.accounting.factory.FactoryBldAccServices;
import org.beigesoft.accounting.factory.FactoryAccServices;

/**
 * <p>Application beans factory for Sqlite RDBMS.
 * Cause don't use IOC.
 * Property dataSourceJndiName must be settled!
 * </p>
 *
 * @author Yury Demidenko
 */
public class FactoryAccAppBeansSqlite extends AFactoryAppBeansJdbc {

  /**
   * <p>Invoke complex inner factories initialization.</p>
   * @throws Exception - an exception
   **/
  public FactoryAccAppBeansSqlite() throws Exception {
    init();
  }

  //To override:
  /**
   * <p>Initialize inner factories after clear beans or on startup.</p>
   * @throws Exception - an exception
   */
  @Override
  public final synchronized void init() throws Exception {
    FactoryBldAccServices<ResultSet> factoryBldAccServices =
      new FactoryBldAccServices<ResultSet>();
    factoryBldAccServices.setFactoryAppBeans(this);
    setFactoryBldServices(factoryBldAccServices);
    FactoryAccServices<ResultSet> factoryAccServices =
      new FactoryAccServices<ResultSet>();
    factoryAccServices.setFactoryAppBeans(this);
    factoryAccServices.setFactoryBldAccServices(factoryBldAccServices);
    factoryBldAccServices.setFactoryAccServices(factoryAccServices);
    setFactoryOverBeans(factoryAccServices);
    FactoryAccReplicatorXmlHttps<ResultSet> factoryReplicatorXmlHttps =
      new FactoryAccReplicatorXmlHttps<ResultSet>();
    factoryReplicatorXmlHttps.setFactoryAppBeans(this);
    setFactoryReplicatorXmlHttps(factoryReplicatorXmlHttps);
    FactoryAccDatabaseWriterXml<ResultSet> factoryDatabaseWriterXml =
      new FactoryAccDatabaseWriterXml<ResultSet>();
    factoryDatabaseWriterXml.setFactoryAppBeans(this);
    setFactoryDatabaseWriterXml(factoryDatabaseWriterXml);
  }


  /**
   * <p>Get other RDBMS specific bean in lazy mode
   * (if bean is null then initialize it).</p>
   * @param pBeanName - bean name
   * @return Object - requested bean
   * @throws Exception - an exception
   */
  @Override
  public final synchronized Object lazyGetOtherRdbmsBean(
    final String pBeanName) throws Exception {
    if (getMngDatabaseName().equals(pBeanName)) {
      return lazyGetMngDatabaseSqliteEncrypted();
    } else if (getCryptoHelperName().equals(pBeanName)) {
      return lazyGetCryptoHelper();
    }
    return null;
  }

  /**
   * <p>Instantiate ORM  service.</p>
   * @return SrvOrmSqlite - ORM  service
   */
  public final synchronized SrvOrmSqlite<ResultSet> instantiateSrvOrm() {
    return new SrvOrmSqlite<ResultSet>();
  }

  /**
   * <p>Get DataSource in lazy mode.</p>
   * @return DataSource - DataSource
   * @throws Exception - an exception
   */
  @Override
  public final synchronized DataSource lazyGetDataSource() throws Exception {
    String beanName = getDataSourceName();
    HikariDataSource dataSource =
      (HikariDataSource) getBeansMap().get(beanName);
    if (dataSource == null) {
      dataSource = new HikariDataSource();
      dataSource.setJdbcUrl(getDatabaseName());
      dataSource.setDriverClassName("org.sqlite.JDBC");
      getBeansMap().put(beanName, dataSource);
      lazyGetLogger().info(null, FactoryAccAppBeansSqlite.class, beanName
        + " has been created.");
    }
    return dataSource;
  }

  /**
   * <p>Get CryptoHelper in lazy mode.</p>
   * @return CryptoHelper - CryptoHelper
   * @throws Exception - an exception
   */
  public final synchronized CryptoHelper
    lazyGetCryptoHelper() throws Exception {
    String beanName = getCryptoHelperName();
    CryptoHelper cryptoHelper =
      (CryptoHelper) getBeansMap().get(beanName);
    if (cryptoHelper == null) {
      cryptoHelper = new CryptoHelper();
      File webAppDir = new File(getWebAppPath());
      cryptoHelper.setKsDirPath(webAppDir.getParent() + File.separator + "ks");
      File peDir = new File(webAppDir.getParent()
        + File.separator + "pub-exch");
      if (!peDir.exists() && !peDir.mkdir()) {
        throw new Exception("Can't create directory: " + peDir);
      }
      cryptoHelper.setPublicKeyDir(peDir.getPath());
      getBeansMap().put(beanName, cryptoHelper);
      lazyGetLogger().info(null, FactoryAccAppBeansSqlite.class, beanName
        + " has been created.");
    }
    return cryptoHelper;
  }

  /**
   * <p>Getter of Manager Database service name.</p>
   * @return service name
   **/
  public final String getCryptoHelperName() {
    return "ICryptoHelper";
  }

  /**
   * <p>Get MngDatabaseSqliteEncrypted in lazy mode.</p>
   * @return MngDatabaseSqliteEncrypted<ResultSet> - MngDatabaseSqliteEncrypted
   * @throws Exception - an exception
   */
  public final synchronized MngDatabaseSqliteEncrypted<ResultSet>
    lazyGetMngDatabaseSqliteEncrypted() throws Exception {
    String beanName = getMngDatabaseName();
    @SuppressWarnings("unchecked")
    MngDatabaseSqliteEncrypted<ResultSet> mngDatabaseSqlite =
      (MngDatabaseSqliteEncrypted<ResultSet>) getBeansMap().get(beanName);
    if (mngDatabaseSqlite == null) {
      mngDatabaseSqlite = new MngDatabaseSqliteEncrypted<ResultSet>();
      mngDatabaseSqlite.setFactoryAppBeans(this);
      mngDatabaseSqlite.setCryptoHelper(lazyGetCryptoHelper());
      File webAppDir = new File(getWebAppPath());
      mngDatabaseSqlite.setLogDir(webAppDir);
      mngDatabaseSqlite.setDatabaseDir(getWebAppPath());
      mngDatabaseSqlite.setDatabasePrefix("jdbc:sqlite:"
        + getWebAppPath() + File.separator);
      File backupDir = new File(webAppDir.getParent()
        + File.separator + "backup");
      if (!backupDir.exists() && !backupDir.mkdir()) {
        throw new Exception("Can't create directory: " + backupDir);
      }
      mngDatabaseSqlite.setBackupDir(backupDir.getPath());
      getBeansMap().put(beanName, mngDatabaseSqlite);
      lazyGetLogger().info(null, FactoryAccAppBeansSqlite.class, beanName
        + " has been created.");
    }
    return mngDatabaseSqlite;
  }

  /**
   * <p>Getter of Manager Database service name.</p>
   * @return service name
   **/
  public final String getMngDatabaseName() {
    return "IMngDatabaseExt";
  }

  /**
   * <p>Get Service that prepare Database after full import
   * in lazy mode.</p>
   * @return IDelegator - preparator Database after full import.
   * @throws Exception - an exception
   */
  @Override
  public final synchronized PrepareDbAfterGetCopy
    lazyGetPrepareDbAfterFullImport() throws Exception {
    String beanName = getPrepareDbAfterFullImportName();
    PrepareDbAfterGetCopy prepareDbAfterGetCopy =
      (PrepareDbAfterGetCopy) getBeansMap().get(beanName);
    if (prepareDbAfterGetCopy == null) {
      prepareDbAfterGetCopy = new PrepareDbAfterGetCopy();
      prepareDbAfterGetCopy.setLogger(lazyGetLogger());
      prepareDbAfterGetCopy.setFactoryAppBeans(this);
      getBeansMap().put(beanName, prepareDbAfterGetCopy);
      lazyGetLogger().info(null, FactoryAccAppBeansSqlite.class, beanName
        + " has been created.");
    }
    return prepareDbAfterGetCopy;
  }
}
