class Solution {
    public int minOperations(int[] nums, int x) {
         int n = nums.length;

        // Total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // We want to keep a subarray with this sum
        int target = totalSum - x;
        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int left = 0;
        int currentSum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // Shrink the window
            while (currentSum > target) {
                currentSum -= nums[left];
                left++;
            }

            // Found a valid subarray
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
}