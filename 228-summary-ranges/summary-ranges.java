class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int n = nums.length;
        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n &&
                   (long) nums[end + 1] == (long) nums[end] + 1) {
                end++;
            }

            if (start == end) {
                result.add(String.valueOf(nums[start]));
            } else {
                result.add(nums[start] + "->" + nums[end]);
            }
            start = end + 1;
        }
        return result;
    }
}