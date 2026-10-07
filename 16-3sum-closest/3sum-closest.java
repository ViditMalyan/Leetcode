class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Check if current sum is closer
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Exact answer
                if (currentSum == target) {
                    return currentSum;
                }

                // Current sum is too small
                if (currentSum < target) {
                    left++;
                }

                // Current sum is too large
                else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}