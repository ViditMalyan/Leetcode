class Solution {
    public String removeDuplicateLetters(String s) {

        // Count how many times each character appears
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Keeps track of characters already in the stack
        boolean[] used = new boolean[26];

        // Stack to build the answer
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            // This character will no longer be available later
            count[index]--;

            // If already in our answer, skip it
            if (used[index]) {
                continue;
            }

            // Remove bigger characters if they appear again later
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                used[removed - 'a'] = false;
            }

            // Add current character
            stack.push(ch);
            used[index] = true;
        }

        // Convert stack into the answer
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }
        return result.toString();
    }
}