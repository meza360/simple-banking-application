/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.*;
/**
 * @author Giovani David Meza Poggio Seccion A 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin Seccion A 5990-18-4413
 * @author Flor Eunice Garcia Ajquill Seccion A 5990-18-9172
 */
public class ConexionBD {
    private static String host,user,password,url;
    
    public ConexionBD(){}
    
    public ConexionBD(String host,String user,String password){
    ConexionBD.host = host;
    ConexionBD.user = user;
    ConexionBD.password = password;
    url = "jdbc:mysql://" + ConexionBD.host 
            + ":3306/Banco?useSSL=false&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    }
    
    public static Connection getConnection()throws SQLException{//este metodo se puede llamar desde cualquier clase
        try {
            Connection conexion;
            conexion = DriverManager.getConnection(url,user,password);
            return conexion;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }
    
    
    public static void close(Connection instruccion){//cierra conexiones tipo connection
        try {     
            instruccion.close();
        } catch (Exception e) {
        }
        }
    
    public static void close(PreparedStatement instruccion){//cierra conexiones tipo PreparedStatement
        try { 
            try (instruccion) {
                instruccion.closeOnCompletion();
            }
        } catch (Exception e) {
        }
    }
    
    public static void close(ResultSet instruccion){//cierra conexiones tipo ResultSet
        try {
            instruccion.close();
        } catch (Exception e) {
        }
    }
}
