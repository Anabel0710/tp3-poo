/**
 * Representa una caja de ahorro perteneciente a una persona.
 * Permite realizar depósitos y una cantidad limitada de extracciones.
 *
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella
 * @version 1.0 - 23/08/2026
 */
public class CajaDeAhorro
{
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;

    // Objeto colaborador.
    private Persona titular;

    /**
     * Construye una caja de ahorro sin saldo inicial.
     * El saldo comienza en cero y dispone de 10 extracciones.
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Construye una caja de ahorro con saldo inicial.
     * La cuenta dispone de 10 extracciones.
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo ) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setExtraccionesPosibles(10);
    }
    
    /**Setters*/
    
    private void setNroCuenta(int p_nroCuenta) {this.nroCuenta = p_nroCuenta;} //Asigna el número de cuenta.
    private void setSaldo(double p_saldo) {this.saldo = p_saldo; } //Asigna el saldo de la cuenta
    private void setTitular(Persona p_titular) {this.titular = p_titular;} //Asigna el titular de la cuenta
    private void setExtraccionesPosibles(int p_extracciones){ this.extraccionesPosibles = p_extracciones;} //Asigna la cantidad de extracciones posibles.


    /** Getters */
    public int getNroCuenta(){ return this.nroCuenta;}//Devuelve el número de cuenta.
    public double getSaldo() {return this.saldo;} //Devuelve el saldo actual.
    public Persona getTitular()  {return this.titular;} //Devuelve el titular de la cuenta.
    public int getExtraccionesPosibles() { return this.extraccionesPosibles;} //Devuelve la cantidad de extracciones posibles.


    /**
     * Determina si se puede realizar una extracción.
     * Para extraer debe existir saldo suficiente y quedar
     * al menos una extracción disponible.
     *
     * @param p_importe importe que se desea extraer
     * @return true si se puede extraer; false en caso contrario
     */
    private boolean puedeExtraer(double p_importe)
    {
        return p_importe <= this.getSaldo()
            && this.getExtraccionesPosibles() > 0;
    }

    /**
     * Realiza efectivamente la extracción y disminuye en uno
     * la cantidad de extracciones posibles.
     *
     * @param p_importe importe que se descontará
     */
    private void extraccion(double p_importe)
    {
        this.setSaldo(this.getSaldo() - p_importe);

        this.setExtraccionesPosibles(
            this.getExtraccionesPosibles() - 1
        );
    }

    /**
     * Coordina la operación de extracción.
     * Si no puede realizarse, informa el motivo.
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
            if (this.getExtraccionesPosibles() == 0)
            {
                System.out.println("No tiene habilitadas mas extracciones!");
            }
            else
            {
                System.out.println("No puede extraer mas que el saldo!");
            }
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
     * Muestra los datos de la caja de ahorro.
     */
    public void mostrar()
    {
        System.out.println("- Caja de Ahorro -");
        System.out.println(
            "Nro. Cuenta: " + this.getNroCuenta()
            + " - Saldo: " + this.getSaldo()
        );
        System.out.println(
            "Titular: " + this.getTitular().nomYApe()
        );
        System.out.println(
            "Extracciones posibles: "
            + this.getExtraccionesPosibles()
        );
    }
}