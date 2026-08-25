import java.util.Scanner;

/**
 * Clase ejecutable que instancia un hombre y una mujer,
 * establece el matrimonio entre ellos y emite el
 * correspondiente certificado.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class RegistroCivil
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos de la mujer.
        System.out.println("DATOS DE LA MUJER");

        System.out.print("Ingrese el nombre: ");
        String nombreMujer = teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoMujer = teclado.nextLine();

        System.out.print("Ingrese la edad: ");
        int edadMujer = teclado.nextInt();
        teclado.nextLine();

        // Se crea la mujer sin esposo.
        Mujer mujer = new Mujer(nombreMujer, apellidoMujer,edadMujer);

        // Ingreso de los datos del hombre.
        System.out.println("\nDATOS DEL HOMBRE");

        System.out.print("Ingrese el nombre: ");
        String nombreHombre = teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoHombre = teclado.nextLine();

        System.out.print("Ingrese la edad: ");
        int edadHombre = teclado.nextInt();

        // Se crea el hombre sin esposa.
        Hombre hombre = new Hombre(nombreHombre, apellidoHombre,edadHombre);

        System.out.println("\nESTADO CIVIL ANTES DEL MATRIMONIO");

        mujer.mostrarEstadoCivil();
        hombre.mostrarEstadoCivil();

        /**
         * Se establece el doble conocimiento.
         * La mujer conoce al hombre como esposo y el hombre
         * conoce a la mujer como esposa.
         */
        mujer.casarseCon(hombre);
        hombre.casarseCon(mujer);

        System.out.println("\nCERTIFICADO DE MATRIMONIO");
        System.out.println(
            "------------------------------------------------------------"
        );

        hombre.casadoCon();

        System.out.println(
            "------------------------------------------------------------"
        );

        System.out.println("\nESTADO CIVIL DESPUÉS DEL MATRIMONIO");

        mujer.mostrarEstadoCivil();
        hombre.mostrarEstadoCivil();

        teclado.close();
    }
}