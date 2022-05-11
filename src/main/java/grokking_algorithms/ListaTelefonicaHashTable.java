package grokking_algorithms;

import java.util.HashMap;

public class ListaTelefonicaHashTable {

	public static void main(String[] args) {
		HashMap<String, Integer> listaTelefonica = new HashMap<>();
		listaTelefonica.put("Marcelo", 33328596);
		System.out.println(listaTelefonica.get("Marcelo"));
	}
}
