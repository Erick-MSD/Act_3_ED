package act3ed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problema 2: Subset Sum (recursivo + backtracking simple para reconstrucción).
 */
public final class SubsetSum {
    private SubsetSum() {}

    // Decide si existe un subconjunto que suma target.
    public static boolean existsSubsetSum(int[] nums, int target) {
        if (nums == null) throw new IllegalArgumentException("nums is null");
        return exists(nums, nums.length - 1, target);
    }

    private static boolean exists(int[] nums, int i, int target) {
        if (target == 0) return true;          // caso base: suma lograda
        if (i < 0 || target < 0) return false; // sin elementos o sobrepasó
        // Omitir elemento i
        if (exists(nums, i - 1, target)) return true;
        // Tomar elemento i
        return exists(nums, i - 1, target - nums[i]);
    }

    // Opcional: devuelve una solución (un subconjunto) si existe; si no, lista vacía.
    public static List<Integer> findOneSubsetSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        if (backtrack(nums, nums.length - 1, target, path)) {
            // path contiene elementos seleccionados en orden inverso del índice
            return path;
        }
        return List.of();
    }

    private static boolean backtrack(int[] nums, int i, int target, List<Integer> path) {
        if (target == 0) return true;
        if (i < 0 || target < 0) return false;
        // probar tomar nums[i]
        path.add(nums[i]);
        if (backtrack(nums, i - 1, target - nums[i], path)) return true;
        // retroceder
        path.remove(path.size() - 1);
        // probar omitir nums[i]
        return backtrack(nums, i - 1, target, path);
    }

    // Utilidad para mostrar subconjunto ordenado (no estrictamente necesario)
    public static String subsetToString(List<Integer> subset) {
        int[] arr = subset.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}
