class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] first = new int[26];
        int[] second = new int[26];

        int INF = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            first[i] = INF;
            second[i] = INF;
        }

        // Find the two closest points for each tag
        for (int i = 0; i < points.length; i++) {

            int dist = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));

            int index = s.charAt(i) - 'a';

            if (dist < first[index]) {
                second[index] = first[index];
                first[index] = dist;
            } else if (dist < second[index]) {
                second[index] = dist;
            }
        }

        // Smallest second occurrence is the limiting distance
        int limit = INF;

        for (int i = 0; i < 26; i++) {
            limit = Math.min(limit, second[i]);
        }

        // Boundary is NOT allowed to contain a duplicate,
        // so distance must be strictly less than limit.
        int answer = 0;

        for (int i = 0; i < points.length; i++) {
            int dist = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            if (dist < limit) {
                answer++;
            }
        }

        return answer;
    }
}