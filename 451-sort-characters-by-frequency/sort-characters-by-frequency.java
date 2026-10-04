class Solution {
    public String frequencySort(String s) {
         // Step 1: Count frequency of every character
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create buckets
        List<Character>[] buckets = new ArrayList[s.length() + 1];

        for (char ch : frequency.keySet()) {
            int freq = frequency.get(ch);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }

        // Step 3: Build answer from highest frequency to lowest
        StringBuilder result = new StringBuilder();

        for (int freq = buckets.length - 1; freq >= 1; freq--) {
            if (buckets[freq] != null) {
                for (char ch : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}