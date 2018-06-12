package org.beigesoft.ajetty;

/*
 * Copyright (c) 2018 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import org.eclipse.jetty.security.DataBaseLoginService;

import org.beigesoft.web.service.ILstnUserPswdChanged;

/**
 * <p>Service that listen to user password has been changed,
 * then clears user's credentials in cache in Jetty.</p>
 *
 * @author Yury Demidenko
 */
public class LstnUserPswdChanged implements ILstnUserPswdChanged {

  /**
   * <p>Jetty database login service.</p>
   **/
  private DataBaseLoginService dbLoginService;

  /**
   * <p>Password changed event.</p>
   * @param pUserName User Name
   * @throws Exception - an exception
   **/
  @Override
  public final void passwordChanged(final String pUserName) throws Exception {
    this.dbLoginService.removeUser(pUserName);
  }

  //Simple getters and setters:

  /**
   * <p>Getter for dbLoginService.</p>
   * @return DataBaseLoginService
   **/
  public final DataBaseLoginService getDbLoginService() {
    return this.dbLoginService;
  }

  /**
   * <p>Setter for dbLoginService.</p>
   * @param pDbLoginService reference
   **/
  public final void setDbLoginService(
    final DataBaseLoginService pDbLoginService) {
    this.dbLoginService = pDbLoginService;
  }
}
