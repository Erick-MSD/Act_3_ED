package act3ed;

import java.util.HashMap;
import java.util.Map;

/**
 * Problema 1: Serie de Fibonacci (recursiva).
 * Incluye versión recursiva directa y versión con memoización.
 */
public final class Fibonacci {
    private Fibonacci() {}

    // Recursividad directa (O(phi^n)).
    public static long fibRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Versión con memoización (O(n)).
    public static long fibMemo(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        return fibMemo(n, new HashMap<>());
    }

    private static long fibMemo(int n, Map<Integer, Long> memo) {
        if (n <= 1) return n;
        Long cached = memo.get(n);
        if (cached != null) return cached;
        long ans = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, ans);
        return ans;
    }
}
