/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

/*
Solution: Sliding Window with HashMap
  Time complexity: O(n)
  Space complexity: O(k), where k is the number of unique characters (e.g., 26 for English letters).
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and within the window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update the character's index in the map
            charIndexMap.put(currentChar, end);

            // Calculate the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}