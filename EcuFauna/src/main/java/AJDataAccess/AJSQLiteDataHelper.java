package AJDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AJSQLiteDataHelper {

    private static Connection AJConn;
    private static final String AJPATHDBCONNECTION = "DataBase\\AJDataBase.sqlite";

    protected static synchronized Connection AJOpenConnection() {
        try {
            if (AJConn == null) {
                AJConn = DriverManager.getConnection("jdbc:sqlite:" + AJPATHDBCONNECTION);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return AJConn;
    }

    protected static synchronized Boolean AJCloseConnection() {
        try {
            if (AJConn != null) {
                AJConn.close();
                return true;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return false;
    }
}
