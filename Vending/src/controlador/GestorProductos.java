package controlador;

import modelo.Producto;

public class GestorProductos {
	
	Producto [] productos;

	public GestorProductos(int dimension) {
		productos=new Producto[dimension];
	}
	
	public void addProducto(Producto p, int pos) {
		
		try {
			
			productos[pos]=p;
			
		}catch (Exception e) {
			System.out.println("El producto no se ha podido añadir");
			System.out.println(e.getMessage());
		}
		
	}
	public Producto getProducto(int pos) {
		return productos[pos];
	}
	
	public Producto getProducto(String nombre) {
		for(int n=0;n<productos.length;n++) {
			if(productos[n].getNombre().equals(nombre)) {
				return productos[n];
			}
		}
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		Producto coca=new Producto(Producto.BEBIDA, "Coca cola", 1.25);
		Producto fantaN=new Producto(Producto.BEBIDA, "Fanta Naranja", 1.25);
		Producto fantaL=new Producto(Producto.BEBIDA, "Fanta Limon", 1.25);
		Producto seven=new Producto(Producto.BEBIDA, "Seven UP", 1.25);
		Producto agua=new Producto(Producto.BEBIDA, "Agua", 1);
		
		Producto patatas=new Producto(Producto.SNACK, "Patatas chips", 1.15);
		Producto pringles=new Producto(Producto.SNACK, "Pringles", 1.15);	
		
	}

}
