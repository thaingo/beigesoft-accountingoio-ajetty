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

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.beigesoft.exception.ExceptionWithCode;
import org.beigesoft.web.factory.AFactoryAppBeans;
import org.beigesoft.web.service.IMngDatabaseExt;

/**
 * <p>Database manager with encryption.
 * Additional it encrypt/decrypt all log files.</p>
 *
 * @param <RS> platform dependent RDBMS recordset
 * @author Yury Demidenko
 */
public class MngDatabaseSqliteEncrypted<RS> implements IMngDatabaseExt {

  /**
   * <p>Log files folder (inner).</p>
   **/
  private File logDir;

  /**
   * <p>Databases folder (inner).</p>
   **/
  private String databaseDir;

  /**
   * <p>Encrypted backup databases folder (public).</p>
   **/
  private String backupDir;

  /**
   * <p>App beans factory.</p>
   **/
  private AFactoryAppBeans<RS> factoryAppBeans;

  /**
   * <p>Crypto service.</p>
   **/
  private ICryptoHelper cryptoHelper;

  /**
   * <p>Database prefix - for JDBC is "jdbc:sqlite:[db-dir]/".</p>
   **/
  private String databasePrefix = "";

  /**
   * <p>
   * List databases.
   * </p>
   * @return List<String> list of database files.
   * @throws Exception - an exception
   **/
  @Override
  public final List<String> retrieveList() throws Exception {
    List<String> result = new ArrayList<String>();
    File dbDir = new File(this.databaseDir);
    if (dbDir.exists() && dbDir.isDirectory()) {
      String[] files = dbDir.list();
      if (files != null) {
        for (String flNm : files) {
          if (flNm.endsWith(".sqlite")) {
            result.add(flNm.replace(".sqlite", ""));
          }
        }
      }
    } else {
      throw new ExceptionWithCode(ExceptionWithCode.CONFIGURATION_MISTAKE,
        "DB directory not found: " + this.databaseDir);
    }
    return result;
  }

  /**
   * <p>
   * List backup databases.
   * </p>
   * @return List<String> list of backup database files.
   * @throws Exception - an exception
   **/
  @Override
  public final List<String> retrieveBackupList() throws Exception {
    List<String> result = new ArrayList<String>();
    File dbDir = new File(this.backupDir);
    if (dbDir.exists() && dbDir.isDirectory()) {
      String[] files = dbDir.list();
      if (files != null) {
        for (String flNm : files) {
          if (flNm.endsWith(".sqlten")) {
            result.add(flNm.replace(".sqlten", ""));
          }
        }
      }
    } else {
      throw new ExceptionWithCode(ExceptionWithCode.CONFIGURATION_MISTAKE,
        "Backup directory not found: " + this.backupDir);
    }
    return result;
  }

  /**
   * <p>
   * Retrieve current DB name.
   * </p>
   * @return String DB name.
   * @throws Exception - an exception
   **/
  @Override
  public final String retrieveCurrentDbName() throws Exception {
    return this.factoryAppBeans.getDatabaseName();
  }

  /**
   * <p>Create new database.</p>
   * @param pDbName database name without extension
   * @param pDbId database ID
   * @throws Exception - an exception
   **/
  @Override
  public final void createDatabase(final String pDbName,
    final int pDbId) throws Exception {
    String dbNm = this.databasePrefix + pDbName + ".sqlite";
    synchronized (this.factoryAppBeans) {
      if (!this.factoryAppBeans.getDatabaseName().equals(dbNm)) {
        this.factoryAppBeans.setDatabaseName(dbNm);
        this.factoryAppBeans.setNewDatabaseId(pDbId);
        this.factoryAppBeans.handleDatabaseChanged();
      }
    }
  }

  /**
   * <p>Change database.</p>
   * @param pDbName database name without extension
   * @throws Exception - an exception
   **/
  @Override
  public final void changeDatabase(final String pDbName) throws Exception {
    String dbNm = this.databasePrefix + pDbName + ".sqlite";
    synchronized (this.factoryAppBeans) {
      if (!this.factoryAppBeans.getDatabaseName().equals(dbNm)) {
        this.factoryAppBeans.setDatabaseName(dbNm);
        this.factoryAppBeans.handleDatabaseChanged();
      }
    }
  }

  /**
   * <p>Delete database in inner DB folder, NOT current DB!</p>
   * @param pDbName database name without extension
   * @throws Exception - an exception
   **/
  @Override
  public final void deleteDatabase(final String pDbName) throws Exception {
    String dbNm = this.databasePrefix + pDbName + ".sqlite";
    if (!dbNm.equals(this.factoryAppBeans.getDatabaseName())) {
      File dbFile = new File(this.databaseDir + File.separator + dbNm);
      if (dbFile.exists() && !dbFile.delete()) {
        throw new ExceptionWithCode(ExceptionWithCode.SOMETHING_WRONG,
          "Can't delete file: " + dbFile);
      }
    }
  }

  /**
   * <p>Backup database.</p>
   * @param pDbName database name without extension
   * @throws Exception - an exception
   **/
  @Override
  public final void backupDatabase(final String pDbName) throws Exception {
    String dbPath = this.databaseDir + File.separator + pDbName + ".sqlite";
    File dbFile = new File(dbPath);
    if (dbFile.exists()) {
      String encPath = this.backupDir + File.separator + pDbName + ".sqlten";
      File dbBkFile = new File(encPath);
      if (dbBkFile.exists()) {
        Long time = new Date().getTime();
        encPath = this.backupDir + File.separator + pDbName + time + ".sqlten";
      }
      this.cryptoHelper.encryptFile(dbPath, encPath);
    }
  }

  /**
   * <p>Restore database from backup.</p>
   * @param pDbName database name without extension
   * @throws Exception - an exception
   **/
  @Override
  public final void restoreDatabase(final String pDbName) throws Exception {
    String encPath = this.backupDir + File.separator + pDbName + ".sqlten";
    File dbBkFile = new File(encPath);
    if (dbBkFile.exists()) {
      this.cryptoHelper.decryptFile(encPath,
        this.databaseDir + File.separator + pDbName + ".sqlite");
    }
  }

  /**
   * <p>Encrypt log files into backup directory.</p>
   * @throws Exception - an exception
   **/
  @Override
  public final void encryptLogs() throws Exception {
    if (this.logDir != null && this.logDir.exists() && !this.logDir.isFile()) {
      File[] files = this.logDir.listFiles();
      if (files != null) {
        for (File fl : files) {
          if (fl.getName().endsWith(".log")) {
            this.cryptoHelper.encryptFile(fl.getPath(),
              this.backupDir + File.separator + fl.getName() + "en");
          }
        }
      }
    }
  }

  /**
   * <p>Decrypt log files in backup directory.</p>
   * @throws Exception - an exception
   **/
  @Override
  public final void decryptLogs() throws Exception {
    File bkDir = new File(this.backupDir);
    if (bkDir.exists() && !bkDir.isFile()) {
      File[] files = bkDir.listFiles();
      if (files != null) {
        for (File fl : files) {
          if (fl.getName().endsWith(".logen")) {
            this.cryptoHelper.decryptFile(fl.getPath(), this.backupDir
              + File.separator + fl.getName().replace(".logen", ".log"));
          }
        }
      }
    }
  }

  /**
   * <p>Getter for backupDir.</p>
   * @return String
   **/
  @Override
  public final String getBackupDir() {
    return this.backupDir;
  }

  /**
   * <p>Setter for backupDir.</p>
   * @param pBackupDir reference
   **/
  @Override
  public final void setBackupDir(final String pBackupDir) {
    this.backupDir = pBackupDir;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for logDir.</p>
   * @return File
   **/
  public final File getLogDir() {
    return this.logDir;
  }

  /**
   * <p>Setter for logDir.</p>
   * @param pLogDir reference
   **/
  public final void setLogDir(final File pLogDir) {
    this.logDir = pLogDir;
  }

  /**
   * <p>Getter for databaseDir.</p>
   * @return String
   **/
  public final String getDatabaseDir() {
    return this.databaseDir;
  }

  /**
   * <p>Setter for databaseDir.</p>
   * @param pDatabaseDir reference
   **/
  public final void setDatabaseDir(final String pDatabaseDir) {
    this.databaseDir = pDatabaseDir;
  }

  /**
   * <p>Getter for factoryAppBeans.</p>
   * @return AFactoryAppBeans<RS>
   **/
  public final AFactoryAppBeans<RS> getFactoryAppBeans() {
    return this.factoryAppBeans;
  }

  /**
   * <p>Setter for factoryAppBeans.</p>
   * @param pFactoryAppBeans reference
   **/
  public final void setFactoryAppBeans(
    final AFactoryAppBeans<RS> pFactoryAppBeans) {
    this.factoryAppBeans = pFactoryAppBeans;
  }

  /**
   * <p>Getter for cryptoHelper.</p>
   * @return ICryptoHelper
   **/
  public final ICryptoHelper getCryptoHelper() {
    return this.cryptoHelper;
  }

  /**
   * <p>Setter for cryptoHelper.</p>
   * @param pCryptoHelper reference
   **/
  public final void setCryptoHelper(final ICryptoHelper pCryptoHelper) {
    this.cryptoHelper = pCryptoHelper;
  }

  /**
   * <p>Getter for databasePrefix.</p>
   * @return String
   **/
  public final String getDatabasePrefix() {
    return this.databasePrefix;
  }

  /**
   * <p>Setter for databasePrefix.</p>
   * @param pDatabasePrefix reference
   **/
  public final void setDatabasePrefix(final String pDatabasePrefix) {
    this.databasePrefix = pDatabasePrefix;
  }
}
