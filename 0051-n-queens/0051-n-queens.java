import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); // Cleaner way to fill the array
        }
        
        // Tracking arrays for O(1) lookups
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; 
        boolean[] diag2 = new boolean[2 * n]; 
        
        backtrack(results, board, 0, n, cols, diag1, diag2);
        return results;
    }
    
    private void backtrack(List<List<String>> res, char[][] board, int row, int n, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // Base case: all queens are placed
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (char[] r : board) {
                current.add(new String(r));
            }
            res.add(current);
            return;
        }
        
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // Formula for top-left to bottom-right diagonal
            int d2 = row + col;     // Formula for top-right to bottom-left diagonal
            
            // If the column or either diagonal is already occupied, skip
            if (cols[col] || diag1[d1] || diag2[d2]) continue;
            
            // Place the queen and mark the column/diagonals as attacked
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;
            
            // Recurse to the next row
            backtrack(res, board, row + 1, n, cols, diag1, diag2);
            
            // Backtrack: remove the queen and unmark the column/diagonals
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}