package ProyectoFinal;
import ProyectoFinal.Recursos.Producto;
import ProyectoFinal.Recursos.Ventas;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    // SE CREA UNA LISTA PARA GUARDAR LOS PRODUCTOS
    static Producto[] Lista_productos=new Producto[5];
    static int numero_productos=0;

    // ------------------------------------------------------------------------------------------------------------
    // Metodo Main
    public static void main(String[] args) {

        int opcion;
// Ejecuta el do while para escoger una opcion
        do {
            opcion = Menu();// Ejecuta un menu
            switch (opcion){
                case 1:
                    registrar_productos(); 
                    break;

                case 2:
                    realizar_venta();      
                    break;

                case 3:
                    System.out.println("Proceso de venta Finalizado");
            }
        }while (opcion!=3);
        
    }
// ------------------------------------------------------------------------------------------------------------
// Se registra los productos usando la clase producto
    public static void registrar_productos(){
        Producto obj=new Producto();
        obj.Leer_datos();

        Lista_productos[numero_productos]=obj;
        numero_productos++;

    }
// ------------------------------------------------------------------------------------------------------------

// Se registran la venta usando la clase venta
    public static void realizar_venta(){
        Ventas obj=new Ventas();
        obj.mostrar_menu();

    }
// ------------------------------------------------------------------------------------------------------------


// SE REGISTRA LAS VENTAS 
    public static void registrar_venta(){

        Scanner teclado=new Scanner(System.in);

        Ventas obj=new Ventas();
// REGISTRAR EL NOMBRE
        if (numero_productos > 0) {
            System.out.println("Ingrese nombre del producto: ");
            String nombre= teclado.nextLine();

            int cantidad;

            // Capturar los errores si se digita algo mal
            try {
                do {
                    System.out.println("Ingrese cantidad a comprar :");
                    cantidad=teclado.nextInt();
                } while (cantidad<=0);
// SE VALIDAN LOS DATOS
                int pos=buscar_producto(nombre);
                int poss=comparar_cantidad(cantidad);

                if (pos != -1 && poss!= -1) {

                    double monto=Lista_productos[pos].getPrecio_venta()*cantidad;
                    System.out.println("El monto a pagar es: S/"+monto);

                    
                    obj.leer_datos();

                    do {
                        obj.cantidad_pagar();
                    } while (obj.getPago()<monto);

                    double vuelto=calculo_vuelto(monto, obj.getPago());
                    System.out.println("Vuelto a entregar: S/"+vuelto );

                    double ganancia= (Lista_productos[pos].getPrecio_venta()*cantidad) - (Lista_productos[pos].getPrecio_compra()*cantidad);
                    System.out.println("Ganancia obtenida: S/"+ganancia);
                    
                    

                }else if (pos == -1) {
                    System.out.println("Producto no registrado");
                }else if (poss == -1){
                    System.out.println("La cantidad excedió al stock");
                }
// SE CAPTURA EL ERROR
            }catch (InputMismatchException e){
                System.out.println("Error: "+e);
            }
// SI NO HAY PRODUCTOS
        }else{
            System.out.println("No se han registrado productos");
        }
    }

    // FUNCION PARA BUSCAR LOS PRODUCTOS DE LA LISTA
    public static int buscar_producto(String nombre){
        for (int i = 0; i < numero_productos; i++) {
            if (Lista_productos[i].getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }
// FUNCION PARA VERIFICAR QUE HAYA LA CANTIDAD NECESARIA EN EL STOCK
    public static int comparar_cantidad (int cantidad){
        for (int i = 0; i < numero_productos; i++) {
            if (Lista_productos[i].getStock()>= cantidad){
                return i;
            }
        }
        return -1;
    }
// ------------------------------------------------------------------------------------------------------------
   

    // FUNCION PARA CALCULAR EL VUELTO DE LA VENTA
    public static double calculo_vuelto(double monto, double pago){
        double vuelto;

        vuelto = pago - monto;

        return vuelto;
    }

    

   // METODO PARA MOSTRAR EL MENU PRINCIPAL
    public static int Menu(){
        int aux = 0;
// CAPTURAR EL ERROR PARA EL INGRESO DE VALORES NO VALIDOS
        try {
            System.out.println("------MiniMarket-------");
            System.out.println("[1] Registrar Productos");
            System.out.println("[2] Realizar Venta");
            System.out.println("[3] Salir");
            System.out.println("***********************");

            aux=validar_numero("Ingrese opcion: ", 1, 3);

        }catch (InputMismatchException e){
            System.out.println("Error: "+e);
        }
        return aux;
    }

    // ------------------------------------------------------------------------------------------------------------

    // FUNCION PARA VERIFICAR QUE QUE UN NUMERO ESTE ENTRE LOS VALORES
    public static int validar_numero(String mensaje, int Vmin, int Vmax){

        Scanner teclado=new Scanner(System.in);
        int aux;
// LA VARIABLE AUX ES EL NUMERO USADO PARA VALIDAR QUE ESTE DENTRO DE LOS VALORES
        do {
            System.out.println(mensaje);
            aux= teclado.nextInt();

            if (aux<Vmin || aux>Vmax) {
                System.out.println("Numero invalido, ingresar nuevamente numeros entre :"+Vmin+" - "+Vmax);
            }

        }while (aux<Vmin || aux>Vmax);

        return aux;

    }

    // static void registrar_Ventas() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
}