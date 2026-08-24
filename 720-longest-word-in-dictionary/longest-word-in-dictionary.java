class Solution {
    public String longestWord(String[] words) {
        
       Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        Set<String> buildable = new HashSet<>();

        String answer = "";

        for (String word : words) {

            String prefix =
                word.substring(0, word.length() - 1);

            if (word.length() == 1 ||
                buildable.contains(prefix)) {
                buildable.add(word);

                if (word.length() > answer.length()) {
                    answer = word;
                }
            }
        }
        return answer; 
    }
}