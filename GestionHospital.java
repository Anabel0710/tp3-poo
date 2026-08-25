import java.util.Scanner;

/**
 * Clase ejecutable que instancia un hospital, un paciente
 * y sus correspondientes localidades.
 * Muestra por pantalla los datos filiatorios del paciente.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class GestionHospital
{
    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos del hospital.
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = teclado.nextLine();

        System.out.print("Ingrese el nombre del director: ");
        String nombreDirector = teclado.nextLine();

        // Se crea el objeto Hospital.
        Hospital hospital = new Hospital(
            nombreHospital,
            nombreDirector
        );

        // Ingreso de la localidad de nacimiento.
        System.out.println("\nLOCALIDAD DE NACIMIENTO");

        System.out.print("Ingrese el nombre de la localidad: ");
        String nombreLocalidadNacido = teclado.nextLine();

        System.out.print("Ingrese el nombre de la provincia: ");
        String provinciaNacido = teclado.nextLine();

        // Se crea la localidad donde nació el paciente.
        Localidad localidadNacido = new Localidad(
            nombreLocalidadNacido,
            provinciaNacido
        );

        // Ingreso de la localidad de residencia.
        System.out.println("\nLOCALIDAD DE RESIDENCIA");

        System.out.print("Ingrese el nombre de la localidad: ");
        String nombreLocalidadVive = teclado.nextLine();

        System.out.print("Ingrese el nombre de la provincia: ");
        String provinciaVive = teclado.nextLine();

        // Se crea la localidad donde vive el paciente.
        Localidad localidadVive = new Localidad(
            nombreLocalidadVive,
            provinciaVive
        );

        // Ingreso de los datos del paciente.
        System.out.println("\nDATOS DEL PACIENTE");

        System.out.print("Ingrese el número de historia clínica: ");
        int historiaClinica = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Ingrese el nombre completo: ");
        String nombrePaciente = teclado.nextLine();

        System.out.print("Ingrese el domicilio: ");
        String domicilio = teclado.nextLine();

        /*
         * Se crea el paciente y se le pasan los dos objetos
         * Localidad como colaboradores.
         */
        Paciente paciente = new Paciente(
            historiaClinica,
            nombrePaciente,
            domicilio,
            localidadNacido,
            localidadVive
        );

        /*
         * El hospital recibe al paciente como parámetro
         * y consulta sus datos filiatorios.
         */
        System.out.println("\nDATOS FILIATORIOS\n");
        hospital.consultaDatosFiliatorios(paciente);

        // Se prueba el método cadenaDeDatos().
        System.out.println("\nCADENA DE DATOS");
        System.out.println(paciente.cadenaDeDatos());

        teclado.close();
    }
}