package Oefeningen.ContactsGUI.DatabankAccess.jdbc;

import Oefeningen.ContactsGUI.DatabankAccess.DataAccessContext;
import Oefeningen.ContactsGUI.DatabankAccess.DataAccessProvider;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDataAccessProvider implements DataAccessProvider {

    private Properties properties;

    public JDBCDataAccessProvider(String resources){
        properties = new Properties();
        try (InputStream inp = JDBCDataAccessProvider.class.getResourceAsStream(resources)) {
            properties.load(inp);
        } catch (IOException ex) {
            throw new RuntimeException("Could not read database properties", ex);
        }
    }

    public JDBCDataAccessProvider() {
        this ("database.properties");
    }

    @Override
    public JDBCDataAccessContext getDataAccessContext() throws Exception {
            return new JDBCDataAccessContext(getConnection());
    }

    public Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
