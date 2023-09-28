package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.model.PrestamoUq;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrestamoUq prestamoUq = inicializarDatosPrueba();
        //create cliente
        crearCliente("maria", "lopez", "1453", 21, prestamoUq);
        crearCliente("juan", "arias", "1094", 30, prestamoUq);
        //read cliente
        mostarInformacionClientes(prestamoUq);
        //update cliente
        actualizarCliente(prestamoUq, "Pablo", "arias", "1094", 31);
        //delete cliente
        eliminarCliente(prestamoUq, "1094");


    }
    private static PrestamoUq inicializarDatosPrueba() {
        PrestamoUq prestamoUq = new PrestamoUq();
        prestamoUq.setNombre("Prestamo Rapido");
        return prestamoUq;
    }
    public static void crearCliente(String nombre,
                                    String apellido,
                                    String cedula,
                                    int edad,
                                    PrestamoUq prestamoUq) {
        prestamoUq.crearCliente(nombre, apellido, cedula, edad);
    }
    private static void mostarInformacionClientes(PrestamoUq prestamoUq) {
        List<Cliente> listaClientes = prestamoUq.obtenerClientes;
        int tamanioLista = listaClientes.size();
        for(int i=0; i<tamanioLista;i++){
            Cliente cliente = listaClientes.get(i);
            System.out.println(cliente.toString());
        }
    }
    private static void eliminarCliente(PrestamoUq prestamoUq, String cedula) {
        prestamoUq.eliminarCliente(cedula);
    }

    private static void actualizarCliente(PrestamoUq prestamoUq, String nombre, String apellido, String cedula, int edad) {
        prestamoUq.actualizarCliente(nombre, apellido, cedula, edad);

    }



}