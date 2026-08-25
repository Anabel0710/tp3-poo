import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable que instancia un empleado y emite un permiso
 * para retirarse una hora antes cuando se cumple un nuevo
 * aniversario de su ingreso a la empresa.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Empresa
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos del empleado.
        System.out.print("Ingrese el CUIL del empleado: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese el sueldo básico: ");
        double sueldoBasico = teclado.nextDouble();

        System.out.print("Ingrese el día de ingreso: ");
        int diaIngreso = teclado.nextInt();

        System.out.print("Ingrese el mes de ingreso: ");
        int mesIngreso = teclado.nextInt();

        System.out.print("Ingrese el año de ingreso: ");
        int anioIngreso = teclado.nextInt();

        /**
         * Se crea la fecha completa de ingreso.
         * Calendar numera los meses desde 0 hasta 11,
         * por eso se resta uno al mes ingresado.
         */
        Calendar fechaIngreso = new GregorianCalendar( anioIngreso, mesIngreso - 1, diaIngreso);

        // Se crea el objeto Empleado.
        Empleado empleado = new Empleado(cuil, apellido, nombre, sueldoBasico,fechaIngreso );

        System.out.println("\nDATOS DEL EMPLEADO\n");
        empleado.mostrar();

        /**
         * Se emite el permiso solamente si la fecha actual
         * coincide con el aniversario de ingreso.
         */
        if (empleado.esAniversario())
        {
            System.out.println("\nPERMISO DE SALIDA");
            System.out.println(
                "--------------------------------------------------"
            );
            System.out.println(
                "Se autoriza al empleado "
                + empleado.nomYApe()
                + " a retirarse una hora antes por cumplir "
                + empleado.antiguedad()
                + " años de servicio en la empresa."
            );
            System.out.println(
                "--------------------------------------------------"
            );
        }

        teclado.close();
    }
}