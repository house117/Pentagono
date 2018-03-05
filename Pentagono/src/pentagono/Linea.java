package pentagono;

public class Linea {
	private Punto inicioLinea;
	private Punto finLinea;
	public Linea(Punto x1, Punto x2) {
		this.setInicio(x1);
		this.finLinea = x2;
	}
	public Linea(Double x1, Double y1,
			Double x2, Double y2) {
		this.setInicio(new Punto(x1, y1));
		this.finLinea = new Punto(x2, y2);
	}
	public Double longitudLinea() {
		//INVESTIGAR FUNCIONES MATEMATICAS, Y FUNCIONES DE CADENA
		return Math.sqrt(Math.pow(finLinea.getX()-getInicio().getX(), 2)+Math.pow(finLinea.getY()-getInicio().getY(), 2));
		//hacer la funcion de distancia
		/*TAREA HACER UNA CLASE POLÍGONO
		 * DEFINIR TANTOS PUNTOS COMO TU QUIERAS 
		 */
	}
	private Punto getInicio() {
		return inicioLinea;
	}
	private void setInicio(Punto inicio) {
		this.inicioLinea = inicio;
	}
}
