class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean matches(String word, String pattern) {

        Map<Character, Character> patternToWord = new HashMap<>();
        Map<Character, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // Check pattern -> word
            if (patternToWord.containsKey(p) &&
                patternToWord.get(p) != w) {
                return false;
            }

            // Check word -> pattern
            if (wordToPattern.containsKey(w) &&
                wordToPattern.get(w) != p) {
                return false;
            }

            // Create mappings
            patternToWord.put(p, w);
            wordToPattern.put(w, p);
        }
        return true;
    }
}