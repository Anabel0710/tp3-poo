import java.util.*;
import java.util.GregorianCalendar;
/**
 * Clase Persona que representa una persona con DNI, nombre, apellido y año de nacimiento.
 * Permite calcular la edad y mostrar los datos.
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version (a version number or a date)
 */
public class Persona
{
    private int nroDni;
    private String nombre;
    private String apellido;
    private int anioNacimiento;
    
     /** Constructor de Persona */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio){
        setDNI(p_dni);
        setNombre(p_nombre);
        setApellido (p_apellido);
        setAnioNacimiento (p_anio);
    }
    
    /** Getters */
    public int getDNI() {return nroDni; }
    public String getNombre() {return nombre; }
    public String getApellido() {return apellido; }
    public int getAnioNacimiento() {return anioNacimiento; } 
    
    /** Setters privados */
    private void setDNI(int p_dni) { nroDni = p_dni; }
    private void setNombre (String p_nombre) {nombre = p_nombre; }
    private void setApellido (String p_apellido) {apellido = p_apellido; }
    private void setAnioNacimiento (int p_anio) {anioNacimiento = p_anio;}
    
    /**Calcula la edad de la persona */
    public int edad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - anioNacimiento;
    }
    
    /** Devuelve nombre y apellido juntos */
    public String nomYApe() { return nombre + " " + apellido; }
    /** Devuelve apellido y nombre juntos */
    public String apeYNom() { return apellido + " " + nombre; }
    
    /** Muestra los datos de la persona */
    public void mostrar() {
        System.out.println ("Nombre y Apellido: " + nomYApe());
        System.out.println ("DNI: " + nroDni + " Edad: " + edad() + " años"); 
    }
}