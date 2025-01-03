/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: true
 *
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: false
 *
 * Explanation:
 *
 * All elements are distinct.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

/*
Solution 1: Brute Force
  Time complexity: O(n^2)
  Space complexity: O(1)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

/*
Solution 2: Using HashSet
  Time complexity: O(n)
  Space complexity: O(n)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Use HashSet to store unique elements
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i: nums) {
            if (uniqueSet.contains(i)) {
                return true;
            }
            uniqueSet.add(i);
        }

        return false;
    }
}

/*
Solution 3: Sorting
  Time complexity: O(nlogn)
  Space complexity: O(logn), the implementation of Arrays.sort() uses quick sort algorithm, which has a space complexity of O(nlogn) due to the recursion stack for in-place sorting.
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        // use a loop to compare each element with its next element
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}