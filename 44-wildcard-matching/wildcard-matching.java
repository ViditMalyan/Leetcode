class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;

        int star = -1;
        int match = 0;

        while (i < s.length()) {
            // Characters match, or pattern has '?'
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            // Remember the latest '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }
            // Retry by making '*' match one more character
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }
            // No match and no previous '*' to retry
            else {
                return false;
            }
        }

        // Remaining pattern characters must all be '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}