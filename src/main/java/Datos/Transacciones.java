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

package Datos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovani David Meza Poggio Seccion A 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin Seccion A 5990-18-4413
 * @author Flor Eunice Garcia Ajquill Seccion A 5990-18-9172
 */

public class Transacciones {
    private int id;
    private int no_cuenta;
    private String descripcion,fecha_creacion;
    private String tipo_transaccion;
    private double monto,nuevo_balance;
    private String SQL_SELECT2 = "SELECT"
            + "trs.id, trs.no_cuenta,trs.tipo_transaccion,trs.fecha_transaccion,cts.cui_cliente,cts.tipo_cuenta,trs.monto,trs.nuevo_balance,trs.descripcion"
            + "FROM Cuentas cts JOIN  Transacciones trs ON trs.no_cuenta = cts.no_cuenta WHERE cts.no_cuenta = "+ this.getNo_cuenta() + ";";
    
    private String SQL_SELECT = "SELECT * FROM Transacciones WHERE no_cuenta = " + this.getNo_cuenta();
    
    public Transacciones(){
    //constructor vacio
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public String getDecripcion() {
        return descripcion;
    }

    public void setDecripcion(String decripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getNuevo_balance() {
        return nuevo_balance;
    }

    public void setNuevo_balance(double nuevo_balance) {
        this.nuevo_balance = nuevo_balance;
    }
    
    //metodo opcional para obtener un ResultSet de historial de transacciones
    public List<Transacciones> select(){ 
        
        Connection conn = null;//variable tipo connection
        PreparedStatement stmt = null;//variable tipo PreparedStatement
        ResultSet rs = null;//varaible tipo ResultSet
        Transacciones objetoTransacciones;//Variable tipo Cliente(por conveniencia) se podria cambiar por "elemento" ej. Persona elemento;

        ArrayList<Transacciones> listaTransacciones = new ArrayList<Transacciones>();//se crea la lista que utilizaremos
    
    try {    
        conn =  ConexionBD.getConnection();//iniciamos la conexion
        stmt = conn.prepareStatement(SQL_SELECT);//se prepara el statement, esto reduce el trabajo de el DBMS
        rs = stmt.executeQuery();   //se ejecuta la clausula 
        
        while (rs.next()!= false) {//mientras el puntero este en un indice diferente de null en la tabla
           //se toman todos los valores en las variables a continuacion
            int id = rs.getInt(1);
            int no_cuenta = rs.getInt(2);
            String nueva_descripcion = rs.getString(3);
            String tipo_transaccion = rs.getString(4);
            double monto = rs.getDouble(5);
            double nuevo_balance = rs.getDouble(6);
            String fecha_transaccion = rs.getDate(7).toString();
            
 
            objetoTransacciones = new Transacciones();//se crea un nuevo objeto tipo persona, 
            //si no hacemos esto, siempre estariamos reemplazando los atributos de un solo objeto.
            //pasamos todos los argumentos a nuestro objeto persona, por medio de la encapsulacion con los
            //metodos Setters
            objetoTransacciones.setId(id);
            objetoTransacciones.setNo_cuenta(no_cuenta);
            objetoTransacciones.setDecripcion(nueva_descripcion);
            objetoTransacciones.setTipo_transaccion(tipo_transaccion);
            objetoTransacciones.setMonto(monto);
            objetoTransacciones.setNuevo_balance(nuevo_balance);
            objetoTransacciones.setFecha_creacion(fecha_transaccion);
            
            listaTransacciones.add(objetoTransacciones);  //por ultimo, agregamos el objeto a la lista de personas
            //con el metodo Lista.add();
        }
    } catch (SQLException ex) {ex.printStackTrace(System.out);}
    finally{
        //enviamos los objetos creados a una clase diferente, para cerrar la conexion
    ConexionBD.close(conn);
    ConexionBD.close(stmt);
    ConexionBD.close(rs);
    }
    return listaTransacciones;
    }
    
    
}
