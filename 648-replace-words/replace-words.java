class Solution {
    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        boolean isEnd;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        TrieNode root = new TrieNode();

        // Build Trie
        for (String rootWord : dictionary) {
            insert(root, rootWord);
        }

        StringBuilder answer = new StringBuilder();

        for (String word : sentence.split(" ")) {

            if (answer.length() > 0) {
                answer.append(" ");
            }

            answer.append(findRoot(root, word));
        }

        return answer.toString();
    }

    public void insert(
            TrieNode root,
            String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public String findRoot(
            TrieNode root,
            String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];

            if (current.isEnd) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}