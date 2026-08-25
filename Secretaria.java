import java.util.Scanner;

/**
 * Clase ejecutable que instancia una escuela y un docente
 * y solicita la emisión del recibo de sueldo.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class Secretaria
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos de la escuela.
        System.out.print("Ingrese el nombre de la escuela: ");
        String nombreEscuela = teclado.nextLine();

        System.out.print("Ingrese el domicilio de la escuela: ");
        String domicilio = teclado.nextLine();

        System.out.print("Ingrese el nombre del director: ");
        String director = teclado.nextLine();

        // Se crea el objeto Escuela.
        Escuela unaEscuela = new Escuela(nombreEscuela, domicilio, director );

        // Ingreso de los datos del docente.
        System.out.print("\nIngrese el nombre del docente: ");
        String nombreDocente = teclado.nextLine();

        System.out.print("Ingrese el grado del docente: ");
        String grado = teclado.nextLine();

        System.out.print("Ingrese el sueldo básico: ");
        double sueldoBasico = teclado.nextDouble();

        System.out.print("Ingrese la asignación familiar: ");
        double asignacionFamiliar = teclado.nextDouble();

        // Se crea el objeto Docente.
        Docente unDocente = new Docente(nombreDocente,grado, sueldoBasico, asignacionFamiliar );

        /**
         * La escuela recibe al docente como parámetro y emite su recibo de sueldo.
         */
        System.out.println("\nRECIBO DE SUELDO\n");
        unaEscuela.imprimirRecibo(unDocente);
        
        //Cerrar el scaner
        teclado.close();
    }
}