class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        // Convert time strings into minutes
        for (String time : timePoints) {
            String[] parts = time.split(":");

            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);
            minutes.add(hours * 60 + mins);
        }

        // Sort the converted times
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;
        int n = minutes.size();

        // Compare adjacent time points
        for (int i = 1; i < n; i++) {
            int diff = minutes.get(i) - minutes.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }

        // Compare last time with first time across midnight
        int circularDiff = 1440 - minutes.get(n - 1) + minutes.get(0);
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }
}