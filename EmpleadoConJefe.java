import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa a un empleado que puede tener asignado otro
 * empleado como jefe.
 * Permite calcular su sueldo, antigüedad, mostrar sus datos
 * y determinar si cumple un aniversario en la empresa.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class EmpleadoConJefe
{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;

    // Objeto colaborador de la misma clase.
    private EmpleadoConJefe jefe;

    /**
     * Construye un empleado con fecha completa de ingreso
     * y con un jefe asignado.
     *
     * @param p_cuil número de CUIL
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe sueldo básico
     * @param p_fecha fecha completa de ingreso
     * @param p_jefe empleado que será su jefe
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha, EmpleadoConJefe p_jefe)
    {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
    }

    /**
     * Construye un empleado con fecha completa de ingreso
     * y sin jefe.
     * Este constructor se utiliza para el Gerente General.
     *
     * @param p_cuil número de CUIL
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe sueldo básico
     * @param p_fecha fecha completa de ingreso
     */
    public EmpleadoConJefe( long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(null);
    }

    /**
     * Construye un empleado recibiendo solamente el año
     * de ingreso y sin jefe.
     *
     * @param p_cuil número de CUIL
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe sueldo básico
     * @param p_anio año de ingreso
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
        this.setJefe(null);
    }

    /** Getters */
    public long getCuil() {return this.cuil;} //Devuelve el CUIL del empleado.
    public String getApellido() {return this.apellido;} //Devuelve el apellido del empleado.
    public String getNombre() {return this.nombre;} //Devuelve el nombre del empleado.
    public double getSueldoBasico() {return this.sueldoBasico;} //Devuelve el sueldo básico.
    public int getAnioIngreso() {return this.fechaIngreso.get(Calendar.YEAR);} //Devuelve el año de ingreso.
    public Calendar getFechaIngreso() {return this.fechaIngreso;} //Devuelve la fecha completa de ingreso.
    public EmpleadoConJefe getJefe() {return this.jefe;} //Devuelve el jefe del empleado.

    /** Setters */
    private void setCuil(long p_cuil) {this.cuil = p_cuil;} //Asigna el CUIL.
    private void setApellido(String p_apellido) {this.apellido = p_apellido;} //Asigna el apellido.
    private void setNombre(String p_nombre) {this.nombre = p_nombre;} //Asigna el nombre.
    private void setSueldoBasico(double p_importe) {this.sueldoBasico = p_importe;} //Asigna el sueldo básico.
    private void setFechaIngreso(Calendar p_fecha) {this.fechaIngreso = p_fecha;} //Asigna la fecha de ingreso.
    private void setJefe(EmpleadoConJefe p_jefe) {this.jefe = p_jefe;} //Asigna el jefe del empleado.

    /**
     * Asigna el año de ingreso creando un objeto Calendar.
     *
     * @param p_anio año de ingreso
     */
    private void setAnioIngreso(int p_anio)
    {
        Calendar fecha = new GregorianCalendar(p_anio, 0, 1);
        this.setFechaIngreso(fecha);
    }

    /**
     * Calcula la antigüedad del empleado.
     *
     * @return antigüedad en años
     */
    public int antiguedad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);

        return anioHoy - this.getAnioIngreso();
    }

    /**
     * Calcula el descuento correspondiente al 2% del sueldo
     * básico más $1500 de seguro de vida.
     *
     * @return descuento aplicado
     */
    private double descuento()
    {
        return this.getSueldoBasico() * 0.02 + 1500.0;
    }

    /**
     * Calcula el adicional correspondiente según la antigüedad.
     *
     * @return adicional por antigüedad
     */
    private double adicional()
    {
        double adicional = 0.0;

        if (this.antiguedad() < 2)
        {
            adicional = this.getSueldoBasico() * 0.02;
        }
        else
        {
            if (this.antiguedad() < 10)
            {
                adicional = this.getSueldoBasico() * 0.04;
            }
            else
            {
                adicional = this.getSueldoBasico() * 0.06;
            }
        }

        return adicional;
    }

    /**
     * Calcula el sueldo neto del empleado.
     *
     * @return sueldo neto
     */
    public double sueldoNeto()
    {
        return this.getSueldoBasico() + this.adicional() - this.descuento();
    }

    /**
     * Devuelve el nombre y apellido del empleado.
     *
     * @return nombre y apellido
     */
    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * Devuelve el apellido y nombre del empleado.
     *
     * @return apellido y nombre
     */
    public String apeYNom()
    {
        return this.getApellido() + ", " + this.getNombre();
    }

    /**
     * Muestra los datos del empleado y el jefe al cual responde.
     * Si no tiene jefe, muestra la leyenda GERENTE GENERAL.
     */
    public void mostrarPantalla()
    {
        System.out.println(
            "Nombre y Apellido: " + this.nomYApe()
        );

        System.out.println(
            "CUIL: " + this.getCuil()
            + " Antigüedad: " + this.antiguedad()
            + " años de servicio"
        );

        System.out.println(
            "Sueldo Neto: $ " + this.sueldoNeto()
        );

        if (this.getJefe() == null)
        {
            System.out.println("Responde a: GERENTE GENERAL");
        }
        else
        {
            System.out.println(
                "Responde a: " + this.getJefe().apeYNom()
            );
        }
    }

    /**
     * Devuelve los datos del empleado en una sola línea.
     *
     * @return CUIL, apellido, nombre y sueldo neto
     */
    public String mostrarLinea()
    {
        return this.getCuil()
            + "\t" + this.apeYNom()
            + "\t$ " + this.sueldoNeto();
    }

    /**
     * Determina si el día y mes actuales coinciden con el
     * día y mes de ingreso del empleado.
     *
     * @return true si hoy es su aniversario; false en caso contrario
     */
    public boolean esAniversario()
    {
        Calendar fechaHoy = new GregorianCalendar();

        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mesHoy = fechaHoy.get(Calendar.MONTH);

        int diaIngreso =
            this.getFechaIngreso().get(Calendar.DAY_OF_MONTH);

        int mesIngreso =
            this.getFechaIngreso().get(Calendar.MONTH);

        return diaHoy == diaIngreso
            && mesHoy == mesIngreso;
    }
}