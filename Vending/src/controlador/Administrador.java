package controlador;

import java.util.Scanner;

import modelo.Productos;
import vista.VentanaPrincipal;

public class Administrador {

	
	public static void administrar(VentanaPrincipal v) {
		login(v);

	 
	
		
	}
	
	public static void mostrarProductos() {
		System.out.println("--------------------");
		System.out.println("PRODUCTOS EXISTENTES");
	 for (int n=0;n<Productos.nombres.length;n++) {
		 System.out.print("Posicion ["+n+"] ");
		 if(Productos.identificador[n]>-1) {
			 System.out.println("ID: "+Productos.identificador[n]+" Nombre :"+Productos.nombres[n]+" Precio: "+Productos.precios[n]);	 }
		 else {
			 System.out.println("DISPONIBLE");
		 }
	 }
		System.out.println("--------------------");
	
	}
	public static  void mostrarMenu(Scanner t,VentanaPrincipal v) {
		boolean seguir=true;
		while (seguir) {
			mostrarProductos();
		
		System.out.println("Elige una opción");
		System.out.println("1: Nuevo producto");
		System.out.println("2: Modificar producto");
		System.out.println("3: Eliminar producto");
		System.out.println("-1: Salir");
		int opcion=t.nextInt();
		switch (opcion) {
		case -1:
			seguir=false;
			v.mostrarPanelTipos();
			v.setVisible(true);
			break;
			
		case 1: 
			crearProducto(t,v);
			break;
		
		case 3:
			mostrarProductos();
			System.out.println("Elija una posición para eliminar");
			eliminar(t);
			break;
		}
		
	}
	}
	
	
	
 public static void eliminar(int pos) {
	 Productos.identificador[pos]=-1;
	 Productos.imagenes[pos]="noimg.png";
	 Productos.nombres[pos]="";
	 Productos.precios[pos]=0;
	 Productos.tipos[pos]=0;
	 System.out.println("Producto borrado con exito");
	 
 }
 public static void login(VentanaPrincipal v) {
	

	 Scanner t=new Scanner(System.in);
	 System.out.println("Introduzca nombre de usuario");
	 String user= t.nextLine();
	 System.out.println("Introduzca la contraseña");
	 String pass= t.nextLine();
	 if (user.equals("admin")&& pass.equals("admin")) {
			mostrarMenu(t,v);
	 }else {
	 System.out.println("ERROR DE LOGIN");

		 
	 
	 v.mostrarPanelTipos();
	 v.setVisible(true);}
	 
 }
 public static void crearProducto(Scanner t,VentanaPrincipal v) {
	 int pos=GestorProductos.getPosicionLibre();
	 int idNuevo;
	 String nombreNuevo;
	 double precio;
	 int tipo;
	 String imagen;
	 if(pos!=-1) {
		 idNuevo= obtenerID(t);
		 tipo=obtenerTipo(t,idNuevo);
		 nombreNuevo=obtenerNombre(t,idNuevo);
		 precio=obtenerPrecio(t);
		 imagen=obtenerImagen(t);
		 Productos.identificador[pos]=idNuevo;
		 Productos.nombres[pos]=nombreNuevo;
		 Productos.tipos[pos]=tipo;
		 Productos.precios[pos]=precio;
		 Productos.imagenes[pos]=imagen;
	 }else {
		 System.out.println("No hay posiciones disponibles");
		 mostrarMenu(t,v);
	 }
	 
	 
	 
 }
 public static int obtenerID(Scanner t) {
	 int id,idTemp;
	 t.nextLine();
	 System.out.println("Los siguientes identificadores no están disponibles");
	 for(int n=0;n<Productos.identificador.length;n++) {
		 idTemp=Productos.identificador[n];
		 if(idTemp!=-1) {
		 System.out.print("["+idTemp+"] ");}
	 }
	 System.out.println("\n---------------------------");
	 try {
		 System.out.println("Introduzca un entero disponible positivo como identificador");
		 id=t.nextInt();
		 if(GestorProductos.getPosicion(id)!=-1) {
			 System.out.println("El identificador ("+id+") esta ocupado");
			 return obtenerID(t);
		 }
		 
	 }catch (Exception e) {
		 t.nextLine();
		 System.out.println("El valor introducido no es valido");
		 return obtenerID(t);
	 }
	 return id;
 }
 public static String obtenerNombre(Scanner t, int id) {
	 t.nextLine();
	 
	 System.out.println("Introduzca un nombre para el producto ID= "+id);
	 String nombre=t.nextLine();
	 return nombre;
	 
 }
 public static int obtenerTipo(Scanner t,int id) {
	 System.out.println("Eliga un tipo");
	 System.out.println(Productos.BEBIDA+" : Bebida");
	 System.out.println(Productos.SNACK+" : Snack");
	 System.out.println(Productos.GOMINOLA+" : Gominola");
	 System.out.println(Productos.BOLLERIA+" : Bolleria");
	 try {
		 int tipo=t.nextInt();
		 if(tipo>0 && tipo<5) {
			 return tipo;
		 }else {
			 System.out.println("El valor no es valido");
			 return obtenerTipo(t, id);
		 }
		 
	 }catch(Exception e) {
		 t.next();
		 System.out.println("Valor invalido");
		 return obtenerTipo(t, id);
		 
	 }
 }
 public static double obtenerPrecio(Scanner t) {
	 try {
		 System.out.println("Introduzca el precio");
		 return t.nextDouble();
		 
	 }catch (Exception e) {
		 t.next();
		 System.out.println("El valor no es valido");
		 return obtenerPrecio(t);
	 }
 }
 
 public static String obtenerImagen(Scanner t) {
	 t.nextLine();
	 System.out.println("Introduzca el nombre de la imagen");
	 String imagen=t.nextLine();
	 return imagen;
 
 }
 public static void eliminar(Scanner t) {
	 t.nextLine();
	 try {
		 int pos=t.nextInt();
		 eliminar(pos);
	 }catch(Exception e) {
		 System.out.println("Valor incorrecto");
		 t.nextLine();
		 eliminar(t);
	 }
	 
 }
}
