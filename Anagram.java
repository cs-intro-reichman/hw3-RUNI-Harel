/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		// System.out.println(isAnagram("William Shakespeare", "I am a weakish
		// speller")); // true
		// System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		// System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
		// // true

		// Tests the preProcess function.
		//System.out.println(preProcess("What? No way!!!"));
		//System.out.println(isAnagram("abcecbe", "ebcecba"));
		System.out.println(isAnagram("c-b-a", "a?bc?"));
		//System.out.println(isAnagram("uhygtd76m", "hvghrnvd"));
		//System.out.println(randomAnagram("harEl"));
		System.out.println(isAnagram("hello", "world!"));

		// Tests the randomAnagram function.
		// System.out.println("silent and " + randomAnagram("silent") + " are
		// anagrams.");
		System.out.println(randomAnagram("abcdefg"));

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);
		char s1 = 'z';
		char s2 = 'x';
		//remove spaces
		String regexString = "\\s";
		newStr1=newStr1.replaceAll(regexString, "");
		newStr2=newStr2.replaceAll(regexString, "");
		int index=0;
		if((newStr1 == "") || (newStr2 == "")){
			return true;
		}
		if (newStr1.length() != newStr2.length()) {
			return false;
		} else {
			while (newStr1.length()>0) {
				s1 = newStr1.charAt(0);
				for (int j = 0; j < newStr2.length(); j++) {
					s2 = newStr2.charAt(j);
					if (s1 == s2) {
						newStr1 = newStr1.substring(1);
						newStr2 = newStr2.substring(0, j) + newStr2.substring(j + 1);
						index++;
						break;
					}
					if (j == newStr2.length()-1 && s1!=s2) {
						return false;
					}
				}
			}
		}
		return true;

	}

	// Returns true if the two given strings are anagrams, false otherwise.
	/*
	 * public static boolean isAnagram(String str1, String str2) {
	 * // Replace the following statement with your code
	 * String newStr1 = preProcess(str1);
	 * String newStr2 = preProcess(str2);
	 * if (newStr1.length() != newStr2.length() || (newStr1 == "") || (newStr2 ==
	 * "")) {
	 * return false;
	 * } else {
	 * for (int i = 0; i < newStr1.length() - 1; i++) {
	 * if (newStr1.charAt(i) != newStr2.charAt(newStr2.length() - 1 - i)) {
	 * return false;
	 * }
	 * }
	 * }
	 * return true;
	 * 
	 * }
	 */

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		// this is my code
		String regexString = "[`!@#$%^&*(){};\\':\",./<>?\\[\\]=-]";
		String newStr = str.toLowerCase();
		newStr = newStr.replaceAll(regexString, "");
		return newStr;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String procStr = preProcess(str);
		String newStr = "";
		int procStrLen = procStr.length();
		for (int i = 0; i < procStrLen; i++) {
			int rand = (int) (Math.random() * procStr.length() - 1);
			newStr = newStr + procStr.charAt(rand);
			procStr = procStr.substring(0, rand) + procStr.substring(rand + 1);
		}
		return newStr;
	}
}