package controlador;
import controlador.GestorProductos;
import modelo.Producto;

public class PruebaGestionProductos {
	
	
	
	public static void main(String[] args) {
		Producto coca=new Producto(Producto.BEBIDA, "Coca cola", 1.25);
		Producto fantaN=new Producto(Producto.BEBIDA, "Fanta Naranja", 1.25);
		Producto fantaL=new Producto(Producto.BEBIDA, "Fanta Limon", 1.25);
		Producto agua=new Producto(Producto.BEBIDA, "Agua", 1);
		
		Producto patatas=new Producto(Producto.SNACK, "Patatas chips", 1.15);
		Producto pringles=new Producto(Producto.SNACK, "Pringles", 1.15);	
		
		Producto ositos=new Producto(Producto.GOMINOLA,"ositos",1.00);
		Producto regalices=new Producto(Producto.GOMINOLA,"regalices",0.8);
		
		Producto donuts=new Producto(Producto.BOLLERIA,"Donuts",1.50);
		Producto palmeraChocolate=new Producto(Producto.BOLLERIA,"Palmera de chocolate",1.4);
		
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
	Producto error=new Producto(2,"Pringles", 3);
		gestor.addProducto(error);
		
	
		
	}

}
