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
        this.setEstadoCivil("Soltero");
        this.setEsposa(null);
        this.casarseCon(p_esposa);
    }
    
    /** Setters */
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre del hombre.
    private void setApellido(String p_apellido) {this.apellido = p_apellido;} //Asigna el apellido del hombre.
    private void setEdad(int p_edad) {this.edad = p_edad;} //Asigna la edad del hombre.
    private void setEstadoCivil(String p_estadoCivil) {this.estadoCivil = p_estadoCivil;} //Asigna el estado civil.
    private void setEsposa(Mujer p_esposa) {this.esposa = p_esposa;} //Asigna la esposa del hombre.
    
    /** Getters */
    public String getNombre() {return this.nombre;} //Devuelve el nombre del hombre.
    public String getApellido() {return this.apellido;} //Devuelve el apellido del hombre.
    public int getEdad() {return this.edad;} //Devuelve la edad del hombre.
    public String getEstadoCivil() {return this.estadoCivil;} //Devuelve el estado civil.
    public Mujer getEsposa() {return this.esposa;} //Devuelve la esposa del hombre.


    /**
     * Casa al hombre con la mujer recibida.
     * Asigna la esposa y cambia su estado civil a Casado.
     *
     * @param p_mujer mujer con la que se casará
     */
    public void casarseCon(Mujer p_mujer)
    {
        /** Casa al homnbre con la mujer recibida si ninguno de los dos esta casado. 
        *Establece el doble conocimiento entre ambos objetos*/
        if((this.getEsposa() == null) && (p_mujer.getEsposo() == null) || p_mujer.getEsposo() == this){
        this.setEsposa(p_mujer);
        this.setEstadoCivil("Casadao");
        /**Si el hombre todavia no conoce a esta mujer como esposa, se completa la relacion*/
        if( p_mujer.getEsposo() == null){
            p_mujer.casarseCon(this);
        }
        }
        else 
        {
            System.out.println("No se puede realizar el matrimonio: " + "Alguna de las dos personas ya esta casada.");
        }
    }

    /**
     * Divorcia al hombre.
     * Elimina la referencia a la esposa y cambia su estado
     * civil a Divorciado.
     */
    public void divorcio()
    {
        Mujer esposaAnterior = this.getEsposa();
        if(this.getEsposa() != null){
            /**Se guarda temporalmente al esposo antes de eliminar la referencia*/
            this.setEsposa(null);
            this.setEstadoCivil("Divorciado");
        } 
        /**Se actualiza tambien el estado del esposo*/
        if(esposaAnterior.getEsposo() == this){
            esposaAnterior.divorcio();
        }
        else{
            System.out.println("No se puede divorciar porque no esta casado");
        }
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
     * Muestra los datos de la mujer y de su esposo.
     */
    public void casadoCon()
    {
        if (this.getEsposa() != null) {
            System.out.println(this.datos() + " está casado con " + this.getEsposa().datos());
        }
        else{
            System.out.println(this.datos() + " No tiene esposa actualmente" );
        }
    }
    
}