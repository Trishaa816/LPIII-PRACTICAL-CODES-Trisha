import java.util.Scanner;

public class NQueens {

    // Check if it's safe to place a queen at (row, col)
    static boolean isSafe(int[] board, int row, int col) {
        int n = board.length;
        for (int r = 0; r < n; r++) {
            if (r == row) continue;
            int c = board[r];
            if (c == -1) continue;
            if (c == col || Math.abs(c - col) == Math.abs(r - row))
                return false;
        }
        return true;
    }

    // Recursive function to solve from a given row
    static boolean solveFromRow(int[] board, int start) {
        int n = board.length;
        int row = start;
        // Find next empty row
        while (row < n && board[row] != -1) {
            row++;
        }
        if (row == n) {
            return true; // all queens placed
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col; // place queen
                if (solveFromRow(board, row + 1)) {
                    return true;
                }
                board[row] = -1; // backtrack
            }
        }
        return false; // no valid placement
    }

    // Print the board
    static void printBoard(int[] board) {
        int n = board.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r] == c)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    // Main function to solve N-Queens with optional first queen
    static void nQueensWithFirst(int n, int firstRow, int firstCol) {
        int[] board = new int[n];
        for (int i = 0; i < n; i++) board[i] = -1;

        // Place first queen if coordinates are given
        if (firstRow != -1 && firstCol != -1) {
            if (!(0 <= firstRow && firstRow < n && 0 <= firstCol && firstCol < n)) {
                System.out.println("First queen coordinates out of range.");
                return;
            }
            board[firstRow] = firstCol;
            if (!isSafe(board, firstRow, firstCol)) {
                System.out.println("Pre-placed queen conflicts with another (invalid).");
                return;
            }
        }

        if (solveFromRow(board, 0)) {
            System.out.println("One valid " + n + "-Queens solution (respecting pre-placed queen):");
            printBoard(board);
        } else {
            System.out.println("No solution exists for the given pre-placement.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size n (e.g., 8): ");
        int n = sc.nextInt();

        System.out.print("Enter row of first queen (0-indexed) or -1 to skip: ");
        int fr = sc.nextInt();
        int fc = -1;
        if (fr != -1) {
            System.out.print("Enter column of first queen (0-indexed): ");
            fc = sc.nextInt();
        }

        nQueensWithFirst(n, fr, fc);
    }
}
