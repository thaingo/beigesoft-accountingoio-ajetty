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

import java.security.KeyStore;
import java.security.PublicKey;

/**
 * <p>Service that loads/holds keystore, performs encryption/decryption.
 *  This is for localhost only!</p>
 * @author Yury Demidenko
 */
public interface ICryptoHelper {

  /**
   * <p>Calculate SHA1 for given bytes (public key).</p>
   * @param pPublicKey bytes
   * @return SHA1 bytes array
   * @throws Exception an Exception
   */
  byte[] calculateSha1(byte[] pPublicKey) throws Exception;
  /**
   * <p>Lazy load keystore
   * (for farther SSL trusted certificate initialization).</p>
   * @return Keystore
   * @throws Exception - an exception
   **/
  KeyStore lazyGetKeystore() throws Exception;

  /**
   * <p>Encrypts file.</p>
   * @param pFilePath File Path
   * @param pEncryptedPath Encrypted Path
   * @throws Exception - an exception
   **/
  void encryptFile(String pFilePath, String pEncryptedPath) throws Exception;

  /**
   * <p>Decrypts file.</p>
   * @param pEncryptedPath Encrypted Path
   * @param pDecryptedPath Decrypted Path
   * @throws Exception - an exception
   **/
  void decryptFile(String pEncryptedPath,
    String pDecryptedPath) throws Exception;

  /**
   * <p>Getter for ourPublicKey in lazy mode.</p>
   * @return our APK PublicKey
   * @throws Exception - an exception
   **/
  PublicKey lazyGetOurPublicKey() throws Exception;

  /**
   * <p>Lazy getter of public key of another A-Jetty.</p>
   * @return public key of another A-Jetty
   * @throws Exception - an exception
   **/
  PublicKey lazyGetPublicKeyAnotherAjetty() throws Exception;
}
