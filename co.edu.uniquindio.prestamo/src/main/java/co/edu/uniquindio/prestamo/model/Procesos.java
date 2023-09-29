package co.edu.uniquindio.prestamo.model;

import javax.swing.*;

public class Procesos {
    public static String pedirCadena(String mensaje){
        String cadena = JOptionPane.showInputDialog(mensaje);
        return cadena;
    }
    public static int pedirEntero(String mensaje){
        int num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return num;
    }


}
