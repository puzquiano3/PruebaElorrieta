package controlador;

import modelo.Producto;

public class GestorProductos {

	Producto[] productos;

	public GestorProductos(int dimension) {
		productos = new Producto[dimension];
	}

	public boolean addProducto(Producto p) {
		int pos = -1; // variable para guardar la primera posición vacía

		for (int n = 0; n < productos.length; n++) {
			if (productos[n] == null) {
				pos = n;
				break;
			}
		}
		if (pos == -1) {
			System.out.println("no se pueden añadir más productos");
			return false;
		}
		if (comprobarProducto(p)) {
			productos[pos] = p;
			return true;
		}
		return false;
	}

	public Producto getProducto(int pos) {
		return productos[pos];
	}

	public Producto getProducto(String nombre) {
		for (int n = 0; n < productos.length; n++) {
			if (productos[n].getNombre().equals(nombre)) {
				return productos[n];
			}
		}
		return null;
	}

	private boolean comprobarProducto(Producto p) {
		for (Producto producto : productos) {
			if(producto !=null) {
			if (producto.getNombre().equals(p.getNombre())) {
				System.out.println("Ya existe un producto con este nombre");
				System.out.println("El producto "+p.toString()+" no se ha añadido");
				return false;
			}}
		}

		return true;
	}
 
	public void imprimirTodo() {
		int cont=0;
		for(int n=0;n<productos.length;n++) {
			if (productos[n] !=null) {
			System.out.println(productos[n].toString());
		}else {
			cont++;
			System.out.println("La posición "+n+" esta vacía");
		}
		}
		if(cont>0) {
			System.out.println("Hay "+cont+" posiciones libres");
		}
	}
	public void imprimirPorTipo(int tipo) {
		for (int i = 0; i < productos.length; i++) {
			
			if(productos[i]!=null) {
				if(productos[i].getTipo()==tipo) {
					System.out.println(productos[i].toString());
				}
			}
			
		}
	}

}
