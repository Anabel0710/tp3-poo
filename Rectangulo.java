
/**
 * Clase rectangulo que representa un rectangulo en el plano cartesiano.
 * Contiene como colaborador un objeto Punto(su origen)
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangulo
{
     //ATRIBUTOS PRIVADOS
    private Punto origen; //Esquina inferior izquierda
    private double ancho; //base
    private double alto; // altura del rectangulo 
    
    /**
     * Constructor que recibe el origen y dimensiones
     *@param p_origen Punto que representa la esquina inferior izquierda.
     *@param p_ancho ancho del rectangulo.
     *@param p_alto alto del rectangulo.
     */
    
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto){
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    } 
    
     /**
     * Constructor que recibe solo dimensiones
     * El origen se fija en (0,0)
     */
    public Rectangulo(double p_ancho, double p_alto){
        this.setOrigen(new Punto (0,0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    
    /**Setters */
    private void setOrigen (Punto p_origen) { this.origen = p_origen;}
    private void setAncho (double p_ancho) {this.ancho = p_ancho;}
    private void setAlto (double p_alto) {this.alto = p_alto;}
    
    /**Getters*/
    
    private Punto getOrigen () {return this.origen;}
    private double getAncho () {return this.ancho;}
    private double getAlto ()  {return this.alto;}
    
    /** 
     * Desplazar el rectangulo moviendo su origen
     * @param dx desplazamiento en eje X.
     * @param dy desplazamiento en eje Y.
     */
    
    public void desplazar(double p_dx, double p_dy){
        this.getOrigen().desplazar(p_dx, p_dy);//usa el metodo desplazar de Punto
    }
    
    /**
     * Calcular el perimetro del rectangulo
     * Formula: 2*(ancho + alto)
       */
      
    public double perimetro(){
    return 2*(this.getAncho() + this.getAlto());
    }
    
        /**
     * Calcular la superficie del rectangulo
     * Formula: ancho * alto
       */
      
    public double superficie(){
    return (this.getAncho() * this.getAlto());
    }
    
        /**Mostrar caracteristicas del rectangulo*/
    
    public void caracteristicas(){
        System.out.println("***** Rectangulo *****");
        System.out.print("\n - Origen: " + this.getOrigen().coordenadas() +
                         "\n - Alto: " + this.getAlto() +
                         "\n - Ancho: " + this.getAncho());
        System.out.println ("\n - Superficie: " + this.superficie() + 
                            "\n - Perimetro:  " + this.perimetro());
    }
    
    /**Calcular distancia entre dos rectangulos(Diferencia entre origenes)*/
    public double distancia(Rectangulo otroRectangulo){
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }
    
    /**Devuelve el rectangulo de mayor superficie*/
    public Rectangulo elMayor(Rectangulo otroRectangulo){
        return (this.superficie() >= otroRectangulo.superficie()) ? this : otroRectangulo; //Aplicando operador ternario
    }
}