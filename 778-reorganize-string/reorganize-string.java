class Solution {
    public String reorganizeString(String s) {
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                maxHeap.offer(new int[] { i, frequency[i] });
            }
        }

        StringBuilder result = new StringBuilder();
        int[] previous = null;

        while (!maxHeap.isEmpty()) {

            int[] current = maxHeap.poll();

            result.append((char) (current[0] + 'a'));
            current[1]--;

            // Put the previously used character back
            // so it can be used now
            if (previous != null && previous[1] > 0) {
                maxHeap.offer(previous);
            }
            // Hold current character for one turn
            previous = current;
        }
        return result.length() == s.length()
                ? result.toString()
                : "";
    }
}