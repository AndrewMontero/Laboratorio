/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajas;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Cliente {
    private String numero;
    private char prioridad;
    private int tiempoAtencion;

    public Cliente(String numero, char prioridad) {
        this.numero = numero;
        this.prioridad = prioridad;
        this.tiempoAtencion = 0;
    }

    public String getNumero() {
        return numero;
    }

    public char getPrioridad() {
        return prioridad;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }
}