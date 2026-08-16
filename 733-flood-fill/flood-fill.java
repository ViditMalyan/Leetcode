class Solution {
    public int[][] floodFill(
        int[][] image,
        int sr,
        int sc,
        int color
    ) {

        int originalColor = image[sr][sc];

        // Nothing to change
        if (originalColor == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc});

        // Directions:
        // up, down, left, right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Change starting pixel immediately
        image[sr][sc] = color;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check boundaries
                if (newRow < 0 ||
                    newRow >= image.length ||
                    newCol < 0 ||
                    newCol >= image[0].length) {

                    continue;
                }

                // Check original color
                if (image[newRow][newCol] != originalColor) {
                    continue;
                }

                // Paint it
                image[newRow][newCol] = color;

                // Add it to the queue
                queue.offer(new int[]{
                    newRow,
                    newCol
                });
            }
        }

        return image;
    }
}