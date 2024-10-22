package controlador;
import controlador.GestorProductos;
import modelo.Productos;

public class PruebaGestionProductos {
	
	
	
	public static void main(String[] args) {
		Productos coca=new Productos(Productos.BEBIDA, "Coca cola", 1.25);
		Productos fantaN=new Productos(Productos.BEBIDA, "Fanta Naranja", 1.25);
		Productos fantaL=new Productos(Productos.BEBIDA, "Fanta Limon", 1.25);
		Productos agua=new Productos(Productos.BEBIDA, "Agua", 1);
		
		Productos patatas=new Productos(Productos.SNACK, "Patatas chips", 1.15);
		Productos pringles=new Productos(Productos.SNACK, "Pringles", 1.15);	
		
		Productos ositos=new Productos(Productos.GOMINOLA,"ositos",1.00);
		Productos regalices=new Productos(Productos.GOMINOLA,"regalices",0.8);
		
		Productos donuts=new Productos(Productos.BOLLERIA,"Donuts",1.50);
		Productos palmeraChocolate=new Productos(Productos.BOLLERIA,"Palmera de chocolate",1.4);
		
		GestorProductos gestor=new GestorProductos(16);

		gestor.addProducto(coca);
		gestor.addProducto(palmeraChocolate);
		gestor.addProducto(pringles);
		gestor.addProducto(patatas);
		gestor.addProducto(donuts);
		gestor.addProducto(regalices);
		gestor.addProducto(ositos);
		gestor.addProducto(agua);
		gestor.addProducto(fantaL);
		gestor.addProducto(fantaN);
		gestor.imprimirTodo();
	Productos error=new Productos(2,"Pringles", 3);
		gestor.addProducto(error);
		System.out.println("Lista de productos de tipo 1");
		gestor.imprimirPorTipo(1);
		System.out.println("Lista de productos de tipo 2");
		gestor.imprimirPorTipo(2);
		System.out.println("Lista de productos de tipo 3");
		gestor.imprimirPorTipo(3);
		System.out.println("Lista de productos de tipo 4");
		gestor.imprimirPorTipo(4);				
	}

}
