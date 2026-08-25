import java.util.Scanner;

/**
 * Ejecutable para probar la clase CuentaBancaria.
 * Crea una persona y su cuenta bancaria, realiza un depósito
 * y una extracción y muestra los resultados.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class GestionCuentaBancaria
{
    /**
     * Solicita los datos mediante Scanner y prueba los métodos
     * de la clase CuentaBancaria.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        // Ingreso de los datos del titular.
        System.out.print("Ingrese el DNI del titular: ");
        int dni = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Ingrese el nombre del titular: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese el apellido del titular: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese el año de nacimiento: ");
        int anioNacimiento = teclado.nextInt();

        // Creación del objeto Persona reutilizando la clase del TP 2.
        Persona cliente = new Persona(
            dni,
            nombre,
            apellido,
            anioNacimiento
        );

        System.out.println("\nDatos del titular:");
        cliente.mostrar();

        // Ingreso de los datos de la cuenta bancaria.
        System.out.print("\nIngrese el número de cuenta: ");
        int nroCuenta = teclado.nextInt();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = teclado.nextDouble();

        /*
         * Se crea la cuenta bancaria y se le pasa como colaborador
         * el objeto Persona almacenado en la variable cliente.
         */
        CuentaBancaria cuenta = new CuentaBancaria(
            nroCuenta,
            cliente,
            saldoInicial
        );

        System.out.println("\nEstado inicial:");
        cuenta.mostrar();

        // Prueba del método depositar().
        System.out.print("\nIngrese el importe a depositar: ");
        double importeDeposito = teclado.nextDouble();

        double saldoDepositado = cuenta.depositar(importeDeposito);

        System.out.println(
            "Saldo después del depósito: " + saldoDepositado
        );

        // Prueba del método extraer().
        System.out.print("\nIngrese el importe a extraer: ");
        double importeExtraccion = teclado.nextDouble();

        double saldoExtraido = cuenta.extraer(importeExtraccion);

        System.out.println(
            "Saldo después de la extracción: " + saldoExtraido
        );

        // Se muestra el estado final mediante mostrar().
        System.out.println("\nEstado final:");
        cuenta.mostrar();

        // Se prueba el método toString().
        System.out.println("\nDatos tabulados:");
        System.out.println(cuenta.toString());

        teclado.close();
    }
}