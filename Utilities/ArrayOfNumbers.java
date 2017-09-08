package Utilities;

import java.util.Random;

public class ArrayOfNumbers {
	private Random randomNumber;
	private int size;
	private int seed;
	private static int[] arrayOfInt;

	public ArrayOfNumbers() {
		this (7, 10);
		randomNumber = new Random();
	}

	public ArrayOfNumbers(int size, int seed) {
		this.size = size;
		this.seed = seed;
	}

	public static int[] getArrayOfRandomNumbers() {
		arrayOfInt = new ArrayOfNumbers().generateRandomNumbers();

		return arrayOfInt;
	}

	public static int[] getArrayOfSortedNumbers() {
		arrayOfInt = new ArrayOfNumbers().generateSortedNumbersArray();

		return arrayOfInt;
	}

	private int[] generateSortedNumbersArray() {
		arrayOfInt = new int[size];

		for (int i = 0; i < arrayOfInt.length; i++)
			arrayOfInt[i] = i + 1;

		return arrayOfInt;
	}

	private int[] generateRandomNumbers() {
		arrayOfInt = new int[size];

		for (int i = 0; i < arrayOfInt.length; i++)
			arrayOfInt[i] = randomNumber.nextInt(seed);

		return arrayOfInt;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ArrayOfNumbers{" +
				"randomNumber=" + randomNumber +
				", size=" + size +
				", seed=" + seed +
				'}';
	}
}
