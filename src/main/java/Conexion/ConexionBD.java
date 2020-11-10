/*
 * Copyright (C) 2020 Giovani Meza
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
