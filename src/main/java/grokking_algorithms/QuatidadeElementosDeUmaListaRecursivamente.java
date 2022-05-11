package grokking_algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuatidadeElementosDeUmaListaRecursivamente {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		lista.add(26);
		lista.add(26);
		lista.add(26);
		
		int quantidade = contadorElementos(lista);
		System.out.println("Números de elementos na lista: " + quantidade);
	}

	private static int contadorElementos(List<Integer> lista) {
		int contador = 1;
		lista.remove(0);
		if (!lista.isEmpty()) {
			contador += contadorElementos(lista);
		}
		return contador;
	}

}
