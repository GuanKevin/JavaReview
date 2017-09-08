package ProgramCreek;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 */

public class ReverseWords {
	public static void main(String[] args) {
		String inputStr = "129He&*llo to ++the &@3 Worlds! :) ?43?";

		reverseString(inputStr);
	}

	/**
	 * If program ends and returns an
	 * exit code of 1, no reverse was done because it only contains a singe char!
	 * exit code of 2, no reverse was done because it only contains a word!
	 *
	 * @param inputStr
	 */
	public static void reverseString(String inputStr) {
		if (inputStr.length() <= 1) {
			System.out.println("Reverse complete: " + inputStr);
			System.exit(1);
		}

		inputStr = inputStr.replaceAll("[^A-Za-z ]", "");
		// todo replace length of 2 or more leading white space with a single whitespace
		// inputStr = inputStr.replaceAll("[  ]+", "");
		System.out.println(inputStr);

		String[] wordList = inputStr.split(" ");
		System.out.println(Arrays.toString(wordList));

		if (wordList.length == 1) {
			System.out.println("Reverse complete: " + wordList[0]);
			System.exit(2);
		}

		int start = 0;
		int end = wordList.length - 1;

		while (start < end) {
			String word = wordList[start];
			wordList[start] = wordList[end];
			wordList[end] = word;

			start++;
			end--;
		}

		for (int i = 0; i < wordList.length; i++)
			System.out.print(wordList[i] + " ");
	}
}
