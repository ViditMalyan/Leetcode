class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();

        int day = 0;

        while (day < n) {
            String state = Arrays.toString(cells);

            if (seen.containsKey(state)) {
                int previousDay = seen.get(state);
                int cycleLength = day - previousDay;
                int remainingDays = (n - day) % cycleLength;

                for (int i = 0; i < remainingDays; i++) {
                    cells = nextDay(cells);
                }
                return cells;
            }

            seen.put(state, day);
            cells = nextDay(cells);
            day++;
        }
        return cells;
    }

    public int[] nextDay(int[] cells) {

        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                next[i] = 1;
            }
        }
        return next;
    }
}