/**
 * Representa a un docente de una escuela.
 * Almacena su nombre, grado, sueldo básico y asignación familiar.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Docente
{
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;

    /**
     * Construye un docente con todos sus datos.
     *
     * @param p_nombre nombre del docente
     * @param p_grado grado a cargo del docente
     * @param p_sueldoBasico sueldo básico del docente
     * @param p_asignacionFamiliar asignación familiar del docente
     */
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico,double p_asignacionFamiliar) {
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAsignacionFamiliar(p_asignacionFamiliar);
    }
  
    
    private void setNombre(String p_nombre){ this.nombre = p_nombre; } //Asigna el nombre del docente.
    private void setGrado(String p_grado) { this.grado = p_grado;} //Asigna el grado del docente.
    private void setSueldoBasico(double p_sueldoBasico) {this.sueldoBasico = p_sueldoBasico;} //Asigna el sueldo básico del docente.
    private void setAsignacionFamiliar(double p_asignacionFamiliar)
    {
        this.asignacionFamiliar = p_asignacionFamiliar;
    } //Asigna la asignación familiar del docente.

    /** Getters */
    public String getNombre() {return this.nombre;} //Devuelve el nombre del docente.
    public String getGrado() {return this.grado;} //Devuelve el grado del docente.
    public double getSueldoBasico() { return this.sueldoBasico; } //Devuelve el sueldo básico del docente.
    public double getAsignacionFamiliar(){ return this.asignacionFamiliar;} //Devuelve la asignación familiar del docente.

    /**
     * Calcula el sueldo total del docente sumando el sueldo
     * básico y la asignación familiar.
     *
     * @return sueldo total del docente
     */
    public double calcularSueldo()
    {
        return this.getSueldoBasico()
            + this.getAsignacionFamiliar();
    }
}