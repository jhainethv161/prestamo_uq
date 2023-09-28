package co.edu.uniquindio.prestamo.model;

import java.util.ArrayList;
import java.util.List;

public class PrestamoUq {
    public List<Cliente> obtenerClientes;
    private String nombre;
    List<Cliente> listaClientes = new ArrayList<Cliente>();
    List<Empleado> listaEmpleados = new ArrayList<Empleado>();
    List<Objeto> listaObjetos = new ArrayList<Objeto>();

    public PrestamoUq() {
    }

    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }
    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    /**
     * Metodo para crear un cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return boolean
     */
    public boolean crearCliente(String nombre, String apellido, String cedula, int edad){
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setEdad(edad);
        getListaClientes().add(cliente);
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoUq{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    /**
     * Metodo para obtener la lista de todos los clientes
     * @return List<Cliente>
     */

    public List<Cliente> obtenerClientes(){
        return getListaClientes();
    }

    /**
     * metodo para eliminar un cliiente
     * @param cedula
     */
    public void eliminarCliente(String cedula) {
        int tamanioLista =getListaClientes().size();
        for (int i =0; i < tamanioLista;i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                getListaClientes().remove(i);
                break;
            }
        }
    }

    public void actualizarCliente(String nombre, String apellido, String cedula, int edad) {
        int tamanioLista =getListaClientes().size();
        for (int i =0; i < tamanioLista;i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setCedula(cedula);
                cliente.setEdad(edad);
                break;
            }
        }
    }
}
