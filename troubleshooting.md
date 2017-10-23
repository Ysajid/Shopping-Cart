## Setting up

## Problems

### ```null pointer exception``` in adding a new Database Pool
just update from v4.1 to 5.0
this is a bug in v4.1

### Setting up a connection Pool

Once GlassFish is installed, make sure it can access MySQL Connector/J. To do this, copy mysql-connector-java-5.1.30-bin.jar to C:\glassfish-install-path\glassfish\lib. Restart the GlassFish Application Server. For more information, see “Integrating the JDBC Driver” in GlassFish Server Open Source Edition Administration Guide, available at GlassFish Server Documentation.

You are now ready to create JDBC Connection Pools and JDBC Resources.

#### Creating a Connection Pool

* In the GlassFish Administration Console, using the navigation tree navigate to Resources, JDBC, Connection Pools.

* In the JDBC Connection Pools frame click New. You will enter a two step wizard.

* In the Name field under General Settings enter the name for the connection pool, for example enter MySQLConnPool.

* In the Resource Type field, select javax.sql.DataSource from the drop-down listbox.

* In the Database Vendor field, select MySQL from the drop-down listbox. Click Next to go to the next page of the wizard.

* You can accept the default settings for General Settings, Pool Settings and Transactions for this example. Scroll down to Additional Properties.

* In Additional Properties you will need to ensure the following properties are set:
	* ServerName - The server to connect to. For local testing this will be localhost.
	* User - The user name with which to connect to MySQL.
	* Password - The corresponding password for the user.
	* DatabaseName - The database to connect to, for example the sample MySQL database World.
	* driverClass - The database Driver class used.

* Click Finish to exit the wizard. You will be taken to the JDBC Connection Pools page where all current connection pools, including the one you just created, will be displayed.
* In the JDBC Connection Pools frame click on the connection pool you just created. Here, you can review and edit information about the connection pool. Because Connector/J does not support optimized validation queries, go to the Advanced tab, and under Connection Validation, configure the following settings:
	* Connection Validation - select Required.
	* Validation Method - select table from the drop-down menu.
	* Table Name - enter DUAL.
* To test your connection pool click the Ping button at the top of the frame. A message will be displayed confirming correct operation or otherwise. If an error message is received recheck the previous steps, and ensure that MySQL Connector/J has been correctly copied into the previously specified location.

Now that you have created a connection pool you will also need to create a JDBC Resource (data source) for use by your application.

#### Creating a JDBC Resource

Your Java application will usually reference a data source object to establish a connection with the database. This needs to be created first using the following procedure.

* Using the navigation tree in the GlassFish Administration Console, navigate to Resources, JDBC, JDBC Resources. A list of resources will be displayed in the JDBC Resources frame.
* Click New. The New JDBC Resource frame will be displayed.
* In the JNDI Name field, enter the JNDI name that will be used to access this resource, for example enter jdbc/MySQLDataSource.
* In the Pool Name field, select a connection pool you want this resource to use from the drop-down listbox.
* Optionally, you can enter a description into the Description field.
*  Additional properties can be added if required.
* Click OK to create the new JDBC resource. The JDBC Resources frame will list all available JDBC Resources.



