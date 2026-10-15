class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        boolean[] used = new boolean[n];
        int bulls = 0;
        int cows = 0;

        // Count bulls
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                used[i] = true;
            }
        }

        // Count cows
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (!used[j] &&
                    secret.charAt(j) == guess.charAt(i)) {
                    cows++;
                    used[j] = true;
                    break;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}