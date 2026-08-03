class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;

        for (int[] row : image) {

            // Step 1 : Reverse the row
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;

                left++;
                right--;
            }

            // Step 2 : Invert the row
            for (int i = 0; i < n; i++) {
                row[i] = (row[i] == 0) ? 1 : 0;
            }
        }

        return image;
    }
}