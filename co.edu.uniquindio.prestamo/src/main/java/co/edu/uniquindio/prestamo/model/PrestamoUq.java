package co.edu.uniquindio.prestamo.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoUq {
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

    Procesos procesos = new Procesos();

    @Override
    public String toString() {
        return "PrestamoUq{" +
                "nombre='" + nombre + '\'' +
                '}';
    }


    //CLIENTE ---------------------------
    /**
     * Metodo para obtener la lista de todos los clientes
     * @return List<Cliente>
     */

    public List<Cliente> obtenerClientes(){
        return getListaClientes();
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

    /**
     * metodo para eliminar un cliente
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

    /**
     * Metodo que permite actualizar la informacion de un cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     */
    public void actualizarCliente(String nombre, String apellido, String cedula, int edad) {
        int tamanioLista =getListaClientes().size();
        for (int i =0; i < tamanioLista;i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setCedula(cedula);
                cliente.setEdad(edad);
                getListaClientes().set(i, cliente);
                break;
            }
        }
    }

    //EMPLEADO-------------------------------------

    /**
     * Metodo para obtener la lista de todos los empleados
     * @return List<Empleado>
     */
    public List<Empleado> obtenerEmpleados(){
        return getListaEmpleados();
    }


    /**
     * Metodo que permite registrar un nuevo empleado
     * @return boolean
     */
    public boolean crearEmpleado() {
        String nombre = procesos.pedirCadena("Ingrese el nombre del empleado");
        String apellido = procesos.pedirCadena("Ingrese el apellido del empleado");
        int edad = procesos.pedirEntero("Ingrese la edad del empleado");
        String cedula = "";
        boolean existe = false;
        int tamanioLista = getListaEmpleados().size();
        do {
            cedula = procesos.pedirCadena("Ingrese la cedula del empleado");
            for (int i = 0; i < tamanioLista; i++) {
                Empleado empleado = getListaEmpleados().get(i);
                if (empleado.getCedula().equalsIgnoreCase(cedula)) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                JOptionPane.showMessageDialog(null, "La cédula ya está asociada a otro empleado. Intente nuevamente.");
            }
        } while (existe);


        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCedula(cedula);
        empleado.setEdad(edad);
        getListaEmpleados().add(empleado);
        return true;
    }
    /**
      * Metodo que permite actualizar la informacionde un empleado
     */
    public void actualizarEmpleado() {
        String cedula = procesos.pedirCadena("Ingrese la cedula del cliente que desea actualizar");
        int tamanioLista = getListaEmpleados().size();
        boolean existe = false;

        for(int i = 0; i<tamanioLista;i++){
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                String nombre = procesos.pedirCadena("Ingrese el nombre del empleado");
                String apellido = procesos.pedirCadena("Ingrese el apellido del empleado");
                int edad = procesos.pedirEntero("Ingrese la edad del empleado");
                do {
                    cedula = procesos.pedirCadena("Ingrese la cedula del empleado");
                    existe = false;
                    for (int j = 0; j < tamanioLista; j++) {
                        if (empleado.getCedula().equalsIgnoreCase(cedula)) {
                            existe = true;
                            break;
                        }
                    }

                } while (existe);

                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setCedula(cedula);
                empleado.setEdad(edad);
                getListaEmpleados().set(i, empleado);
            }else{
                JOptionPane.showMessageDialog(null, "La cedula ingresada no se encuentra asociiada a nuingun empleado");
            }
        }
    }

    /**
     * Metodo que permite eliminar a un empleado de la lista
     */
    public void eliminarEmpleado() {
        String cedula = procesos.pedirCadena("Ingrese la cedula del cliente que desea eliminar: ");
        boolean existe = false;
        int tamanioLista = getListaEmpleados().size();
        for (int i=0;i<tamanioLista;i++){
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                getListaEmpleados().remove(i);
                existe = true;
                break;
            }
        }

    }


    public  String menuEmpleado(){
        String mensaje = "Usted desea: \n"+
                "1. Crear empleado \n"+
                "2. Actualizar empleado \n"+
                "3. Eliminar empleado \n"+
                "4. Mostrar informacion empleados \n"+
                "5.salir \n";
        return mensaje;
    }

    //OBJETO----------------------------

    public List<Objeto> obtenerObjetos(){return getListaObjetos();}

    /**
     * Metodo que permite crear un nuevo objeto (producto)
     * @param nombre
     * @return boolean
     */
    public boolean crearObjeto(String nombre, String idObjeto) {
        Objeto objeto = new Objeto();
        objeto.setNombre(nombre);
        objeto.setIdObjeto(idObjeto);
        getListaObjetos().add(objeto);
        return true;
    }

    /**
     * Metodo que permie actualizar la informacion asociada a un objeto
     * @param nombre
     * @param idObjeto
     */
    public void actualizarObjeto(String nombre, String idObjeto) {
        int tamanioLista = getListaObjetos().size();
        for (int i =0; i<tamanioLista;i++){
            Objeto objeto = getListaObjetos().get(i);
            if (objeto.getIdObjeto().equalsIgnoreCase(idObjeto)){
                objeto.setNombre(nombre);
                objeto.setIdObjeto(idObjeto);
                getListaObjetos().set(i,objeto);
                break;
            }
        }
    }

    /**
     * Metodo p[ara eliminar un objeto de la lista
     * @param idObjeto
     */
    public void eliminarObjeto(String idObjeto) {
        int tamanioLista = getListaObjetos().size();
        for (int i = 0; i<tamanioLista; i++){
            Objeto objeto = getListaObjetos().get(i);
            if (objeto.getIdObjeto().equalsIgnoreCase(idObjeto)){
                getListaObjetos().remove(i);
                break;
            }
        }
    }
}
