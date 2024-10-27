package controlador;

import modelo.Productos;

public class GestorProductos {
	
	public static int numProductosTipo(int tipo) {
		int cont=0;
		for(int n=0;n<Productos.tipos.length;n++) {
	
			if(Productos.tipos[n]== tipo) cont++;
		}
		return cont;
	}
	
	
	public static String[] getProductosTipo(int tipo) {
		int cantidad= numProductosTipo(tipo);
		if (cantidad>0) {
			String[] productos=new String[cantidad];
			int cont=0;
			for(int n=0;n<Productos.nombres.length;n++) {
				if(Productos.tipos[n]==tipo) {
					productos[cont]=Productos.nombres[n];
					cont++;				
				}
			}
			return productos;
		
	}
		
		
		return null;
	}
	public static String[] getImagenesTipo(int tipo) {
		int cantidad= numProductosTipo(tipo);
		if (cantidad>0) {
			String[] imagenes=new String[cantidad];
			int cont=0;
			for(int n=0;n<Productos.imagenes.length;n++) {
				if(Productos.tipos[n]==tipo) {
					imagenes[cont]=Productos.imagenes[n];
					cont++;				
				}
			}
			return imagenes;
		
	}
		return null;
	}
	public static double[] getPreciosTipo(int tipo) {
		int cantidad= numProductosTipo(tipo);
		if (cantidad>0) {
			double[] precios=new double[cantidad];
			int cont=0;
			for(int n=0;n<Productos.precios.length;n++) {
				if(Productos.tipos[n]==tipo) {
					precios[cont]=Productos.precios[n];
					cont++;				
				}
			}
				return precios;	
	}
		
		return null;
	}
	
	public static double totalConIva() {
		double total=0;
		for(int n=0; n<Productos.cantidadComprada.length;n++) {
			if(Productos.cantidadComprada[n]>0) {
				total+=Productos.cantidadComprada[n]*Productos.precios[n];
			}
		}
		
		return total;
	}
	public static int[] getIdentificadoresTipo(int tipo) {
		int cantidad= numProductosTipo(tipo);
		if (cantidad>0) {
			int[] id=new int[cantidad];
			int cont=0;
			for(int n=0;n<Productos.identificador.length;n++) {
				if(Productos.tipos[n]==tipo) {
					id[cont]=Productos.identificador[n];
					cont++;				
				}
			}
			return id;
					
	}
		
		return null;
	
	}
	
	public static int getPosicion(int id) {
		
		for(int n=0;n<Productos.identificador.length;n++) {
			if(Productos.identificador[n]==id) return n;
		}
		
		return -1;
	}
	public static void comprar(int id) {
		Productos.cantidadComprada[getPosicion(id)]++;
		
	}


}
