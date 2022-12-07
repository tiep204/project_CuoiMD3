package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cuoimd3";
    private static final String USERNAME = "root";
    private static final String PASS = "dangtiep204";
    public static Connection oprenConnection(){
        Connection conn = null;
        try {
            /////
            Class.forName(DRIVER);
            /////
            conn = DriverManager.getConnection(URL,USERNAME,PASS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement callSt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(callSt!=null){
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
