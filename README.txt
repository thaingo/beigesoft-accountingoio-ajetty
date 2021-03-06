beigesoft-accountingoio-ajetty-bin.zip is standalone JEE web application performed by embedded A-Jetty.

Beigesoft™ Accounting for MS Windows/Mac/*Nix beigesoft-accountingoio-ajetty.bin.zip
you can find in central Maven repository https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.beigesoft%22
or https://repo1.maven.org/maven2/org/beigesoft/beigesoft-accountingoio-ajetty/

This software requires:

* Java - JRE7+.
* Google Chrome, Opera, or Chromium browser (html5-dialog ready).

Features:
* Double entry accounting system including ledger and balance reports.
* COGS FIFO/LIFO perpetual automatically for sales, sales returns, inventory losses.
* Automatically sales taxes accounting entries for sales, purchases and their returns.
* Sales tax methods: item/invoice basis, destination-based, aggregate rate, price inclusive of tax.
* Prepayments/payments tracking for sales/purchases (including invoices with foreign currency).
* Payroll - automatically taxes calculation (by percentage tax table method) and accounting entries.
* Manufacturing - automatically cost calculation from used materials and direct labor (and other) costs.
* Multi-databases (organizations) support.
* and more.

Web-Store is included for pricing, study, and tests purposes and you are also able to make full DB copy from cloud version.
You can make price lists (in different price categories) and export it in CSV file to your customers or POS.

Version 1.1.8:
*web-store first release
*sales taxes: allowed to edit them in any invoice
*new input number instead of auto-numeric.

Version 1.1.7:
*added multi-currency (including payments tracking).
*sales taxes:
  1. added invoice level switcher "omit taxes"
  2. added invoice basis method.
  3. added aggregate rate method.
  4. added "price inclusive of tax" method (it should be used along with aggregate rate method or only tax).
  5. purchases - user is allowed to change tax amount in line (item basis) or in total tax (invoice basis)
  6. purchases - vendor can has "tax destination" method that is actually overrides tax calculation method (rounding mode, invoice/item basis, aggregate/not rate)
  7. sales - added destination-based method for "other-region" customers, that "other region" has different sales taxes.
*added importing  bank statement from CSV file, semi-automatically bank reconciliation.
*added exporting price list into CSV file.
*PDF reports (sales invoice, balance sheet): User can change paper size, orientation, margins and font size in "Accounting Settings".
*it use entered by user invoice line's price, amount, total, prior to 1.1.7 total was always calculated from price and quantity.

Version 1.1.6:
*Added "omit sales tax for overseas sales/purchase" - if customer/vendor is marked as "foreigner" then sales taxes will be omitted in the invoice.
*Fixed internationalization - decimal separators...
*Added advanced internationalization for printing overseas sales invoice in buyer's native language for overseas buyers who bought your products for business purposes.
*Fixed mistake of reversing single line in invoices form.
*Fixed sales taxes grouping rounding error (when round(2.244 + 2.244) != round(2.244) + round(2.244)).
*Fixed dis-balance when subaccount name is changed. Added more slow services that is not affected by changing subaccount name.
 To recalculate all intermediate balances - in accounting settings change "Balance store period" from "monthly to weekly", then print report "Trial balance", then change "Balance store period" back.
*Added unit of measure and quantity for services (for purchase/sale).

Version 1.1.5:
Fixed purchase return sales tax non-extracted.
Added JAR signing.
Fixed crossplatform file.separator.

Since 1.1.5 version Beige-Accounting is always in secure enabled mode (protected from scams).
It requires user authentication with strong password.
It uses encryption for HTTPS and file exchange - modern algorithms asymmetric RSA 2048bit key size and symmetric AES 256bit size.
In *nix OS you are able to create "accountant" user, then under your regular account (e.g. Bob)
open terminal and login as accountant - "su -l accountant" then install and use beige-accounting.
start beige-accounting under user "accounting" from command line with command "java -jar beigesoft-accountingoio-ajetty-jar-with-dependencies.jar cli" - cli means command line interface.
As a result an application (that is running under your regular account) that is affected by scamware can't access your
accounting data, e.g. if your browser has been allowing scamware script in HTML page to read your file system then it can't read "accountant" files cause browser is running under your account e.g. "Bob", not under "accountant".

To start application:
1. unpack ZIP.
2. After installing Java (Oracle) you can run any Java "JAR" file by double click on it.
  Do it with beigesoft-accountingoio-ajetty-jar-with-dependencies.jar.
  You also can launch "JAR" file from command prompt (power shell, terminal) with command:
  "java -jar beigesoft-accountingoio-ajetty-jar-with-dependencies.jar"
3. Application menu to start/stop server will be appeared. You should enter strong (see below) password to start Beige-Accounting.
4. Press "Start" button, then wait while server has been started (for the 1-st time it may takes up to 1 minute to create database).
  * If you got error, then see starter.log file in application folder. If it's saying:
    a) ...provider BC... then you should install Bouncy Castle crypto-provider in static way:
    download bcprov-jdk15on-1.59.jar from https://repo1.maven.org/maven2/org/bouncycastle/bcprov-jdk15on/1.59/
    and bcpkix-jdk15on-1.59.jar from https://repo1.maven.org/maven2/org/bouncycastle/bcpkix-jdk15on/1.59/
    then put them into [java-home]/lib/ext e.g. "C:\Program Files (x86)\Java\jre[version#8]\lib\ext"
    Then add entry "security.provider.[next_number]=org.bouncycastle.jce.provider.BouncyCastleProvider"
    into [JAVA_HOME]/lib/security/java.security
    On MS Windows copy java.security to your documents folder, edit it then copy back into "C:\Program Files (x86)\Java\jre[version#8]\lib\security"
    b)...org.bouncycastle.operator.OperatorCreationException: unable to create OutputEncryptor: Illegal key size or default parameters...
    then you should install "Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files for Java 8" into
    folder [JAVA_HOME]/lib/security. For MS Windows you can find these files
    in folder "C:\Program Files (x86)\Java\jre[version#8]\lib\security\policy\unlimited",
    otherwise download these from Oracle site.
    Encryption with strong keys (long size) protects you (your information) from scams, so any law must protect you too.
5. A-Jetty CA certificate ajetty-ca.pem will be at the application folder. You have to install it
  as trusted Certificate Authority in the browser.
  Certificate Authorities that aren't signed by global trusted CA are often used to create private (non-public) intranets, using digital signatures inside organization and its partners.
  Here A-Jetty CA used to create HTTPS intranet inside only computer and for encrypted file exchange between your computers/tablets...
6. press button "https://localhost:8443/bsa8443" to start the browser. *If you are in *nix and accounting is running under accountant (as described above) and browser under your regular account then type the address in the browser by hand.
7. Empty database requires to add the first (only) user with strong password.
  To make strong and ease to remember password use method similar to this:
  a. use at least 3 words, e.g. raccoon eat stone
  b. change these words with a rule e.g. "last letter to first position upper case" e.g. Nraccoo Tea Eston
  c. add several digits, e.g. result is "NraccooTeaEston165" or "165NraccooTeaEston" or "165NraccooTeaEston165"...
8. To make second (third ...) local beige-accounting e.g. for using web-services to import data from
  tax accounting to market one (at the same computer) you need copy folder "ks" with keystore into second (3-d...)
  and register A-Jetty CA certificate ajetty-ca.pem in the Java. You can do it by using command line tool "keytool",
  on *nix OS run in terminal:
  keytool -import -trustcacerts -alias ajettyca -file "ajetty-ca.pem" -keystore /usr/lib/jvm/java-1.8.0-openjdk/jre/lib/security/cacerts
  It requires ROOT permission, so do not care about keystore password (default is changeit).
  on MS Windows open Power Shell as ADMIN in beige-accounting folder and run:
  & "C:\Program Files (x86)\Java\jre[version#8]\bin\keytool.exe" -import -trustcacerts -alias ajettyca -file "ajetty-ca.pem" -keystore "C:\Program Files (x86)\Java\jre[version#8]\lib\security\cacerts"

See https://sites.google.com/site/beigesoftware/bobspizza for details.

license:

GNU General Public License version 2 - http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html

3-D PARTY LICENSES:

Oracle JEE:
CDDL + GPLv2 with classpath exception
https://javaee.github.io/glassfish/LICENSE

https://github.com/demidenko05/a-tomcat-all - part of Apache Tomcat/JSTL by Apache Software Foundation, adapted for Android to precompile and run JSP/JSTL:
The Apache Software License, Version 2.0
http://www.apache.org/licenses/LICENSE-2.0.txt

https://github.com/demidenko05/a-jetty-all - part of Jetty 9.2 by Mort Bay Consulting Pty. Ltd adapted for Android:
The Eclipse Public License, Version 1.0
http://www.eclipse.org/legal/epl-v10.html

https://github.com/demidenko05/a-javabeans8 - adapted OpenJDK8 javabeans for Android:
GNU General Public License, version 2, with the Classpath Exception
http://openjdk.java.net/legal/gplv2+ce.html

SQLite JDBC (included SQLite database) by Taro L. Saito (http://xerial.org/software/)
The Apache Software License, Version 2.0
http://www.apache.org/licenses/LICENSE-2.0.txt
SQLite database is Public Domain:
https://www.sqlite.org/copyright.html

HikariCP JDBC-pool by Brett Wooldridge:
The Apache Software License, Version 2.0
http://www.apache.org/licenses/LICENSE-2.0.txt

JavaMail API (compat) 1.4 plus JavaBeans(TM) Activation Framework:
Common Development and Distribution License (CDDL) v1.0
https://glassfish.dev.java.net/public/CDDLv1.0.html

SLF4J by QOS.ch:
MIT License
http://www.opensource.org/licenses/mit-license.php

Bouncy Castle Crypto APIs by the Legion of the Bouncy Castle Inc:
Bouncy Castle License (actually MIT)
http://www.bouncycastle.org/licence.html

CSS/Javascript framework Bootstrap by Twitter, Inc and the Bootstrap Authors:
MIT License
https://github.com/twbs/bootstrap/blob/master/LICENSE

JQuery by JS Foundation and other contributors:
MIT license
https://jquery.org/license

JS library Popper by Federico Zivolo and contributors:
MIT License
https://github.com/twbs/bootstrap/blob/master/LICENSE

Open Iconic icon fonts by Waybury:
SIL OPEN FONT LICENSE Version 1.1
http://scripts.sil.org/cms/scripts/page.php?item_id=OFL_web
Open Iconic to Bootstrap CSS by Waybury:
MIT License
https://github.com/twbs/bootstrap/blob/master/LICENSE

DejaVu fonts by Bitstream:
https://dejavu-fonts.github.io/License.html 

flag-icon-css collection of all country flags in SVG by Panayiotis Lipiridis
MIT License
https://github.com/lipis/flag-icon-css

site: https://sites.google.com/site/beigesoftware

