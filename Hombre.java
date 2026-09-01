/**
 * Representa a un hombre y permite administrar su estado civil
 * y su relación con una esposa.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Hombre {
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
    public Hombre(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
        this.setEsposa(null);
    }

    /**
     * Construye un hombre casado con la mujer recibida.
     *
     * @param p_nombre nombre del hombre
     * @param p_apellido apellido del hombre
     * @param p_edad edad del hombre
     * @param p_esposa mujer que será su esposa
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad, Mujer p_esposa) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
        this.setEsposa(null);
        this.casarseCon(p_esposa);
    }

    /** Setters */
    private void setNombre(String p_nombre) { this.nombre = p_nombre; }
    private void setApellido(String p_apellido) { this.apellido = p_apellido; }
    private void setEdad(int p_edad) { this.edad = p_edad; }
    private void setEstadoCivil(String p_estadoCivil) { this.estadoCivil = p_estadoCivil; }
    private void setEsposa(Mujer p_esposa) { this.esposa = p_esposa; }

    /** Getters */
    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellido; }
    public int getEdad() { return this.edad; }
    public String getEstadoCivil() { return this.estadoCivil; }
    public Mujer getEsposa() { return this.esposa; }

    /**
     * Casa al hombre con la mujer recibida si ninguno de los dos está casado.
     * Establece el doble conocimiento entre ambos objetos y cambia su estado civil a Casado.
     *
     * @param p_mujer mujer con la que se casará
     */
    public void casarseCon(Mujer p_mujer) {
        if (p_mujer != null && this.getEsposa() == null) {
            this.setEsposa(p_mujer);
            this.setEstadoCivil("Casado");
            if (p_mujer.getEsposo() == null) {
                p_mujer.casarseCon(this);
            }
        } else if (this.getEsposa() != null && this.getEsposa() != p_mujer) {
            System.out.println("No se puede realizar el matrimonio: Alguna de las dos personas ya está casada.");
        }
    }

    /**
     * Divorcia al hombre.
     * Elimina la referencia a la esposa y cambia su estado civil a Divorciado.
     */
    public void divorcio() {
        if (this.getEsposa() != null) {
            Mujer esposaAnterior = this.getEsposa();
            this.setEsposa(null);
            this.setEstadoCivil("Divorciado");
            if (esposaAnterior.getEsposo() == this) {
                esposaAnterior.divorcio();
            }
        } else {
            System.out.println("No se puede divorciar porque no está casado.");
        }
    }

    /**
     * Devuelve el nombre, apellido y edad del hombre.
     *
     * @return datos personales del hombre
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
     * Muestra los datos del hombre y de su esposa si la tiene.
     */
    public void casadoCon() {
        if (this.getEsposa() != null) {
            System.out.println(this.datos() + " está casado con " + this.getEsposa().datos());
        } else {
            System.out.println(this.datos() + " No tiene esposa actualmente");
        }
    }
}