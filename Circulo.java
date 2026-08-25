import java.util.Random;
/**
 * Write a description of class Circulo here.
 * 
 * @author Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella 
 * @version (a version number or a date)
 */
   public class Circulo
{
   
    private double radio;
    private Punto centro;

    public Circulo(double p_radio, Punto p_centro){
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    } 
    
    /**Constructor con parametros en 0 0*/
    public Circulo(){
        this.setRadio (0);
        this.setCentro (new Punto ());
    }
    
    /**Setters */
    private void setRadio(double p_radio) { this.radio = p_radio;}
    private void setCentro(Punto p_centro) {this.centro = p_centro;}
    
    /**Getters*/
    
    public double getRadio() {return this.radio;}
    public Punto getCentro() {return this.centro;}
    
    /** Desplazar el centro del circulo*/
    
    public void desplazar(double p_dx, double p_dy){
        this.getCentro().desplazar(p_dx, p_dy);
    }
    
    public double perimetro(){
        return 2 * Math.PI * this.radio;
    }
    
    public double superficie(){
        return Math.pow(this.radio, 2);
    }
    
    public double distanciaA(Circulo otroCirculo){
        return this.centro.distanciaA(otroCirculo.getCentro());
    }
    
    public Circulo elMayor(Circulo otroCirculo){
        
        return (this.superficie() >= otroCirculo.superficie()) ? this : otroCirculo;
    }
    
    /**Mostrar caracteristicas*/
    
    public void caracteristicas(){
        System.out.println("***** Circulo *****");
        System.out.print("Centro: " );
        this.getCentro().mostrar();
        System.out.print("- Radio: " + this.radio);
        System.out.println("\n Superficie:" + this.superficie() + "\t-Perimetro: " + this.perimetro());
    }
}