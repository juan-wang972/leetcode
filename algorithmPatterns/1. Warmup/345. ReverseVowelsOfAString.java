/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "IceCreAm"
 *
 * Output: "AceCreIm"
 *
 * Explanation:
 *
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 *
 * Output: "leotcede"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
/*
Soulution: Two Pointer
  Time complexity: O(n)
  Space complexity: O(n). The algorithm converts the input string into a character array, which requires  space, where N is the length of the input string.
 */
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));

        // Convert the string to a character array for mutability
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            // Move start pointer until a vowel is found
            while (start < end && !vowels.contains(chars[start])) {
                start++;
            }
            // Move end pointer until a vowel is found
            while (start < end && !vowels.contains(chars[end])) {
                end--;
            }

            // Swap the vowels
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // Move pointers
            start++;
            end--;
        }

        // Convert the character array back to a string
        return new String(chars);
    }
}