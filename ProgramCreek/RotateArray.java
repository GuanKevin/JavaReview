package ProgramCreek;

import Utilities.ArrayOfNumbers;

import java.util.Scanner;

/**
 * Rotate an array of n elements to the right by k steps
 */

public class RotateArray {
	public static void main(String[] args) {
		int[] array;
		// array = ArrayOfNumbers.getArrayOfRandomNumbers();
		array = ArrayOfNumbers.getArrayOfSortedNumbers();

		System.out.println("List of numbers so far: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");

		System.out.print("\nHow much would you like to shift? \nMax " + (array.length - 1) + ": ");

		Scanner input = new Scanner(System.in);
		int shift = input.nextInt();

		if (shift > array.length - 1) {
			shift %= array.length;

			if (shift == 0) {
				System.out.print("There is no need to shift the array, terminating program...");
				System.exit(0);
			} else
				System.out.println("Input too high, changing to " + shift);
		}

		// Reversal
		int[] array2 = reverseArray(array, 0, array.length - shift - 1);
		array2 = reverseArray(array2, array.length - shift, array2.length - 1);
		array2 = reverseArray(array2, 0, array2.length - 1);

		// Bubble sort shift
		/*int[] array2 = bubbleSortShift(array, shift);*/

		// ArrayCopy Shift
		/* int[] array2 = performShift(array, shift); */

		displayResults(array2);

		input.close();
	}

	public static int[] reverseArray(int[] array, int start, int end) {
		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}

		return array;
	}

	public static int[] bubbleSortShift(int[] array, int shift) {
		for (int i = 0; i < shift; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				int temp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = temp;
			}
		}

		return array;
	}

	public static int[] performShift(int[] array, int shift) {
		int[] array2 = new int[array.length];

		for (int i = 0; i < array.length - shift; i++)
			array2[shift + i] = array[i];

		System.arraycopy(array, array.length - shift, array2, 0, shift);

		return array2;
	}

	public static void displayResults(int[] array2) {
		System.out.println("Displaying results:");

		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + " ");
	}
}