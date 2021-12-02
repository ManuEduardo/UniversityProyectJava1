package ProyectoFinal.Recursos;

import ProyectoFinal.Principal;
import java.util.InputMismatchException;
import java.util.Scanner;
// SE CREA LA CLASE VENTAS
public class Ventas {

    private String nombre_cliente;
    private int cantidad;
    private double pago;
    private double vuelto;
    private double ganancia;
// EL SCANNER
    Scanner teclado=new Scanner(System.in);
// GETS AND SETS
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
// ------------------------------------------------------------------------------------------------------------
// METODO PARA MOSTRAR EL MENU
    public void mostrar_menu(){
        int opcion;

        do {
            opcion = Menu();
            switch (opcion){
                case 1:
                    Principal.registrar_venta(); // FUNCION EN LA CLASE PRINCIPAL
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Bienvenido al Menu nuevamente");
            }

        }while (opcion!=2);
    }
    
    public int Menu(){

        int aux;

        try {

            System.out.println("------------------------");
            System.out.println("[1] Realizar una venta :");
            System.out.println("[2] Regresar al menu :");
            System.out.println("------------------------");

            aux=validar_numero("Ingrese opcion: ", 1, 2);

        }catch (InputMismatchException e){
            System.out.println("Error: "+e);
            aux = 2;
        }
        return aux;
    }


    public int validar_numero(String mensaje, int Vmin, int Vmax){

        int aux;

        do {
            System.out.println(mensaje);
            aux= teclado.nextInt();

            if (aux<Vmin || aux>Vmax) {
                System.out.println("Numero invalido, ingresar nuevamente numeros entre :"+Vmin+"-"+Vmax);
            }

        }while (aux<Vmin || aux>Vmax);

        return aux;

    }

    


    public void leer_datos(){

        System.out.println("-----Ingrese datos del Cliente-----");
        System.out.println("Ingrese Nombre: ");
        nombre_cliente=teclado.nextLine();

    }

    public void cantidad_pagar(){
        System.out.println("Ingrese cantidad con la cual pagará S/: ");
        pago= teclado.nextDouble();
    }
}