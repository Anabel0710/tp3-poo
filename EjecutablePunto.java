/**
 * Clase ejecutable para probar la clase Punto.
 * Crea un objeto Punto, lo desplaza y muestra sus coordenadas.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella)
 * @version 1.0
 */
public class EjecutablePunto {
    public static void main(String[] args) {
    /**Convertir los argumentos*/
    double x1 = Double.parseDouble(args[0]);
    double y1 = Double.parseDouble(args[1]);
    double x2 = Double.parseDouble(args[2]);
    double y2 = Double.parseDouble(args[3]);
    
    /**
    double x1= 10;
    double y1= 5;
    
    double x2= 10;
    double y2= 5;
    */
   
    Punto p1= new Punto(x1, y1);
    Punto p2= new Punto(x2, y2);
    
    p1.mostrar();
    p2.mostrar();
    
    System.out.println("Distancia entre puntos: " + p1.distanciaA(p2));

    }
}
