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

import java.util.ArrayList;

import org.beigesoft.model.IRecordSet;
import org.beigesoft.service.ISrvDatabase;

/**
 * <p>Service that get user credentials (from database).</p>
 * @param <RS> platform dependent RDBMS recordset
 * @author Yury Demidenko
 */
public class SrvGetUserCredentials<RS> implements ISrvGetUserCredentials {

  /**
   * <p>Database service.</p>
   **/
  private ISrvDatabase<RS> srvDatabase;

  /**
   * <p>Retrieve User Credentials.</p>
   * @param pUserName User Name
   * @return User Credentials
   * @throws Exception - an exception
   **/
  @Override
  public final UserCredentials retrieveUserCredentials(
    final String pUserName) throws Exception {
    String query = "select USERTOMCAT.ITSUSER as ITSUSER, ITSPASSWORD, ITSROLE"
      + " from USERTOMCAT join USERROLETOMCAT on USERROLETOMCAT.ITSUSER ="
        + " USERTOMCAT.ITSUSER where USERTOMCAT.ITSUSER = '" + pUserName + "';";
    UserCredentials result = null;
    IRecordSet<RS> recordSet = null;
    try {
      this.srvDatabase.setIsAutocommit(false);
      this.srvDatabase.
        setTransactionIsolation(ISrvDatabase.TRANSACTION_READ_UNCOMMITTED);
      this.srvDatabase.beginTransaction();
      recordSet = getSrvDatabase().retrieveRecords(query);
      if (recordSet.moveToFirst()) {
        ArrayList<String> roles = new ArrayList<String>();
        do {
          if (result == null) {
            result = new UserCredentials();
            result.setUserName(recordSet.getString("ITSUSER"));
            result.setUserPassword(recordSet.getString("ITSPASSWORD"));
          }
          roles.add(recordSet.getString("ITSROLE"));
        } while (recordSet.moveToNext());
        result.setUserRoles(roles.toArray(new String[roles.size()]));
      }
      this.srvDatabase.commitTransaction();
    } catch (Exception ex) {
      this.srvDatabase.rollBackTransaction();
      throw ex;
    } finally {
      this.srvDatabase.releaseResources();
      if (recordSet != null) {
        recordSet.close();
      }
    }
    return result;
  }

  /**
   * <p>Retrieve all Users Credentials.</p>
   * @return Users Credentials
   * @throws Exception - an exception
   **/
  @Override
  public final UserCredentials[] retrieveUsersCredentials() throws Exception {
    String query = "select USERTOMCAT.ITSUSER as ITSUSER, ITSPASSWORD, ITSROLE"
      + " from USERTOMCAT join USERROLETOMCAT"
        + " on USERROLETOMCAT.ITSUSER = USERTOMCAT.ITSUSER;";
    ArrayList<UserCredentials> result = null;
    IRecordSet<RS> recordSet = null;
    try {
      this.srvDatabase.setIsAutocommit(false);
      this.srvDatabase.
        setTransactionIsolation(ISrvDatabase.TRANSACTION_READ_UNCOMMITTED);
      this.srvDatabase.beginTransaction();
      recordSet = getSrvDatabase().retrieveRecords(query);
      if (recordSet != null && recordSet.moveToFirst()) {
        result = new ArrayList<UserCredentials>();
        UserCredentials uc = null;
        ArrayList<String> roles = new ArrayList<String>();
        do {
          String currUser = recordSet.getString("ITSUSER");
          if (uc == null) {
            uc = new UserCredentials();
            result.add(uc);
            uc.setUserName(currUser);
            uc.setUserPassword(recordSet.getString("ITSPASSWORD"));
          } else if (!currUser.equals(uc.getUserName())) {
            uc.setUserRoles(roles.toArray(new String[roles.size()]));
            roles.clear();
            uc = new UserCredentials();
            result.add(uc);
            uc.setUserName(currUser);
            uc.setUserPassword(recordSet.getString("ITSPASSWORD"));
          }
          roles.add(recordSet.getString("ITSROLE"));
        } while (recordSet.moveToNext());
        uc.setUserRoles(roles.toArray(new String[roles.size()]));
      }
      this.srvDatabase.commitTransaction();
    } catch (Exception ex) {
      this.srvDatabase.rollBackTransaction();
      throw ex;
    } finally {
      this.srvDatabase.releaseResources();
      if (recordSet != null) {
        recordSet.close();
      }
    }
    if (result == null) {
      return null;
    }
    return result.toArray(new UserCredentials[result.size()]);
  }

  /**
   * <p>Geter for srvDatabase.</p>
   * @return ISrvDatabase
   **/
  public final ISrvDatabase<RS> getSrvDatabase() {
    return this.srvDatabase;
  }

  /**
   * <p>Setter for srvDatabase.</p>
   * @param pSrvDatabase reference
   **/
  public final void setSrvDatabase(final ISrvDatabase<RS> pSrvDatabase) {
    this.srvDatabase = pSrvDatabase;
  }
}
