class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        Set<Integer> invalid = new HashSet<>();

        // Step 1: Find numbers that can never be good
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                invalid.add(fronts[i]);
            }
        }

        int answer = Integer.MAX_VALUE;

        // Step 2: Check all front numbers
        for (int num : fronts) {
            if (!invalid.contains(num)) {
                answer = Math.min(answer, num);
            }
        }

        // Step 3: Check all back numbers
        for (int num : backs) {
            if (!invalid.contains(num)) {
                answer = Math.min(answer, num);
            }
        }
        // Step 4: Return the answer
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}