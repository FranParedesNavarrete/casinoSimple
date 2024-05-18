package Blackjack;

public class carta {
	private String nombre;
	private String numero;
	private int valor;
	private String imagen;
	
	public carta(String nombre, String numero, int valor, String imagen) {
		this.nombre = nombre;
		this.numero = numero;
		this.valor = valor;
		this.imagen = imagen;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getNumero() {
		return numero;
	}

	public int getValor() {
		return valor;
	}

	public String getImagen() {
		return imagen;
	}
	
	@Override
	public String toString() {
		return numero + " de " + nombre;
	}
		
}
