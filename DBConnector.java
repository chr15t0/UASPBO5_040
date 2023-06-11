package UAS;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnector {
    static Connection connection;
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/library";
    
    static final String USER = "root";
    static final String PASSWORD = "";
    
    public static void initDBConnection(){
        
        try{
            Class.forName(JDBC_DRIVER);
            
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            if(connection != null){
                System.out.println("Connection Successful");
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }        
    }
}
