import java.util.Scanner;

/**
 * Clase ejecutable que administra el matrimonio y el divorcio
 * entre un hombre y una mujer
 * 
 * Permite consultar el estado civil, celebrar el matrimonio,
 * emitir el certificado y realizar el divorcio
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 2.0 - 26/08/2026
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
      
       
       int opcion = 0;
       /**El menu se repite hasta que el usuario elige la opcion 5(SALIR)*/
       do {
        System.out.println("\n REGISTRO CIVIL");
        System.out.println("1- Mostrar el estado civil");
        System.out.println("2- Celebrar matrimonio");
        System.out.println("3- Emitir certificado de matrimonio");
        System.out.println("4- Realizar divorcio");
        System.out.println("5- Salir");
        
        System.out.println("Seleccione una opcion: ");
        opcion= teclado.nextInt();
        switch(opcion){
            case 1:
                /**Se consulta el estado civil actual de las dos personas*/
                System.out.println("ESTADO CIVIL");
                mujer.mostrarEstadoCivil();
                hombre.mostrarEstadoCivil();
                break;
                
            case 2: 
                /**El matrimonio solo puede ocurrir si ninguno de los dos esta casado*/
                  if (mujer.getEsposo() == null
                        && hombre.getEsposa() == null)
                    {
                        /**
                         * Este mensaje establece automáticamente
                         * el doble conocimiento:
                         *
                         * mujer.esposo apunta a hombre
                         * hombre.esposa apunta a mujer
                         */
                        mujer.casarseCon(hombre);

                        System.out.println( "\nMatrimonio celebrado correctamente.");

                        mujer.casadaCon();
                    }
                    else
                    {
                        System.out.println("\nNo puede realizarse el matrimonio: " + "alguna de las personas ya está casada.");
                    }

                    break;

                case 3:
                    /**
                     * El certificado solamente se emite cuando
                     * ambos están casados entre sí.
                     */
                    if (mujer.getEsposo() == hombre
                        && hombre.getEsposa() == mujer)
                    {
                        System.out.println( "===============================================================");

                        System.out.println("\n\t\tREGISTRO NACIONAL DE LAS PERSONAS");
                        System.out.println("\n\t\t      CERTIFICADO DE MATRIMONIO");

                        System.out.println( "===============================================================");

                        System.out.println( "\n\nEl Registro Civil deja constancia del matrimonio celebrado entre: ");

                        System.out.println( "\n\t\t\t" + mujer.datos());

                        System.out.println("\t\t\t          y");

                        System.out.println("\t\t\t" + hombre.datos());

                        System.out.println("\t\tAmbos quedan unidos en matrimonio");
                        
                        System.out.println( "\n\t\t_______________________________________");
                        
                        System.out.println( "\t\t             Firma y sello");


                        System.out.println( "===============================================================");                     
                    }
                    else
                    {
                        System.out.println("\nNo se puede emitir el certificado: " + "las personas no están casadas.");
                    }

                    break;

                case 4:
                    /**
                     * El divorcio solamente se realiza si ambos
                     * están casados entre sí.
                     */
                    if (mujer.getEsposo() == hombre
                        && hombre.getEsposa() == mujer)
                    {
                        /**
                         * Este mensaje actualiza automáticamente
                         * a los dos objetos.
                         */
                        mujer.divorcio();

                        System.out.println("\nDivorcio realizado correctamente.");

                        System.out.println("\nESTADO CIVIL DESPUÉS DEL DIVORCIO" );

                        mujer.mostrarEstadoCivil();
                        hombre.mostrarEstadoCivil();
                    }
                    else
                    {
                        System.out.println("\nNo puede realizarse el divorcio: "+ "las personas no están casadas." );
                    }

                    break;

                case 5:
                    System.out.println( "\nPrograma finalizado.");

                    break;

                default:
                    System.out.println(  "\nOpción incorrecta. Ingrese una opción de 1 a 5.");
            }
        }
        while (opcion != 5);

        teclado.close();
    }
}