class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // Choose the first number
        for (int i = 1; i <= n - 2; i++) {

            // Leading zero
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            String first = num.substring(0, i);

            // Choose the second number
            for (int j = i + 1; j <= n - 1; j++) {

                // Leading zero
                if (num.charAt(i) == '0' && j - i > 1) {
                    break;
                }

                String second = num.substring(i, j);

                if (isValidSequence(
                        num,
                        j,
                        first,
                        second,
                        2)) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean isValidSequence(
            String num,
            int index,
            String first,
            String second,
            int count) {

        // We used the entire string
        if (index == num.length()) {
            return count >= 3;
        }

        String sum = addStrings(first, second);

        // The next part must equal first + second
        if (!num.startsWith(sum, index)) {
            return false;
        }

        return isValidSequence(
                num,
                index + sum.length(),
                second,
                sum,
                count + 1
        );
    }

    public String addStrings(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 10);

            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}