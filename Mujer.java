/**
 * Representa a una mujer y permite administrar su estado civil
 * y su relación con un esposo.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Mujer
{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;

    // Objeto colaborador.
    private Hombre esposo;

    /**
     * Construye una mujer sin esposo.
     * Su estado civil inicial es Soltera.
     *
     * @param p_nombre nombre de la mujer
     * @param p_apellido apellido de la mujer
     * @param p_edad edad de la mujer
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad)
    {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
        this.setEsposo(null);
    }

    /**
     * Construye una mujer casada con el hombre recibido.
     * Su estado civil inicial es Casada.
     *
     * @param p_nombre nombre de la mujer
     * @param p_apellido apellido de la mujer
     * @param p_edad edad de la mujer
     * @param p_esposo hombre que será su esposo
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad, Hombre p_esposo) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
        this.setEsposo(null);
        this.casarseCon(p_esposo);
    }

    /** Setters */
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre de la mujer.
    private void setApellido(String p_apellido) {this.apellido = p_apellido;} //Asigna el apellido de la mujer.
    private void setEdad(int p_edad) {this.edad = p_edad;} //Asigna la edad de la mujer.
    private void setEstadoCivil(String p_estadoCivil) {this.estadoCivil = p_estadoCivil;} //Asigna el estado civil.
    private void setEsposo(Hombre p_esposo) {this.esposo = p_esposo;} //Asigna el esposo de la mujer.
    
    /** Getters */
    public String getNombre() {return this.nombre;} //Devuelve el nombre de la mujer.
    public String getApellido() {return this.apellido;} //Devuelve el apellido de la mujer.
    public int getEdad() {return this.edad;} //Devuelve la edad de la mujer.
    public String getEstadoCivil() {return this.estadoCivil;} //Devuelve el estado civil.
    public Hombre getEsposo() {return this.esposo;} //Devuelve el esposo de la mujer.

    /**
     * Casa a la mujer con el hombre recibido si ninguno de los dos esta casado. 
     * Establece el doble conocimiento entre ambos objetos
     * Asigna el esposo y cambia su estado civil a Casada.
     *
     * @param p_hombre hombre con el que se desea casar
     */
    public void casarseCon(Hombre p_hombre)
    {
        if((this.getEsposo() == null) && (p_hombre.getEsposa() == null) || p_hombre.getEsposa() == this){
        this.setEsposo(p_hombre);
        this.setEstadoCivil("Casada");
        /**Si el hombre todavia no conoce a esta mujer como esposa, se completa la relacion*/
        if( p_hombre.getEsposa() == null){
            p_hombre.casarseCon(this);
        } 
        else 
        {
            System.out.println("No se puede realizar el matrimonio: " + "Alguna de las dos personas ya esta casada.");
        }
    }
    }

    /**
     * Divorcia a la mujer.
     * Elimina la referencia al esposo y cambia su estado
     * civil a Divorciada.
     */
    public void divorcio()
    {
        Hombre esposoAnterior = this.getEsposo();
        if(this.getEsposo() != null){
            /**Se guarda temporalmente al esposo antes de eliminar la referencia*/
            this.setEsposo(null);
            this.setEstadoCivil("Divorciada");
        } 
        /**Se actualiza tambien el estado del esposo*/
        if(esposoAnterior.getEsposa() == this){
            esposoAnterior.divorcio();
        }
        else{
            System.out.println("No se puede divorciar porque no esta casada");
        }
    }

    /**
     * Devuelve el nombre, apellido y edad de la mujer.
     *
     * @return datos personales de la mujer
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
     * Muestra los datos de la mujer y de su esposo.
     */
    public void casadaCon()
    {
        if (this.getEsposo() != null) {
            System.out.println(this.datos() + " está casada con " + this.getEsposo().datos());
        }
        else{
            System.out.println(this.datos() + " No tiene esposo actualmente" );
        }
    }
}