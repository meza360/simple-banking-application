/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Conexion.ConexionBD;
/**
 * @author Giovani David Meza Poggio Seccion A 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin Seccion A 5990-18-4413
 * @author Flor Eunice Garcia Ajquill Seccion A 5990-18-9172
 */
public class Clientes {
    
    private String cui,nombre,apellido,email,domicilio;
    private int edad;
    private String SQL_SELECT = "SELECT * FROM Clientes WHERE cui = " + getCui() + ";";
    
    public Clientes(){
    //constructor vacio
     
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Clientes> select(){ 
        
        Connection conn = null;//variable tipo connection
        PreparedStatement stmt = null;//variable tipo PreparedStatement
        ResultSet rs = null;//varaible tipo ResultSet
        Clientes objetoCliente;//Variable tipo Cliente(por conveniencia) se podria cambiar por "elemento" ej. Persona elemento;

        ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();//se crea la lista que utilizaremos
    
    try {    
        conn =  ConexionBD.getConnection();//iniciamos la conexion
        stmt = conn.prepareStatement(SQL_SELECT);//se prepara el statement, esto reduce el trabajo de el DBMS
        rs = stmt.executeQuery();   //se ejecuta la clausula 
        
        while (rs.next()!= false) {//mientras el puntero este en un indice diferente de null en la tabla
           //se toman todos los valores en las variables a continuacion
            String cui = rs.getString(1);
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            int edad = rs.getInt(4);
            String email = rs.getString(5);
            String domicilio = rs.getString(6);
            
            objetoCliente = new Clientes();//se crea un nuevo objeto tipo persona, 
            //si no hacemos esto, siempre estariamos reemplazando los atributos de un solo objeto.
            //pasamos todos los argumentos a nuestro objeto persona, por medio de la encapsulacion con los
            //metodos Setters
            objetoCliente.setCui(cui);
            objetoCliente.setNombre(nombre);
            objetoCliente.setApellido(apellido);
            objetoCliente.setEdad(edad);
            objetoCliente.setEmail(email);
            objetoCliente.setDomicilio(domicilio);
            
            listaClientes.add(objetoCliente);  //por ultimo, agregamos el objeto a la lista de personas
            //con el metodo Lista.add();
        }
    } catch (SQLException ex) {ex.printStackTrace(System.out);}
    finally{
        //enviamos los objetos creados a una clase diferente, para cerrar la conexion
    ConexionBD.close(conn);
    ConexionBD.close(stmt);
    ConexionBD.close(rs);
    }
    return listaClientes;
    }
   
    
    @Override
    public String toString(){
        return "\nCui Cliente: " + this.getCui()
                + "\nNombre: cliente: " + this.getNombre()
                + "\nApellido cliente: " + this.getApellido()
                + "\nEdad: " + this.getEdad()
                + "\nEmail: " + this.getEmail()
                + "\nDireccion domicilio: " + this.getDomicilio();                 
    
    }
}
