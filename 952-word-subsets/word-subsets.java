class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> result = new ArrayList<>();
        int[] required = new int[26];

        // Build combined requirement from words2
        for (String word : words2) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                required[i] = Math.max(required[i], count[i]);
            }
        }

        // Check words1
        for (String word : words1) {
            int[] count = new int[26];

            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            boolean universal = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] < required[i]) {
                    universal = false;
                    break;
                }
            }

            if (universal) {
                result.add(word);
            }
        }
        return result;
    }
}