class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> answer = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse top row
            for (int col = left; col <= right; col++) {
                answer.add(matrix[top][col]);
            }
            top++;

            // Traverse right column
            for (int row = top; row <= bottom; row++) {
                answer.add(matrix[row][right]);
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    answer.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    answer.add(matrix[row][left]);
                }
                left++;
            }
        }

        return answer;
    }
}