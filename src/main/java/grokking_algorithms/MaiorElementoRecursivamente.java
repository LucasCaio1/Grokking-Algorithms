package grokking_algorithms;

import java.util.ArrayList;
import java.util.List;

public class MaiorElementoRecursivamente {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(3);
		list.add(6);
		System.out.println(maiorElemento(list));

	}

	private static int maiorElemento(List<Integer> list) {
		int maior = list.get(0);
		int elemento = 0;
		list.remove(0);
		
		if (!list.isEmpty()) {
			elemento = maiorElemento(list);
		}
		
		if (elemento > maior) {
			maior = elemento;
		}
		return maior;
	}
}
