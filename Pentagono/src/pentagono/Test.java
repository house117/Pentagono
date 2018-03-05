package pentagono;

public class Test {
	public static void main(String[] args) {
		Pentagono penti = new Pentagono(3.0, 0.0); //creamos pentagono con constructor recibiendo coordenadas del centro
		System.out.println("\nPENTI 1: ");
		penti.showVertices();
		Punto centroPenti2 = new Punto(4.0, 4.0);
		Pentagono penti2 = new Pentagono(centroPenti2, 3.0, 90.0);
		System.out.println("\nPENTI 2: ");
		penti2.showVertices();
		Punto centroPenti3 = new Punto(-4.0, 4.0);
		Pentagono penti3 = new Pentagono(centroPenti3, 3.0, 90.0);
		System.out.println("\nPENTI 3: ");
	
		penti3.showVertices();
	}
}
