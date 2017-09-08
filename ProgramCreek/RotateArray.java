package ProgramCreek;

import Utilities.ArrayOfNumbers;

/**
 * Rotate an array of n elements to the right by k steps
 * Given: 3 8 1 2 9 4 0 (Size of 7)
 * Rotate: 3
 * Steps: _ _ _ 3 8 1 2
 * Remain: 9 4 0
 * Result: 9 4 0 3 8 1 2
 */
public class RotateArray {
	public static void main(String[] args) {
		int[] array = ArrayOfNumbers.getArrayOfRandomNumbers();
		final int ROTATE = 3;

		if (array.length <= 1 || ROTATE == 0)
			System.exit(0);

		System.out.print("Initial array of n elements: ");
		for (int num: array)
			System.out.print(num + " ");
		System.out.print("\nRotate by: " + ROTATE + "\n");

		/*array = performRotation(array, ROTATE); */
		array = bubbleSortRotate(array, ROTATE);
		displayArray(array);
	}

	public static int[] bubbleSortRotate(int[] array, final int ROTATE) {
		for (int i = 0; i < ROTATE; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				int temp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = temp;
			}
		}

		return array;
	}

	/**
	 *
	 * @param array
	 * @param ROTATE
	 */
	public static int[] performRotation(int[] array, final int ROTATE) {
		int[] array2 = new int[array.length];

		for (int i = 0; i < array.length - ROTATE; i++)
			array2[ROTATE + i] = array[i];

		displayArray(array2);
		System.arraycopy(array, array.length - ROTATE, array2, 0, ROTATE);

		return array2;
	}

	public static void displayArray(int[] array) {
		System.out.print("After shift: ");
		for (int num: array)
			System.out.print(num + " ");
		System.out.println();
	}
}