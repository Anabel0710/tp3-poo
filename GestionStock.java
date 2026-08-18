/**
 * Clase ejecutable para gestionar stock de productos.
 * Instancia un producto, ajusta stock y muestra resultados.
 * 
 * @author (Rocio Anabel Gonzalez y Rodriguez Mercedes Antonella) 
 * @version 1.0
 */
public class GestionStock {
    public static void main() {
        // Crear laboratorio
        Laboratorio lab1 = new Laboratorio("Colgate S.A.", "Scalabrini Ortiz 5524", "54-11-4239-8447");
        
        // Crear producto asociado al laboratorio
        Producto prod1 = new Producto(101, "Perfumería", "Jabón Deluxe", 5.25, 10.0, 50, lab1);
        prod1.mostrar();

        // Ajustar stock inicial (500 unidades por promoción)
        prod1.ajuste(500);
        prod1.mostrar();

        // Simular baja de 200 productos
        prod1.ajuste(-200);
        System.out.println("\nDespués de baja de stock:");
        prod1.mostrar();

        // Mostrar precios de lista y contado
        System.out.println("\nConsulta de cliente:");
        System.out.println("Precio Lista: " + prod1.precioLista());
        System.out.println("Precio Contado: " + prod1.precioContado());
    }
}

