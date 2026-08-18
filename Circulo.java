import java.util.Random;
/**
 * Write a description of class Circulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   public class Circulo
{
    private double radio;
    private Punto centro;
    
    /**Constructor con parametros en 0 0*/
    public Circulo(){
        this.setRadio (0);
        this.setCentro (new Punto (0,0));
    }

    public Circulo(double p_radio, Punto p_centro){
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    } 
    
    /**Setters */
    private void setRadio(double p_radio) { this.radio = p_radio;}
    private void setCentro(Punto p_centro) {this.centro = p_centro;}
    
    /**Getters*/
    
    public double getRadio() {return this.radio;}
    public Punto getCentro() {return this.centro;}
    
    /** Desplazar el centro del circulo*/
    
    
}