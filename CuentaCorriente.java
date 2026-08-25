/**
 * Representa una cuenta corriente perteneciente a una persona.
 * Permite realizar depósitos y extracciones utilizando un límite
 * de descubierto.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class CuentaCorriente
{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;

    // Objeto colaborador.
    private Persona titular;

    /**
     * Construye una cuenta corriente sin saldo inicial.
     * El saldo comienza en cero y el descubierto en $500.
     *
     * @param p_nroCuenta número de la cuenta
     * @param p_titular titular de la cuenta
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
        this.setLimiteDescubierto(500.0);
    }

    /**
     * Construye una cuenta corriente con saldo inicial.
     * El límite de descubierto comienza en $500.
     *
     * @param p_nroCuenta número de la cuenta
     * @param p_titular titular de la cuenta
     * @param p_saldo saldo inicial
     */
    public CuentaCorriente( int p_nroCuenta, Persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setLimiteDescubierto(500.0);
    }

    /** Getters */
    public int getNroCuenta() { return this.nroCuenta;} //Devuelve el número de cuenta.
    public double getSaldo() {return this.saldo;} //Devuelve el saldo actual.
    public Persona getTitular() {return this.titular;}// Devuelve el titular de la cuenta.
    public double getLimiteDescubierto() {return this.limiteDescubierto;} //Devuelve el límite de descubierto.


    /** Setters */
    private void setSaldo(double p_saldo) { this.saldo = p_saldo;} //Asigna el saldo de la cuenta.
    private void setTitular(Persona p_titular) {  this.titular = p_titular;}//Asigna el titular de la cuenta.
    private void setNroCuenta(int p_nroCuenta) {this.nroCuenta = p_nroCuenta;} //Asigna el número de cuenta.
    private void setLimiteDescubierto(double p_limite) {this.limiteDescubierto = p_limite;} //Asigna el límite de descubierto.

    /**
     * Determina si se puede realizar una extracción.
     *
     * El importe no debe superar la suma del saldo actual
     * y el límite de descubierto.
     *
     * @param p_importe importe que se desea extraer
     * @return true si puede extraerse; false en caso contrario
     */
    private boolean puedeExtraer(double p_importe)
    {
        return p_importe
            <= this.getSaldo() + this.getLimiteDescubierto();
    }

    /**
     * Realiza efectivamente la extracción.
     *
     * @param p_importe importe que se descontará
     */
    private void extraccion(double p_importe)
    {
        this.setSaldo(this.getSaldo() - p_importe);
    }

    /**
     * Coordina la operación de extracción.
     * Si se cumplen las condiciones, realiza la extracción.
     * En caso contrario, informa el motivo.
     *
     * @param p_importe importe que se desea extraer
     */
    public void extraer(double p_importe)
    {
        if (this.puedeExtraer(p_importe))
        {
            this.extraccion(p_importe);
        }
        else
        {
            System.out.println(
                "El importe de extraccion sobrepasa "
                + "el límite de descubierto!"
            );
        }
    }

    /**
     * Deposita un importe en la cuenta.
     *
     * @param p_importe importe que se depositará
     */
    public void depositar(double p_importe)
    {
        this.setSaldo(this.getSaldo() + p_importe);
    }

    /**
     * Muestra los datos de la cuenta corriente.
     */
    public void mostrar()
    {
        System.out.println("- Cuenta Corriente -");
        System.out.println(
            "Nro. Cuenta: " + this.getNroCuenta()
            + " - Saldo: " + this.getSaldo()
        );
        System.out.println(
            "Titular: " + this.getTitular().nomYApe()
        );
        System.out.println(
            "Descubierto: " + this.getLimiteDescubierto()
        );
    }
}