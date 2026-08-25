/**
 * Representa una escuela que puede emitir el recibo de sueldo
 * de un docente.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Escuela
{
    private String nombre;
    private String domicilio;
    private String director;

    /** Construye una escuela con su nombre, domicilio y director. */
    
    public Escuela( String p_nombre, String p_domicilio, String p_director){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setDirector(p_director);
    }

    /** Setters privados */
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre de la escuela.
    private void setDomicilio(String p_domicilio) { this.domicilio = p_domicilio;} //Asigna el domicilio de la escuela
    private void setDirector(String p_director) { this.director = p_director;}  // Asigna el nombre del director
    
    /**Getters*/
    public String getNombre() { return this.nombre; }  // Asigna el nombre de la escuela 
    public String getDomicilio() { return this.domicilio;}  // Devuelve el domicilio de la escuela.
    public String getDirector() { return this.director; } //Devuelve el nombre del director.

    /**
     * Imprime el recibo de sueldo del docente recibido.
     *
     * @param p_docente docente para el cual se emitirá el recibo
     */
    public void imprimirRecibo(Docente p_docente)
    {
        System.out.println(
            "Escuela: " + this.getNombre()
            + "\tDomicilio: " + this.getDomicilio()
            + "\tDirector: " + this.getDirector()
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        System.out.println( "Docente:\t\t\t" + p_docente.getNombre());

        System.out.println( "Sueldo:\t\t\t\t$ " + p_docente.calcularSueldo());

        System.out.println("Sueldo Básico:\t\t\t$ " + p_docente.getSueldoBasico());

        System.out.println( "Asignación familiar:\t\t$ " + p_docente.getAsignacionFamiliar());
    }
}