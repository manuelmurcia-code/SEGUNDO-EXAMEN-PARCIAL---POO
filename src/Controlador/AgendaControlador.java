/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.AgendaModelo;
import Modelo.ContactoModelo;
import VIsta.AgendaVista;

/**
 *
 * @author Manue
 */
public class AgendaControlador implements ActionListener {

    private final AgendaModelo agenda;
    private final AgendaVista vista;

    public AgendaControlador(AgendaModelo agenda, AgendaVista vista) {
        this.agenda = agenda;
        this.vista = vista;
    }

    

    public void iniciar() {
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            guardar();
        } else if (e.getSource() == vista.getBtnBuscar()) {
            buscar();
        }
    }

    private void guardar() {
        String nombre = vista.getNombre().trim();
        String telefono = vista.getTelefono().trim();

        if (nombre.equals("") || telefono.equals("")) {
            vista.mostrarMensaje("Debe llenar el nombre y el telefono.");
            return;
        }
        if (!telefono.matches("[0-9]+")) {
            vista.mostrarMensaje("El telefono solo debe tener numeros.");
            return;
        }

        ContactoModelo nuevo = new ContactoModelo(nombre, telefono);
        boolean guardado = agenda.guardarContacto(nuevo);

        if (guardado) {
            vista.mostrarMensaje("Contacto guardado correctamente.");
            vista.limpiarFormulario();
        } else {
            vista.mostrarMensaje("Ya existe un contacto con ese nombre.");
        }
    }

    private void buscar() {
        String nombre = vista.getNombreBuscar().trim();

        if (nombre.equals("")) {
            vista.mostrarMensaje("Escriba el nombre que desea buscar.");
            return;
        }

        String telefono = agenda.buscarTelefono(nombre);

        if (telefono != null) {
            vista.mostrarResultado(telefono);
        } else {
            vista.mostrarResultado("Contacto no encontrado");
        }
    }
}
