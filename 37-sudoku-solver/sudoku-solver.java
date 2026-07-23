class Solution {

    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[] boxes = new HashSet[9];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        //Fill existing numbers
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {

                    char num = board[row][col];

                    rows[row].add(num);
                    cols[col].add(num);

                    int box = (row / 3) * 3 + (col / 3);
                    boxes[box].add(num);
                }
            }
        }
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    int box = (row / 3) * 3 + (col / 3);

                    for(char num = '1'; num <= '9'; num++){
                         if (!rows[row].contains(num) &&
                            !cols[col].contains(num) &&
                            !boxes[box].contains(num)) {

                            board[row][col] = num;

                            rows[row].add(num);
                            cols[col].add(num);
                            boxes[box].add(num);

                            if (solve(board))
                                return true;

                            board[row][col] = '.';

                            rows[row].remove(num);
                            cols[col].remove(num);
                            boxes[box].remove(num);
                        }    
                    }
                    return false;
                }
            }
        }
        return true;
    }
}