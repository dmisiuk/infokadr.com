
To set values for tomcat, apache, oracle please use environment variables(similar to JAVA_HOME, M2_HOME):
=========================================================================================================

* INFOKADR_TOMCAT_SERVER - name of tomcat server(please, configure it in maven settings.xml)
* INFOKADR_TOMCAT_URL - url of tomcat manager
* INFOKADR_STATIC_DIRECTORY - path to apache directory for static resources of project
* INFOKADR_DATABASE_URL - url for database
* INFOKADR_DATABASE_USERNAME - username for database
* INFOKADR_DATABASE_PASSWORD - password for database

_example:_
    maven settings.xml:

    	<server>
          <id>tomcat-server</id>
          <username>admin</username>
          <password>admin</password>
        </server>

    tomcat tomcat-users.xml

        <user username="admin" password="admin" roles="manager-script,manager-gui"/>


_To deploy you can use:_

        Maven command line:   mvn clean install -Ptomcat-deploy
