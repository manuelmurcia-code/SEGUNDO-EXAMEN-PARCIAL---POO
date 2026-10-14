
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Principal;

import Controlador.AgendaControlador;
import Modelo.AgendaModelo;
import VIsta.AgendaVista;

/**
 *
 * @author Manue
 */
public class Main {
     
    public static void main(String[] args) {
        AgendaModelo agenda = new AgendaModelo();
        AgendaVista vista = new AgendaVista();
        AgendaControlador controlador = new AgendaControlador(agenda, vista);
        controlador.iniciar();
    }
}
