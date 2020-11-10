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
    private String SQL_SELECT = "CALL Banco.sp_nueva_cuenta(\"4120737389014\",'A',5000);"; 
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
