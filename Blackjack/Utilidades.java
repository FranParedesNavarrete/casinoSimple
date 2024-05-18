package Blackjack;

import java.util.*;
import Blackjack.Blackjack;
import java.util.ArrayList;

public class Utilidades {
	public static ArrayList<carta> baraja = new ArrayList<carta>();
	
	static void generarCartas() {
		ArrayList<String> colores = new ArrayList<String>();
		colores.add("Picas");
		colores.add("Diamantes");
		colores.add("Corazones");
		colores.add("Treboles");

		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				switch(j) {
				case 0:
					baraja.add(new carta(colores.get(i), "As", 1, "src/Blackjack/ImagenesCartas/" + colores.get(i) + "/As.png"));
					break;
				case 10:
					baraja.add(new carta(colores.get(i), "Jack", 10, "src/Blackjack/ImagenesCartas/" + colores.get(i) + "/Jack.png"));
					break;
				case 11:
					baraja.add(new carta(colores.get(i), "Reina" , 10, "src/Blackjack/ImagenesCartas/" + colores.get(i) + "/Reina.png"));
					break;
				case 12:
					baraja.add(new carta(colores.get(i), "Rey", 10, "src/Blackjack/ImagenesCartas/" + colores.get(i) + "/Rey.png"));
					break;
				default:
					baraja.add(new carta(colores.get(i), j + 1 + "", j, "src/Blackjack/ImagenesCartas/" + colores.get(i) + "/" + j + ".png"));
					break;
				}
					
			}
		}
	}
	
	static carta nuevaCarta() {
		int random = (int) (Math.random()*52);
		
		return baraja.get(random);
	}
	
	
}
