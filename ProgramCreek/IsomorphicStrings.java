package ProgramCreek;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder("egg");
		String s2 = "add";
		Map<Character, Character> exchangeMap = new HashMap<>();

		System.out.println("Testing string (" + s1 + ") and string (" + s2 + ").");

		if (s1 == null || s2 == null) {
			System.out.println("The strings are not isomorphic.");
			System.exit(0);
		}

		for (int i = 0; i < s1.length(); i++) {
			if (exchangeMap.containsKey(s1.charAt(i))) {
				if (exchangeMap.get(s1.charAt(i)).equals(s2.charAt(i)))
					s1.replace(i, i + 1, exchangeMap.get(s1.charAt(i)) + "");
				else
					break;
			}
			else {
				exchangeMap.put(s1.charAt(i), s2.charAt(i));
				s1.replace(i , i + 1, exchangeMap.get(s1.charAt(i)) + "");
			}
		}

		if (s2.equals(s1.toString()))
			System.out.println("These strings are isomorphic!");
		else
			System.out.println("These strings are not isomorphic!");
	}
}
