import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable que crea una estructura jerárquica
 * formada por un Gerente General y un empleado con jefe.
 * Emite un permiso de salida firmado por el jefe cuando
 * el empleado cumple un aniversario en la empresa.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 23/08/2026
 */
public class EmpresaConJefe
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        /**DATOS DEL GERENTE GENERAL */

        System.out.println("DATOS DEL GERENTE GENERAL");

        System.out.print("Ingrese el CUIL: ");
        long cuilGerente = teclado.nextLong();
        teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoGerente = teclado.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombreGerente = teclado.nextLine();

        System.out.print("Ingrese el sueldo básico: ");
        double sueldoGerente = teclado.nextDouble();

        System.out.print("Ingrese el día de ingreso: ");
        int diaGerente = teclado.nextInt();

        System.out.print("Ingrese el mes de ingreso: ");
        int mesGerente = teclado.nextInt();

        System.out.print("Ingrese el año de ingreso: ");
        int anioGerente = teclado.nextInt();

        Calendar fechaGerente = new GregorianCalendar( anioGerente, mesGerente - 1, diaGerente);

        /** Se crea al Gerente General sin jefe.
         * Para ello se utiliza el constructor que no recibe el parámetro p_jefe.
         */
        EmpleadoConJefe gerenteGeneral = new EmpleadoConJefe( cuilGerente, apellidoGerente, nombreGerente, sueldoGerente, fechaGerente);

        /** DATOS DEL EMPLEADO*/

        System.out.println("\nDATOS DEL EMPLEADO");

        System.out.print("Ingrese el CUIL: ");
        long cuilEmpleado = teclado.nextLong();
        teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoEmpleado = teclado.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombreEmpleado = teclado.nextLine();

        System.out.print("Ingrese el sueldo básico: ");
        double sueldoEmpleado = teclado.nextDouble();

        System.out.print("Ingrese el día de ingreso: ");
        int diaEmpleado = teclado.nextInt();

        System.out.print("Ingrese el mes de ingreso: ");
        int mesEmpleado = teclado.nextInt();

        System.out.print("Ingrese el año de ingreso: ");
        int anioEmpleado = teclado.nextInt();

        Calendar fechaEmpleado = new GregorianCalendar( anioEmpleado, mesEmpleado - 1, diaEmpleado);

        /** Se crea el empleado y se le asigna como jefe el objeto gerenteGeneral.*/
        EmpleadoConJefe empleado = new EmpleadoConJefe(cuilEmpleado, apellidoEmpleado, nombreEmpleado, sueldoEmpleado, 
                                       fechaEmpleado, gerenteGeneral);

        System.out.println("\nESTRUCTURA JERÁRQUICA\n");

        gerenteGeneral.mostrarPantalla();

        System.out.println();

        empleado.mostrarPantalla();

        /** Se emite el permiso si el empleado cumple un nuevo aniversario dentro de la empresa.*/
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

            System.out.println();
            System.out.println(
                "Firma del jefe: "
                + empleado.getJefe().apeYNom()
            );

            System.out.println(
                "--------------------------------------------------"
            );
        }

        teclado.close();
    }
}