package pentagono;
//SABADO A LAS 12.
//HERENCIA CLASE PASA TODAS SUS CARACTERISTICAS Y COMPORTAMIENTOS A UNA PREDECESORA

public class Pentagono {
	//private static final Integer ANGULO = 72;
	//private Linea[] lado = new Linea[5]; //En el futuro para calcular los lados del pentagono
	private Punto[] vertice = new Punto[5];
	private Punto centro;
	public Pentagono(Punto centro, Double longitudDeRadio, Double anguloInicial) {
		this.centro = new Punto();
		this.centro.setX(centro.getX());
		this.centro.setY(centro.getY());
		setVerticesCentroVariable(this.centro, longitudDeRadio, anguloInicial); //para poner vertices con centro a tu gusto.
	}
	public Pentagono(Double longitudDeRadio, Double anguloInicial) { //centro origen, vertice inicial, angulo inical
		//centro.setX(0.0);;
		//centro.setY(0.0);
		setVerticesCentroOrigen(longitudDeRadio, anguloInicial);
	}
	public void setVerticesCentroOrigen(Double longitudDeLinea, Double anguloInicial) {
		for(int i=0; i<5; i++) {
			vertice[i] = new Punto();
			if(getCuadranteAngulo(anguloInicial) == Cuadrante.I) {
				vertice[i].setX(catAdyacente(anguloInicial, longitudDeLinea));
				vertice[i].setY(catOpuesto(anguloInicial, longitudDeLinea));	
			}else if(getCuadranteAngulo(anguloInicial) == Cuadrante.II) {
				vertice[i].setX(-catAdyacente(180-anguloInicial, longitudDeLinea));
				vertice[i].setY(catOpuesto(180-anguloInicial, longitudDeLinea));
			}else if(getCuadranteAngulo(anguloInicial) == Cuadrante.III) {
				vertice[i].setX(-catAdyacente(anguloInicial-180, longitudDeLinea));
				vertice[i].setY(-catOpuesto(anguloInicial-180, longitudDeLinea));
			}else if(getCuadranteAngulo(anguloInicial) == Cuadrante.IV) {
				vertice[i].setX(catAdyacente(360-anguloInicial, longitudDeLinea));
				vertice[i].setY(-catOpuesto(360-anguloInicial, longitudDeLinea));
			}
			anguloInicial+=72;
		}
	}
	public void setVerticesCentroVariable(Punto centro,Double longitudDeLinea, Double anguloInicial) {
		setVerticesCentroOrigen(longitudDeLinea, anguloInicial);
		for(int i=0; i<5; i++) {
			vertice[i].setX(vertice[i].getX()+centro.getX());
			vertice[i].setY(vertice[i].getY()+centro.getY());
		}
	}
	public void showVertices() { //Mostrar vertices
		for(int i=0;i<5;i++) {
			System.out.printf("Vertice %d en coordenadas (%.2f , %.2f)\n",i, vertice[i].getX(), vertice[i].getY());
		}
	}
	public static Double catOpuesto(Double angulo, Double longitudDeLinea) { //Funcion que calcula el cateto Opuesto (Y)
		Double catetoOpuesto = longitudDeLinea*Math.sin(Math.toRadians(angulo));
		return catetoOpuesto;
	}
	public static Double catAdyacente(Double angulo, Double longitudDeLinea) {//Funcion que calcula el cateto Adyacente (X)
		Double catetoAdyacente = longitudDeLinea*Math.cos(Math.toRadians(angulo));
		return catetoAdyacente;
	}
	public static Cuadrante getCuadranteAngulo(Double angulo) { //para verificar en que cuadrante esta el angulo
		if((angulo>=0 && angulo<90) || angulo == 360) {  // Cuadrante I [0,90) Ó 360
			return Cuadrante.I;
		}else if(angulo>=90 && angulo<180) {			 // Cuadrante II [90,180)
			return Cuadrante.II;
		}else if(angulo>=180 && angulo<270) {			// Cuadrante III [180,270)
			return Cuadrante.III;
		}else if(angulo>=270 && angulo<360) {			// Cuadrante IV [270,360)
			return Cuadrante.IV;
		}else {
			if(angulo<0) {								//Si angulo menor a 0 sumamos 360 hasta hacerlo positivo
				while(angulo<0)							//y asi sabremos en que cuadrante esta
					angulo+=360;
				return getCuadranteAngulo(angulo);     //llamamos de nuevo a la funcion que ahora se detendra en un if
			}else {										//y retornara un cuadrante y esta a su vez retornara un cuadrante
				while(angulo>360)						//lo mismo pero ahora restamos
					angulo-=360;
				return getCuadranteAngulo(angulo);
			}
		}
	}
	
}
