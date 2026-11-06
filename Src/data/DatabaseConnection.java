package Src.data;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL="jdbc:sqlite:inventory.db";
    public static Connection getConnection(){
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(URL);
            System.out.println("Connected to SQLite database successfully!");
        }catch(SQLException e){
            System.out.println("Connection failed:"+e.getMessage());
        }
     return conn;}
    
}
