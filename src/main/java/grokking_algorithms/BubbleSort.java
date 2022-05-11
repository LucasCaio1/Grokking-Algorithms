package grokking_algorithms;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {5, 21, 2, 36, 1024, 72, 9};
		int maior;
		int intermediario;
		
		for (int i = 0; i < array.length; i++) {
			maior = array[i];
			for (int c = i+1; c < array.length; c++) {
				if (array[c] > maior) {
					intermediario = maior;
					maior = array[c];
					array[c] = intermediario;
				}
			}
			array[i] = maior;
		}
		
		for (int i : array) {
			System.out.println(i);
		}
	}

}
