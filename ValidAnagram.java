import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram {

    public static void main(String[] args) { 

        ValidAnagram isAnagram = new ValidAnagram();

        System.out.println(isAnagram.isAnagram("racecar", "carrace"));
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> firstWordLetters = new HashMap<>();
        Map<Character, Integer> secondWordLetters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            int letterCount = 1;
            if (firstWordLetters.containsKey(letter)) {
                letterCount = firstWordLetters.get(letter);
                letterCount++;
            }
            firstWordLetters.put(letter, letterCount);
        }

        for (int i = 0; i < t.length(); i++) {
            Character letter = t.charAt(i);
            int letterCount = 1;
            if (secondWordLetters.containsKey(letter)) {
                letterCount = secondWordLetters.get(letter);
                letterCount++;
            }
            secondWordLetters.put(letter, letterCount);
        }

        for (Map.Entry<Character, Integer> entry : firstWordLetters.entrySet()) {
            Character letter  = entry.getKey();
            Integer letterCount = entry.getValue();

            if (secondWordLetters.containsKey(letter)) {
                int secondWordletterCount = secondWordLetters.get(letter);
                if (letterCount != secondWordletterCount) {
                    return false;
                }

            } else {
                return false;
            }
        }

            return true;
    }
}
