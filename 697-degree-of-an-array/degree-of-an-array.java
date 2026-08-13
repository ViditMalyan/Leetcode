class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();

        int degree = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            int count = frequency.getOrDefault(num, 0) + 1;
            frequency.put(num, count);

            if (count > degree) {
                degree = count;
                answer = i - first.get(num) + 1;
            } else if (count == degree) {
                answer = Math.min(
                    answer,
                    i - first.get(num) + 1
                );
            }
        }
        return answer;
    }
    
}