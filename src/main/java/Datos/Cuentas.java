/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 * @author Giovani David Meza Poggio Seccion A 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin Seccion A 5990-18-4413
 * @author Flor Eunice Garcia Ajquill Seccion A 5990-18-9172
 */
public class Cuentas {
    private int no_cuenta;//no cuenta de 9 digitos
    private String cui_cliente;//cui de 13 digitos
    private char tipo_cuenta;//puede ser 'A' o 'D'
    private String fecha_creacion;//formato de DD-MM-YYYY
    private double balance;
    
    public Cuentas(){
    //constructor vacio
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public String getCui_cliente() {
        return cui_cliente;
    }

    public void setCui_cliente(String cui_cliente) {
        this.cui_cliente = cui_cliente;
    }

    public char getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(char tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
