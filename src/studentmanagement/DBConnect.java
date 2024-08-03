/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagement;
import java.sql.*;
/**
 *
 * @author upagy
 */
public class DBConnect {
    static Connection con  =null;
    
    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/studm?user=root&password=");
        }catch(Exception e){
            System.out.println(e);
        }                      

        return con;
    }
}
/*
1-2               wordpress  
2-3.30           js
3.30 to 4.30 html
4.30 to 6      java batch
*/
