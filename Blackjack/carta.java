package Blackjack;

public class carta {
	private String nombre;
	private String numero;
	private int valor;
	
	public carta(String nombre, String numero, int valor) {
		this.nombre = nombre;
		this.numero = numero;
		this.valor = valor;
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

	@Override
	public String toString() {
		return numero + " de " + nombre;
	}
		
}
