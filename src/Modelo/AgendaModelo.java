/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author Manue
 */
public class AgendaModelo {
    
    private ArrayList<ContactoModelo> contactos;

    public AgendaModelo() {
        contactos = new ArrayList<>();
    }

    public ArrayList<ContactoModelo> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<ContactoModelo> contactos) {
        this.contactos = contactos;
    }

    public boolean guardarContacto(ContactoModelo nuevo) {
        if (buscarContacto(nuevo.getNombre()) != null) {
            return false;
        }
        contactos.add(nuevo);
        return true;
    }
    
    public String buscarTelefono(String nombre) {
        ContactoModelo encontrado = buscarContacto(nombre);
        if (encontrado != null) {
            return encontrado.getTelefono();
        }
        return null;
    }

    private ContactoModelo buscarContacto(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            ContactoModelo c = contactos.get(i);
            if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
                return c;
            }
        }
        return null;
    }
}
