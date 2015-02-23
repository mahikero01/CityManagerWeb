package company.citymanager.models;

import java.sql.Connection;

public interface ServerConnectionBehavior {
	Connection getConnection();
	String getConnectionURL();
	String getConnectionDetails();
	String getTablesSchemaQuery();
}
