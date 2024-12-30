/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicserver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author 2180607502_NguyenTrungHieu
 */
public class DBAccess {
    private Connection con;
    private Statement stmt;
    public DBAccess(){
        try{
            MyConnection mycon = new MyConnection();
            con = mycon.getConnection();
            stmt = con.createStatement();
        } catch (Exception e){
            
        }
    }
    
    public int Update(String str){
        try{
            int i = stmt.executeUpdate(str);
            return i;
        } catch(Exception e){
            return -1;
        }
    }
    
    public ResultSet Query(String str){
        try{
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch(Exception e){
            return null;
        }
    }
}
