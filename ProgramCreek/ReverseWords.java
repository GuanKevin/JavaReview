package ProgramCreek;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 */

public class ReverseWords {
	public static void main(String[] args) {
		String reverseWord = "Testing a string that is longer than Hello World.";

		if (reverseWord == null || reverseWord.isEmpty()) {
			System.out.println("No words to reverse!");
		}

		String[] listOfWords = reverseWord.split(" ");

		if (listOfWords.length == 1) {
			System.out.println("There is no need to reverse this string: " + reverseWord);
		} else {
			int start = 0;
			int end = listOfWords.length - 1;

			while (start < end) {
				String word = listOfWords[start];
				listOfWords[start] = listOfWords[end];
				listOfWords[end] = word;

				start++;
				end--;
			}

			System.out.println(Arrays.toString(listOfWords));
		}
	}
}
