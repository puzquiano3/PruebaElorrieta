package modelo;

public class Productos {
	

		public static final int BEBIDA=1;
		public static final int SNACK=2;
		public static final int GOMINOLA=3;
		public static final int BOLLERIA=4;
		public static String[] nombres= {"Coca Cola","Fanta","7Up","Patatas","Chaskis","Pajitas","Ositos","Perlas","Boolycao","Donuts","","","","","",""};	
		public static int tipos[]=       {BEBIDA,    BEBIDA,  BEBIDA,SNACK,   SNACK,    SNACK,   GOMINOLA, GOMINOLA,BOLLERIA,BOLLERIA,0,0,0,0,0,0};	
		public static double[] precios= {1.25        ,1.2    ,1.2    ,1.0,    0.9,       0.85,    0.95,     0.90,    1.00 ,     1.05 ,0,0,0,0,0,0};
		public static int[] identificador = {0,1,2,3,4,5,6,7,8,9,-1,-1,-1,-1,-1,-1};
		public static String[] imagenes= {"img0.png","img1.png","img2.png","img3.png","img4.png","img5.png","img6.png","img7.png","img8.png","img9.png","noimg.png","noimg.png","noimg.png","noimg.png","noimg.png","noimg.png"};
		public static int [] cantidadComprada= new int[16];
		
		public static String tipoToString(int n) {
			String tipo="";
			switch (n) {
			case BEBIDA: tipo="Bebida";
			break;
			case BOLLERIA: tipo="Bolleria";
			break;
			case GOMINOLA: tipo="Gominola";
			break;
			case SNACK: tipo ="Snack";
			break;
			default: tipo="Sin asignar";
			}
			return tipo;
		}
		public static String toString(int n) {
			return "ID: "+identificador[n]+" ,Nombre: " +nombres[n]+", Tipo: "+tipoToString(tipos[n])+", Precio: "+precios[n]+", Imagen: "+imagenes[n];
		}
		
		

		
		

}
