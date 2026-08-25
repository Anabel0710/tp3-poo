/**
 * Representa un paciente de un hospital.
 * Almacena sus datos filiatorios y conoce la localidad donde
 * nació y la localidad donde vive actualmente.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Paciente
{
    private int historiaClinica;
    private String nombre;
    private String domicilio;

    // Objetos colaboradores.
    private Localidad localidadNacido;
    private Localidad localidadVive;

    /**
     * Construye un paciente con sus datos filiatorios,
     * su localidad de nacimiento y su localidad de residencia.
     *
     * @param p_historia número de historia clínica
     * @param p_nombre nombre completo del paciente
     * @param p_domicilio domicilio actual del paciente
     * @param p_localidadNacido localidad donde nació
     * @param p_localidadVive localidad donde vive
     */
    public Paciente(
        int p_historia,
        String p_nombre,
        String p_domicilio,
        Localidad p_localidadNacido,
        Localidad p_localidadVive
    )
    {
        this.setHistoriaClinica(p_historia);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setNacido(p_localidadNacido);
        this.setVive(p_localidadVive);
    }

    /** Getters */
    public int getHistoriaClinica() {return this.historiaClinica;} //Devuelve la historia clínica.
    public String getNombre() {return this.nombre;} //Devuelve el nombre del paciente.
    public String getDomicilio() {return this.domicilio;} //Devuelve el domicilio del paciente.
    public Localidad getNacido() {return this.localidadNacido;} //Devuelve la localidad donde nació.
    public Localidad getVive() {return this.localidadVive;} //Devuelve la localidad donde vive.

    /** Setters */
    private void setHistoriaClinica(int p_historia) {this.historiaClinica = p_historia;} //Asigna la historia clínica.
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre del paciente.
    private void setDomicilio(String p_domicilio) {this.domicilio = p_domicilio;} //Asigna el domicilio.
    private void setNacido(Localidad p_nacido) {this.localidadNacido = p_nacido;} //Asigna la localidad de nacimiento.
    private void setVive(Localidad p_vive) {this.localidadVive = p_vive;} //Asigna la localidad donde vive.

    /**
     * Muestra por pantalla los datos filiatorios del paciente
     * y de la localidad donde vive.
     */
    public void mostrarDatosPantalla()
    {
        System.out.println(
            "Paciente: " + this.getNombre()
            + "\tHistoria Clínica: " + this.getHistoriaClinica()
            + "\tDomicilio: " + this.getDomicilio()
        );

        System.out.println(this.getVive().mostrar());
    }

    /**
     * Devuelve los datos filiatorios del paciente en una cadena.
     *
     * @return datos del paciente y de su localidad de residencia
     */
    public String cadenaDeDatos()
    {
        return this.getNombre()
            + " ..... " + this.getHistoriaClinica()
            + " ..... " + this.getDomicilio()
            + " - " + this.getVive().getNombre()
            + " - " + this.getVive().getProvincia();
    }
}