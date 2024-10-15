package modelo;

public class Producto {
	

		public static final int BEBIDA=1;
		public static final int SNACK=2;
		public static final int GOMINOLA=3;
		public static final int BOLLERIA=4;
		private int tipo;
		private String nombre;
		private double precio;
		
		
		public Producto (int tipo,String nombre,double precio) {
			setTipo(tipo);
			setNombre(nombre);
			setPrecio(precio);
		}
		/**
		 * @return the tipo
		 */
		public int getTipo() {
			return tipo;
		}
		/**
		 * @param tipo the tipo to set
		 */
		public void setTipo(int tipo) {
			this.tipo = tipo;
		}
		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * @return the precio
		 */
		public double getPrecio() {
			return precio;
		}
		/**
		 * @param precio the precio to set
		 */
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
		

}
