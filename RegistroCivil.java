import java.util.Scanner;

/**
 * Clase ejecutable que administra el matrimonio y el divorcio
 * entre una mujer y dos opciones de hombres.
 *
 * Permite consultar el estado civil, celebrar el matrimonio,
 * emitir el certificado y realizar el divorcio.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 28/08/2026
 */
public class RegistroCivil {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos de la mujer.
        System.out.println("DATOS DE LA MUJER");
        System.out.print("Ingrese el nombre: ");
        String nombreMujer = teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoMujer = teclado.nextLine();

        System.out.print("Ingrese la edad: ");
        int edadMujer = teclado.nextInt();
        teclado.nextLine(); // Limpieza del búfer

        // Se crea la mujer sin esposo.
        Mujer mujer = new Mujer(nombreMujer, apellidoMujer, edadMujer);

        // Ingreso de los datos del primer hombre.
        System.out.println("\nDATOS DEL PRIMER HOMBRE");
        System.out.print("Ingrese el nombre: ");
        String nombreHombre = teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoHombre = teclado.nextLine();

        System.out.print("Ingrese la edad: ");
        int edadHombre = teclado.nextInt();
        teclado.nextLine(); // Limpieza del búfer

        // Se crea el primer hombre sin esposa.
        Hombre hombre = new Hombre(nombreHombre, apellidoHombre, edadHombre);

        // Ingreso de los datos del segundo hombre.
        System.out.println("\nDATOS DEL SEGUNDO HOMBRE");
        System.out.print("Ingrese el nombre: ");
        String nombreHombre2 = teclado.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellidoHombre2 = teclado.nextLine();

        System.out.print("Ingrese la edad: ");
        int edadHombre2 = teclado.nextInt();
        teclado.nextLine(); // Limpieza del búfer

        // Se crea el segundo hombre sin esposa.
        Hombre hombre2 = new Hombre(nombreHombre2, apellidoHombre2, edadHombre2);

        int opcion = 0;

        /** El menú se repite hasta que el usuario elige la opción 5 (SALIR) */
        do {
            System.out.println("\n REGISTRO CIVIL");
            System.out.println("1- Celebrar matrimonio (Elegir pretendiente)");
            System.out.println("2- Mostrar estado civil");
            System.out.println("3- Emitir certificado de matrimonio");
            System.out.println("4- Realizar divorcio");
            System.out.println("5- Salir");

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpieza del búfer

            switch (opcion) {
                case 1:
                    if (mujer.getEsposo() != null) {
                        System.out.println("\nNo se puede celebrar el matrimonio: La mujer ya se encuentra casada con " + mujer.getEsposo().datos());
                    } else {
                        System.out.println("\n¿Con qué hombre desea casarse?");
                        System.out.println("1 - " + hombre.datos());
                        System.out.println("2 - " + hombre2.datos());
                        System.out.print("Seleccione una opción: ");
                        int elegido = teclado.nextInt();
                        teclado.nextLine();

                        if (elegido == 1) {
                            mujer.casarseCon(hombre);
                            if (mujer.getEsposo() == hombre) {
                                System.out.println("\nMatrimonio celebrado correctamente.");
                                mujer.casadaCon();
                            }
                        } else if (elegido == 2) {
                            mujer.casarseCon(hombre2);
                            if (mujer.getEsposo() == hombre2) {
                                System.out.println("\nMatrimonio celebrado correctamente.");
                                mujer.casadaCon();
                            }
                        } else {
                            System.out.println("Opción de hombre incorrecta.");
                        }
                    }
                    break;

                case 2:
                    /** Se consulta el estado civil actual de las tres personas */
                    System.out.println("\nESTADO CIVIL");
                    mujer.mostrarEstadoCivil();
                    hombre.mostrarEstadoCivil();
                    hombre2.mostrarEstadoCivil();
                    break;

                case 3:
                    /** El certificado se emite para la persona con la que está casada */
                    if (mujer.getEsposo() != null) {
                        Hombre esposoActual = mujer.getEsposo();
                        System.out.println("===============================================================");
                        System.out.println("\n\t\tREGISTRO NACIONAL DE LAS PERSONAS");
                        System.out.println("\n\t\t      CERTIFICADO DE MATRIMONIO");
                        System.out.println("===============================================================");
                        System.out.println("\nEl Registro Civil deja constancia del matrimonio celebrado entre: ");
                        System.out.println("\n\t\t\t" + mujer.datos());
                        System.out.println("\t\t\t          y");
                        System.out.println("\t\t\t" + esposoActual.datos());
                        System.out.println("\t\tAmbos quedan unidos en matrimonio");
                        System.out.println("\n\t\t_______________________________________");
                        System.out.println("\t\t             Firma y sello");
                        System.out.println("===============================================================");
                    } else {
                        System.out.println("\nNo se puede emitir el certificado: la persona no está casada.");
                    }
                    break;

                case 4:
                    /** Realiza el divorcio si la mujer se encuentra casada */
                    if (mujer.getEsposo() != null) {
                        mujer.divorcio();
                        System.out.println("\nDivorcio realizado correctamente.");
                        System.out.println("\nESTADO CIVIL DESPUÉS DEL DIVORCIO");
                        mujer.mostrarEstadoCivil();
                        hombre.mostrarEstadoCivil();
                        hombre2.mostrarEstadoCivil();
                    } else {
                        System.out.println("\nNo se puede realizar el divorcio: la persona no está casada.");
                    }
                    break;

                case 5:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpción incorrecta. Ingrese una opción de 1 a 5.");
            }
        } while (opcion != 5);

        teclado.close();
    }
}