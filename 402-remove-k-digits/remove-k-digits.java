class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {

            while (
                k > 0 && !stack.isEmpty() && stack.peekLast() > digit
            ) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder result = new StringBuilder();

        boolean leadingZero = true;

        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            result.append(digit);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}