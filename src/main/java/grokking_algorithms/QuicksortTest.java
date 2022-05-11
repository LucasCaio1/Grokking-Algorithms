package grokking_algorithms;

import java.security.*;

public class QuicksortTest {

	public static void main(String[] args) {

		SecureRandom geradorDenNumeros = new SecureRandom();
		int[] array = new int[10];

		for (int i = 0; i < array.length; i++) {
			array[i] = geradorDenNumeros.nextInt(100);
		}

		printArray(array);
		quicksort(array, 0, array.length - 1);
		System.out.println();
		printArray(array);

	}

	public static void quicksort(int[] array, int lowIndex, int highIndex) {

		if (lowIndex >= highIndex)
			return;

		int pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex - 1;

		while (leftPointer < rightPointer) {
			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}

			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			swap(array, leftPointer, rightPointer);
			 printArray(array);
		}

		if (array[leftPointer] > array[highIndex]) {
			swap(array, leftPointer, highIndex);
		} else {
			leftPointer = highIndex;
		}
		
		printArray(array);
		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);
	}

	private static void swap(int[] array, int position1, int position2) {
		int temporary = array[position1];
		array[position1] = array[position2];
		array[position2] = temporary;
	}

	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
