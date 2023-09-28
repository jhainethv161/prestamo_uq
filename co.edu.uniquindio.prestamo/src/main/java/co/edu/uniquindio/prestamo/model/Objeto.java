package co.edu.uniquindio.prestamo.model;

public class Objeto {
    private String nombre;
    private String idObjeto;
    PrestamoUq prestamoUq;

    public Objeto() {
    }

    public Objeto(String nombre, String idObjeto) {
        this.nombre = nombre;
        this.idObjeto = idObjeto;
    }

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public PrestamoUq getPrestamoUq() {
        return prestamoUq;
    }

    public void setPrestamoUq(PrestamoUq prestamoUq) {
        this.prestamoUq = prestamoUq;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                '}';
    }
}
