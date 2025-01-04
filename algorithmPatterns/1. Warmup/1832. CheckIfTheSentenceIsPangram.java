/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 */
/*
Solution: HashSet
  Time complexity: O(n)
  Space complexity: O(1), the HashSet's maximum size is constant (at most 26 characters) - O(26)
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }

        return set.size() == 26;
    }
}

/**
 * Form 2: Given a string sentence containing English letters (lower- or upper-case), return true if sentence is a Pangram, or false otherwise.
 *
 * A Pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Note: The given sentence might contain other characters like digits or spaces, your solution should handle these too.
 */
/*
Solution: HashSet
  Time complexity: O(n)
  Space complexity: O(1)
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            // Convert the current character to lowercase
            char currChar = Character.toLowerCase(sentence.charAt(i));

            if (Character.isLetter(currChar)) {
                set.add(currChar);
            }
        }
        return set.size() == 26;
    }
}