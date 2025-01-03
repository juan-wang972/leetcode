/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
/*
Solution 1: Brute Force
  Time complexity: O(n^2)
  Space complexity: O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                total *= nums[j];
            }
            result[i] = total;
        }

        return result;
    }
}

/*
Solution 2: Precomputation
  Time complexity: O(n)
  Space complexity:O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1; // No elements before the first element
        for (int i = 1; i < n; i++) {
            // prefix[i] stores the product of all elements before index i.
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1; // No elements after the last element
        for (int i = n - 2; i >= 0; i--) {
            // suffix[i] stores the product of all elements after index i.
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}

/*
Solution 2: Optimized Precomputation
  Time complexity: O(n)
  Space complexity:O(1)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute prefix product for each element and store it in the result array
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            // prefix[i] stores the product of all elements before index i.
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute suffix product on the fly and combine it with the prefix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}