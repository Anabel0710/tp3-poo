/**
 * Representa a una mujer y permite administrar su estado civil
 * y su relación con un esposo.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Mujer {
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
    public Mujer(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
        this.setEsposo(null);
    }

    /**
     * Construye una mujer casada con el hombre recibido.
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
    private void setNombre(String p_nombre) { this.nombre = p_nombre; }
    private void setApellido(String p_apellido) { this.apellido = p_apellido; }
    private void setEdad(int p_edad) { this.edad = p_edad; }
    private void setEstadoCivil(String p_estadoCivil) { this.estadoCivil = p_estadoCivil; }
    private void setEsposo(Hombre p_esposo) { this.esposo = p_esposo; }

    /** Getters */
    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellido; }
    public int getEdad() { return this.edad; }
    public String getEstadoCivil() { return this.estadoCivil; }
    public Hombre getEsposo() { return this.esposo; }

    /**
     * Casa a la mujer con el hombre recibido si ninguno de los dos está casado.
     * Establece el doble conocimiento entre ambos objetos y cambia su estado civil a Casada.
     *
     * @param p_hombre hombre con el que se desea casar
     */
    public void casarseCon(Hombre p_hombre) {
        if (p_hombre != null && this.getEsposo() == null && p_hombre.getEsposa() == null) {
            this.setEsposo(p_hombre);
            this.setEstadoCivil("Casada");
            // Se le asigna la mujer al hombre y se cambia su estado civil directamente
            p_hombre.casarseCon(this); 
        } else if (this.getEsposo() != null && this.getEsposo() != p_hombre) {
            System.out.println("No se puede realizar el matrimonio: Alguna de las dos personas ya está casada.");
        }
    }

    /**
     * Divorcia a la mujer.
     * Elimina la referencia al esposo y cambia su estado civil a Divorciada.
     */
    public void divorcio() {
        if (this.getEsposo() != null) {
            Hombre esposoAnterior = this.getEsposo();
            this.setEsposo(null);
            this.setEstadoCivil("Divorciada");
            if (esposoAnterior.getEsposa() == this) {
                esposoAnterior.divorcio();
            }
        } else {
            System.out.println("No se puede divorciar porque no está casada.");
        }
    }

    /**
     * Devuelve el nombre, apellido y edad de la mujer.
     *
     * @return datos personales de la mujer
     */
    public String datos() {
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
    }

    /**
     * Muestra los datos personales y el estado civil.
     */
    public void mostrarEstadoCivil() {
        System.out.println(this.datos() + " - " + this.getEstadoCivil());
    }

    /**
     * Muestra los datos de la mujer y de su esposo si lo tiene.
     */
    public void casadaCon() {
        if (this.getEsposo() != null) {
            System.out.println(this.datos() + " está casada con " + this.getEsposo().datos());
        } else {
            System.out.println(this.datos() + " No tiene esposo actualmente");
        }
    }
}