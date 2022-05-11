package grokking_algorithms;

import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
		}

		System.out.println("Before:");
		printArray(numbers);

		// quicksort(numbers);
		quicksort(numbers, 0, numbers.length - 1);

		System.out.println("\nAfter:");
		printArray(numbers);
	}

	private static void quicksort(int[] array, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}
		
		int pivot = array[highIndex];
		int lp = partition(array, lowIndex, highIndex, pivot);
		
		quicksort(array, lowIndex, lp - 1); // para a parte da esquerda
		quicksort(array, lp + 1, highIndex); // para a parte da direita
	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		int lp = lowIndex;
		int rp = highIndex - 1;

		while (lp < rp) {

			while (array[lp] <= pivot && lp < rp) {
				lp++;
			}

			while (array[rp] >= pivot && rp > lp) {
				--rp;
			}

			swap(array, lp, rp);
		}
			
		swap(array, lp, highIndex);
		return lp;
	}

	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
