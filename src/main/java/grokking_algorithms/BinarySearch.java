package grokking_algorithms;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9};
		int elemento = -3;
		System.out.println(binarySearch(array, elemento));
	}
	
	public static String binarySearch(int[] array, int elemento) {
		
		int menor = 0;
		int maior = array.length - 1;
		int media = 0;
		int palpite = 0;
		
		while (menor <= maior) {
			media = (menor + maior) / 2;
			palpite = array[media];
			if (palpite == elemento) {
				return "posição: " + media;
			} else if (palpite < elemento) {
				menor = media + 1;
			} else if (palpite > elemento) {
				maior = media - 1;
			}
		}
	
		return "O número buscado não está presente no array!";
	}
}
