import java.util.*;

/**
 * Clase Empleado que representa un empleado con sueldo básico y antigüedad.
 * Permite calcular sueldo neto aplicando descuentos y adicionales.
 * 
 *@author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */
public class Empleado {
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;

    /** Constructor de Empleado */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
    }

    /** Getters */
    public long getCuil() { return this.cuil; }
    public String getApellido() { return this.apellido; }
    public String getNombre() { return this.nombre; }
    public double getSueldoBasico() { return this.sueldoBasico; }
    public int getAnioIngreso() { return this.anioIngreso; }

    /** Setters privados */
    private void setCuil(long p_cuil) { this.cuil = p_cuil; }
    private void setApellido(String p_apellido) { this.apellido = p_apellido; }
    private void setNombre(String p_nombre) { this.nombre = p_nombre; }
    private void setSueldoBasico(double p_importe) { this.sueldoBasico = p_importe; }
    private void setAnioIngreso(int p_anio) { this.anioIngreso = p_anio; }

    /** Calcula antigüedad en años */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnioIngreso();
    }

    /** Calcula descuento (2% + seguro de vida) */
    public double descuento() {
        return (this.getSueldoBasico() * 0.02) + 1500;
    }

    /** Calcula adicional según antigüedad */
    public double adicional() {
        int ant = this.antiguedad();
        if (ant < 2) return this.getSueldoBasico() * 0.02;
        else if (ant < 10) return this.getSueldoBasico() * 0.04;
        else return this.getSueldoBasico() * 0.06;
    }

    /** Calcula sueldo neto */
    public double sueldoNeto() {
        return this.getSueldoBasico() + this.adicional() - this.descuento();
    }

    /** Devuelve nombre y apellido */
    public String nomYApe() { return this.getNombre() + " " + this.getApellido(); }

    /** Devuelve apellido y nombre */
    public String apeYNom() { return this.getApellido() + ", " + this.getNombre(); }

    /** Muestra datos completos del empleado */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("CUIL: " + this.getCuil() + " Antigüedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + this.sueldoNeto());
    }

    /** Muestra datos en una sola línea */
    public String mostrarLinea() {
        return this.getCuil() + "\n" + this.apeYNom() + "\n$ " + this.sueldoNeto();
    }
}
