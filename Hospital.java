/**
 * Representa un hospital público.
 * Permite consultar los datos filiatorios de un paciente.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Hospital
{
    private String nombreHospital;
    private String nombreDirector;

    /**
     * Construye un hospital con su nombre y el nombre del director.
     *
     * @param p_nombreHospital nombre del hospital
     * @param p_nombreDirector nombre del director
     */
    public Hospital(String p_nombreHospital, String p_nombreDirector)
    {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
    }

    /** Getters */
    public String getNombreHospital() {return this.nombreHospital;} //Devuelve el nombre del hospital.
    public String getNombreDirector() {return this.nombreDirector;} //Devuelve el nombre del director.

    /** Setters */
    private void setNombreHospital(String p_nombreHospital) {this.nombreHospital = p_nombreHospital;} //Asigna el nombre del hospital.
    private void setNombreDirector(String p_nombreDirector) {this.nombreDirector = p_nombreDirector;} //Asigna el nombre del director.

    /**
     * Muestra los datos del hospital y los datos filiatorios
     * del paciente recibido como parámetro.
     *
     * @param p_paciente paciente cuyos datos se consultarán
     */
    public void consultaDatosFiliatorios(Paciente p_paciente)
    {
        System.out.println(
            "Hospital: " + this.getNombreHospital()
            + "\tDirector: " + this.getNombreDirector()
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        p_paciente.mostrarDatosPantalla();
    }
}