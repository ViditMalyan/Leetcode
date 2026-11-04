class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean greaterThanLeft =
                (i == 0 || nums[i] > nums[i - 1]);

            boolean greaterThanRight =
                (i == n - 1 || nums[i] > nums[i + 1]);

            if (greaterThanLeft && greaterThanRight) {
                return i;
            }
        }

        return -1;
    }
}