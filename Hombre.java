/**
 * Representa a un hombre y permite administrar su estado civil
 * y su relación con una esposa.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Hombre
{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;

    // Objeto colaborador.
    private Mujer esposa;

    /**
     * Construye un hombre sin esposa.
     * Su estado civil inicial es Soltero.
     *
     * @param p_nombre nombre del hombre
     * @param p_apellido apellido del hombre
     * @param p_edad edad del hombre
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad)
    {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
        this.setEsposa(null);
    }

    /**
     * Construye un hombre casado con la mujer recibida.
     * Su estado civil inicial es Casado.
     *
     * @param p_nombre nombre del hombre
     * @param p_apellido apellido del hombre
     * @param p_edad edad del hombre
     * @param p_esposa mujer que será su esposa
     */
    public Hombre( String p_nombre, String p_apellido, int p_edad, Mujer p_esposa) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Casado");
        this.setEsposa(p_esposa);
    }

    /** Getters */
    public String getNombre() {return this.nombre;} //Devuelve el nombre del hombre.
    public String getApellido() {return this.apellido;} //Devuelve el apellido del hombre.
    public int getEdad() {return this.edad;} //Devuelve la edad del hombre.
    public String getEstadoCivil() {return this.estadoCivil;} //Devuelve el estado civil.
    public Mujer getEsposa() {return this.esposa;} //Devuelve la esposa del hombre.

    /** Setters */
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre del hombre.
    private void setApellido(String p_apellido) {this.apellido = p_apellido;} //Asigna el apellido del hombre.
    private void setEdad(int p_edad) {this.edad = p_edad;} //Asigna la edad del hombre.
    private void setEstadoCivil(String p_estadoCivil) {this.estadoCivil = p_estadoCivil;} //Asigna el estado civil.
    private void setEsposa(Mujer p_esposa) {this.esposa = p_esposa;} //Asigna la esposa del hombre.

    /**
     * Casa al hombre con la mujer recibida.
     * Asigna la esposa y cambia su estado civil a Casado.
     *
     * @param p_mujer mujer con la que se casará
     */
    public void casarseCon(Mujer p_mujer)
    {
               /** Casa a la mujer con el hombre recibido si ninguno de los dos esta casado. 
           *Establece el doble conocimiento entre ambos objetos*/
        if((this.getEsposa() == null) && (p_mujer.getEsposo() == null) || p_mujer.getEsposo() == this){
        this.setEsposa(p_mujer);
        this.setEstadoCivil("Casada");
        }
        /**Si el hombre todavia no conoce a esta mujer como esposa, se completa la relacion*/
        if( p_mujer.getEsposo() == null){
            p_mujer.casarseCon(this);
        }
    }

    /**
     * Divorcia al hombre.
     * Elimina la referencia a la esposa y cambia su estado
     * civil a Divorciado.
     */
    public void divorcio()
    {
        this.setEsposa(null);
        this.setEstadoCivil("Divorciado");
    }

    /**
     * Devuelve el nombre, apellido y edad del hombre.
     *
     * @return datos personales del hombre
     */
    public String datos()
    {
        return this.getNombre()
            + " " + this.getApellido()
            + " de " + this.getEdad() + " años";
    }

    /**
     * Muestra los datos personales y el estado civil.
     */
    public void mostrarEstadoCivil()
    {
        System.out.println(
            this.datos() + " - " + this.getEstadoCivil()
        );
    }

    /**
     * Muestra los datos del hombre y de su esposa.
     */
    public void casadoCon()
    {
        System.out.println(
            this.datos()
            + " está casado con "
            + this.getEsposa().datos()
        );
    }
}