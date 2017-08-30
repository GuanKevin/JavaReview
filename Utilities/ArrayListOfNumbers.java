package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListOfNumbers {
	private List<Integer> listOfIntegers;
	private int SIZE;
	private int BOUND;

	public ArrayListOfNumbers() {
		this (10, 100);
	}

	public ArrayListOfNumbers(int size, int bound) {
		this.SIZE = size;
		this.BOUND = bound;
		listOfIntegers = new ArrayList<>();
	}

	public ArrayList<Integer> getRandomListOfNumbers() {
		Random randNumber = new Random();

		for (int i = 0; i < SIZE; i++) {
			listOfIntegers.add(randNumber.nextInt(BOUND));
		}

		return (ArrayList<Integer>) listOfIntegers;
	}
}
