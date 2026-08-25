import java.util.Random;
/**
 * Write a description of class CreaFigura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreaFigura
{
   public static void main(){
    Random unNumero = new Random();
     // CIRCULO
    /**Primer circulo con centro en 0 0 y radio aleatorio */
    double radio1 = unNumero.nextDouble() * 100;
    Circulo c1 = new Circulo(radio1, new Punto());
    c1.desplazar(-240, -230);
    c1.caracteristicas();
    
    /**Segundo circulo en (5.2, 0.5) con radio aleatorio*/
    double radio2 = unNumero.nextDouble() * 100;
    Circulo c2 = new Circulo(radio2, new Punto(5.2, 0.5));
    c2.caracteristicas();
    
    /**Mostrar el mayor */
    Circulo mayor= c1.elMayor(c2);
    System.out.println("El circulo mayor es " );
    mayor.caracteristicas();
    
    /**Mostrar distancia entre ambos*/
    System.out.println("Distancia entre los circulos: " + c1.distanciaA(c2));
    
    // RECTANGULO
    double ancho1 = unNumero.nextDouble() * 100;
    double alto1 = unNumero.nextDouble() * 200;
    Rectangulo r1 = new Rectangulo(ancho1, alto1);
    r1.desplazar(40, -20);
    r1.caracteristicas();
    
    double ancho2 = unNumero.nextDouble() * 100;
    double alto2 = unNumero.nextDouble() * 200;
    Rectangulo r2 = new Rectangulo(new Punto(7.4, 4.5), ancho2, alto2);
    r2.caracteristicas();
    
    Rectangulo mayorRect = r1.elMayor(r2);
    System.out.println ("\n El rectangulo mayor es: ");
    mayorRect.caracteristicas();
    
    System.out.println ("\n Distancia ente rectangulos: " + r1.distancia(r2));
    }
}