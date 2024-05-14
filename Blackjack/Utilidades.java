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
		colores.add("Tréboles");

		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				switch(j) {
				case 0:
					baraja.add(new carta(colores.get(i), "As", 1));
					break;
				case 10:
					baraja.add(new carta(colores.get(i), "Jack", 10));
					break;
				case 11:
					baraja.add(new carta(colores.get(i), "Reina" , 10));
					break;
				case 12:
					baraja.add(new carta(colores.get(i), "Rey", 10));
					break;
				default:
					baraja.add(new carta(colores.get(i), j + 1 + "", j));
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
