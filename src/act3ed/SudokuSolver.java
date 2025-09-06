package act3ed;

/**
 * Problema 3: Resolver Sudoku con backtracking.
 * Tablero 9x9 con 0 representando celdas vacías.
 */
public final class SudokuSolver {
    private SudokuSolver() {}

    public static boolean solve(int[][] board) {
        // Buscar la siguiente celda vacía
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    for (int d = 1; d <= 9; d++) {
                        if (isSafe(board, r, c, d)) {
                            board[r][c] = d;
                            if (solve(board)) return true; // siguiente
                            board[r][c] = 0; // backtrack
                        }
                    }
                    return false; // no hay dígito válido aquí
                }
            }
        }
        return true; // sin vacíos: resuelto
    }

    public static boolean isSafe(int[][] board, int row, int col, int val) {
        // Fila y columna
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
            if (board[i][col] == val) return false;
        }
        // Subcuadro 3x3
        int br = (row / 3) * 3;
        int bc = (col / 3) * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[br + r][bc + c] == val) return false;
            }
        }
        return true;
    }

    public static String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) sb.append("+-------+-------+-------+\n");
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) sb.append("| ");
                sb.append(board[r][c] == 0 ? "." : Integer.toString(board[r][c])).append(' ');
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+\n");
        return sb.toString();
    }
}
