class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> next = new ArrayList<>();

            // Generate odd numbers first
            for (int num : result) {
                int odd = 2 * num - 1;
                if (odd <= n) {
                    next.add(odd);
                }
            }

            // Generate even numbers next
            for (int num : result) {
                int even = 2 * num;
                if (even <= n) {
                    next.add(even);
                }
            }
            result = next;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}