package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 *
 * @author Lizihao
 * @create 2022/9/2 14:33
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        final int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        boolean[] used = new
                boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, res, path, used);
        return res;
    }

    private static void backtrack(int[] candidates, int target, int sum, int begin, List<List<Integer>> res, Stack<Integer> path, boolean[] used) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            sum += candidates[i];
            path.push(candidates[i]);
            used[i] = true;
            backtrack(candidates, target, sum, i + 1, res, path, used);
            sum -= candidates[i];
            path.pop();
            used[i] = false;
        }
    }
}
