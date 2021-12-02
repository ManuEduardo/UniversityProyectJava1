package ProyectoFinal.Recursos;

import java.util.InputMismatchException;
import java.util.Scanner;
// SE CREA LA CLASE PRODUCTO
public class Producto {
    private String nombre;
    private double precio_venta;
    private double precio_compra;
    private int stock;
// GETS Y SETS---------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
// ------------------------------------------------------------------------------------------------------------

// METODO PARA LEER DATOS 
    public void Leer_datos(){
        Scanner teclado=new Scanner(System.in);

        System.out.println("-----Ingrese datos del Producto-----");

        System.out.println("Ingrese nombre :");
        nombre=teclado.nextLine();
// DETECCION DE ERRORES PARA EVITAR QUE SE INGRESEN DATOS ERRONEOS
        try {
            do {
                System.out.println("Ingrese precio de compra :");
                precio_compra=teclado.nextDouble();
            } while (precio_compra<=0);
// WL WHILE ES PARA QUE NO SE INGRESE DATOS NEGATIVOS
            do {
                System.out.println("Ingrese precio de venta :");
                precio_venta=teclado.nextDouble();
            } while (precio_venta<=precio_compra);

            do {
                System.out.println("Ingrese stock :");
                stock=teclado.nextInt();
            } while (stock<=0);
// SE CAPTURAN LOS ERRORES Y LUEGO SE COMUNICAN
        }catch (InputMismatchException e){
            System.out.println("Error: "+e);
        }
// ----------------------------------------------------------------------------
    }
}