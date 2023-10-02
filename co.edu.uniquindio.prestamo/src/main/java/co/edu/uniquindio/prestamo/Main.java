package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.model.Empleado;
import co.edu.uniquindio.prestamo.model.Objeto;
import co.edu.uniquindio.prestamo.model.PrestamoUq;

import javax.swing.*;
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

       //EMPLEADO
        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(prestamoUq.menuEmpleado()));
            switch (opcion){
                case 1:
                    crearEmpleado(prestamoUq);
                    mostarInformacionEmpleados(prestamoUq);
                    System.out.println("-----------------------------");
                    break;
                case 2:
                    actualizarEmpleado(prestamoUq);
                    mostarInformacionEmpleados(prestamoUq);
                    System.out.println("-----------------------------");
                    break;
                case 3:
                    eliminarEmpleado(prestamoUq);
                    mostarInformacionEmpleados(prestamoUq);
                    System.out.println("-----------------------------");
                    break;
                case 4:
                    mostarInformacionEmpleados(prestamoUq);
                    System.out.println("-----------------------------");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,"Gracias por utilizar el programa");
                    break;
            }

        }while (opcion!=5);

        //OBJETO
        //create objeto
        crearObjeto("Control","01", prestamoUq);
        crearObjeto("Computdor","02", prestamoUq);
        //read objeto
        mostrarInformacionObjetos(prestamoUq);
        //update objeto
        actualizarObjeto("Control videoBeam", "01", prestamoUq);
        //delete objeto
        eliminarObjeto(prestamoUq, "02");
    }

    //CLIENTE-----------------------------------------------------------------------------------

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
        List<Cliente> listaClientes = prestamoUq.obtenerClientes();
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

    //EMPLEADO----------------------------------------------------------------------------------
    public static void crearEmpleado(PrestamoUq prestamoUq) {
        prestamoUq.crearEmpleado();
    }

    private static void mostarInformacionEmpleados(PrestamoUq prestamoUq) {
        List<Empleado> listaEmpleados = prestamoUq.obtenerEmpleados();
        int tamanioLista = listaEmpleados.size();
        for (int i =0; i<tamanioLista;i++){
            Empleado empleado = listaEmpleados.get(i);
            System.out.println(empleado.toString());
        }
    }

    private static void actualizarEmpleado(PrestamoUq prestamoUq){
        prestamoUq.actualizarEmpleado();
    }

    private static void eliminarEmpleado(PrestamoUq prestamoUq) {
        prestamoUq.eliminarEmpleado();
    }

    //OBJETO----------------------------------------------------------------------------------------

    private static void crearObjeto(String nombre, String idObjeto, PrestamoUq prestamoUq) {
        prestamoUq.crearObjeto(nombre, idObjeto);
    }

    private static void mostrarInformacionObjetos(PrestamoUq prestamoUq) {
        List<Objeto> listaObjetos = prestamoUq.getListaObjetos();
        int tamanioLista = listaObjetos.size();
        for (int i = 0; i<tamanioLista;i++){
            Objeto objeto = listaObjetos.get(i);
            System.out.println(objeto.toString());
        }
    }

    private static void actualizarObjeto(String nombre, String idObjeto, PrestamoUq prestamoUq) {
        prestamoUq.actualizarObjeto(nombre, idObjeto);
    }

    private static void eliminarObjeto(PrestamoUq prestamoUq, String idObjeto) {
        prestamoUq.eliminarObjeto(idObjeto);
    }

}