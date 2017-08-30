package Utilities;

import java.util.Random;

public class StackNotation {
	private final int SIZE;
	private final int BOUND;
	private String[] arrayOfStrings;
	private char[] arrayOfOperators = {'+', '-', '/', '*'};

	public StackNotation() {
		this(11, 10);
	}

	public StackNotation(int size, int bound) {
		this.SIZE = size;
		arrayOfStrings = new String[SIZE];
		this.BOUND = bound;
	}

	public static String[] generateNotation() {
		StackNotation sn = new StackNotation();
		int numCounter = 0;
		int operatorCounter = 0;

		for (int i = 0; i < sn.arrayOfStrings.length; i++) {
			if (numCounter >= ((sn.arrayOfStrings.length  / 2) + 1)) {
				sn.arrayOfStrings[i] = sn.getOperator();
				continue;
			}

			if (operatorCounter >= sn.arrayOfStrings.length / 2) {
				sn.arrayOfStrings[i] = sn.getNumber();
				continue;
			}

			if (new Random().nextInt(2) == 0) {
				if (new Random().nextInt(2) == 0)
					sn.arrayOfStrings[i] = "-" + sn.getNumber();
				else
					sn.arrayOfStrings[i] = sn.getNumber();
				numCounter++;
			}
			else {
				sn.arrayOfStrings[i] = sn.getOperator();
				operatorCounter++;
			}
		}

		return sn.arrayOfStrings;
	}

	private String getNumber() {
		return new Random().nextInt(BOUND) + "";
	}

	private String getOperator() {
		return arrayOfOperators[new Random().nextInt(arrayOfOperators.length - 1)] + "";
	}
}