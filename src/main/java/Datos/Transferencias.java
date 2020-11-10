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
 *
 * @author Giovani David Meza Poggio Seccion A 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin Seccion A 5990-18-4413
 * @author Flor Eunice Garcia Ajquill Seccion A 5990-18-9172
 */

public class Transferencias {
    
    private int id;
    private int no_cuenta;
    private String descripcion,fecha_transaccion;
    private char tipo_transaccion;
    private double monto;
    
    public Transferencias(){
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(String fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public char getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(char tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
