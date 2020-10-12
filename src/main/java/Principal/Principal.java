/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Conexion.ConexionBD;
import java.sql.*;
/**
 *
 * @author gm
 */
public class Principal {
    public static void main(String[] args){
    
        Connection conn;
        
             ConexionBD instanciabd = new ConexionBD("35.222.224.214","user","password");
            
            
        try {
             conn = ConexionBD.getConnection();
             System.out.println("conexion establecida");
        } catch (Exception e) {
            System.out.println("error ");
            e.printStackTrace(System.out);
        }
             
            System.out.println("Conexion con exito");
        
    
        
    }
            
            
}
