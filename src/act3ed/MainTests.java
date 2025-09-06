package act3ed;

import java.util.List;

public class MainTests {
    public static void main(String[] args) {
        System.out.println("== Pruebas Act_3_ED ==");
        testFibonacci();
        testSubsetSum();
        testSudoku();
        System.out.println("Todas las pruebas finalizaron.");
    }

    private static void assertEquals(Object expected, Object actual, String msg) {
        if ((expected == null && actual != null) || (expected != null && !expected.equals(actual))) {
            throw new AssertionError(msg + " | esperado=" + expected + ", actual=" + actual);
        }
    }

    private static void assertTrue(boolean cond, String msg) {
        if (!cond) throw new AssertionError(msg);
    }

    private static void testFibonacci() {
        System.out.println("- Fibonacci");
        assertEquals(0L, Fibonacci.fibRecursive(0), "fib(0)");
        assertEquals(1L, Fibonacci.fibRecursive(1), "fib(1)");
        assertEquals(1L, Fibonacci.fibRecursive(2), "fib(2)");
        assertEquals(5L, Fibonacci.fibRecursive(5), "fib(5)");
        assertEquals(55L, Fibonacci.fibMemo(10), "fibMemo(10)");
        System.out.println("  OK");
    }

    private static void testSubsetSum() {
        System.out.println("- SubsetSum");
        int[] nums = {3, 34, 4, 12, 5, 2};
        assertTrue(SubsetSum.existsSubsetSum(nums, 9), "Existe subconjunto suma 9"); // 4+5
        assertTrue(!SubsetSum.existsSubsetSum(nums, 30), "No existe subconjunto suma 30");
        List<Integer> subset = SubsetSum.findOneSubsetSum(nums, 9);
        int sum = subset.stream().mapToInt(Integer::intValue).sum();
        assertEquals(9, sum, "Reconstrucción subconjunto suma 9");
        System.out.println("  OK");
    }

    private static void testSudoku() {
        System.out.println("- Sudoku");
        int[][] board = {
                {5,3,0, 0,7,0, 0,0,0},
                {6,0,0, 1,9,5, 0,0,0},
                {0,9,8, 0,0,0, 0,6,0},

                {8,0,0, 0,6,0, 0,0,3},
                {4,0,0, 8,0,3, 0,0,1},
                {7,0,0, 0,2,0, 0,0,6},

                {0,6,0, 0,0,0, 2,8,0},
                {0,0,0, 4,1,9, 0,0,5},
                {0,0,0, 0,8,0, 0,7,9}
        };
        boolean solved = SudokuSolver.solve(board);
        assertTrue(solved, "El sudoku debe ser resoluble");
        // validar filas/columnas básicas
        for (int i = 0; i < 9; i++) {
            boolean[] vRow = new boolean[10];
            boolean[] vCol = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int a = board[i][j];
                int b = board[j][i];
                assertTrue(a >= 1 && a <= 9, "Valor fuera de rango en fila");
                assertTrue(b >= 1 && b <= 9, "Valor fuera de rango en columna");
                assertTrue(!vRow[a], "Duplicado en fila " + i);
                assertTrue(!vCol[b], "Duplicado en columna " + i);
                vRow[a] = vCol[b] = true;
            }
        }
        System.out.println("  OK\n" + SudokuSolver.boardToString(board));
    }
}
