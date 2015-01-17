biz.dfch.j.graylog2.plugin.filter.auditlog
============================================

Plugin: biz.dfch.j.graylog2.plugin.filter.auditlog

d-fens GmbH, General-Guisan-Strasse 6, CH-6300 Zug, Switzerland

This Graylog2 Filter Plugin lets you send all incoming messages to some other destination for audit trail purposes.

See [Creating a Graylog2 Output Plugin](http://d-fens.ch/2015/01/07/howto-creating-a-graylog2-output-plugin/) for further description on how to create plugins.

You can [download the binary](https://drone.io/github.com/dfch/biz.dfch.j.graylog2.plugin.filter.auditlog/files) [![Build Status](https://drone.io/github.com/dfch/biz.dfch.j.graylog2.plugin.filter.auditlog/status.png)](https://drone.io/github.com/dfch/biz.dfch.j.graylog2.plugin.filter.auditlog/latest) at our [drone.io](https://drone.io/github.com/dfch) account, which gets built every time we commit something to the master branch of the repository.

Getting started for users
-------------------------

This project is using Maven and requires Java 7 or higher.

* Clone this repository.
* Run `mvn package` to build a JAR file.
* Optional: Run `mvn jdeb:jdeb` and `mvn rpm:rpm` to create a DEB and RPM package respectively.
* Copy generated jar file in target directory to your Graylog2 server plugin directory.
* Restart the Graylog2 server.
