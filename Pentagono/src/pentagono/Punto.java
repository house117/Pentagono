package pentagono;
/*Clase que define un punto en el plano
 * 
 */
public class Punto {
	private Double x; //Coordenada en X
	private Double y; //Coordenada en Y
	public Punto (Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	public Punto() { //Sobrecarga de método constructor para no-parámetros
		this.x = 0.0;
		this.y = 0.0;
	}
	//hacer gets y sets
	public void setX(Double x) { //Método para establecer X
		this.x = x;
	}
	public void setY(Double y) { //Método para establecer Y
		this.y = y;
	}
	public Double getX() { //Método que devuelve X
		return x;
	}
	public Double getY() { //Método que devuelve Y
		return y;
	}
	public String toString() {
		String cadena = String.format("(%.5f,%.5f)", x, y);
		return cadena;
	}
	public Cuadrante getCuadrante() { //Método que devuelve el cuadrante donde está el numero
		if((x > 0) && (y >=0)) {
			return Cuadrante.I;
		}else if((x <=0 ) && (y>0)) {
			return Cuadrante.II;
		}else if((x<0) && (y<=0)) {
			return Cuadrante.III;
		}else if((x>=0)&&(y<0)) {
			return Cuadrante.IV;
		}else {
			return Cuadrante.ORIGEN;
		}
	}


	
}
