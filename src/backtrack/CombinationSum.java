package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target 。
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。  对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * @author Lizihao
 * @create 2022/9/2 14:33
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        final int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backtrack(candidates, target, 0, 0, res, path);
        return res;
    }

    private static void backtrack(int[] candidates, int target, int sum, int begin, List<List<Integer>> res, Stack<Integer> path) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            sum += candidates[i];
            path.push(candidates[i]);
            backtrack(candidates, target, sum, i, res, path);
            sum -= candidates[i];
            path.pop();
        }
    }
}
