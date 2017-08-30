package ProgramCreek;

import Utilities.ArrayListOfNumbers;

import java.util.*;

/**
 * 1 Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 */
public class TwoSums {
	public static void main(String[] args) {
		ArrayListOfNumbers integerListGenerator = new ArrayListOfNumbers();
		ArrayList<Integer> listOfInt = integerListGenerator.getRandomListOfNumbers();

		for (Integer i: listOfInt) {
			System.out.print(i + " ");
		}

		System.out.print("Enter a number: ");
		Scanner input = new Scanner(System.in);
		int  sum = input.nextInt();
		Map<Integer, Integer> indexMap = new TwoSums().twoSum(listOfInt, sum);

		Iterator t = indexMap.entrySet().iterator();

		input.close();
	}

	public HashMap<Integer, Integer> twoSum(ArrayList<Integer> list, int sum) {
		HashMap<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++)
				if (list.get(i) + list.get(j) == sum) {
					indexMap.put(i, list.get(i));
					indexMap.put(j, list.get(j));
				}
		}

		return indexMap;
	}
}
