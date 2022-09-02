package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * @author lzh
 * @create 2022/9/2 14:01
 */
public class Combine {
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k < 0 || k > n) return res;
        Stack<Integer> path = new Stack<>();
        backtrack(n, k, 1, path, res);
        return res;
    }

    private static void backtrack(int n, int k, int begin, Stack<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

//        for (int i = begin; i <= n; i++) {
//            path.push(i);
//            backtrack(n, k, i + 1, path, res);
//            path.pop();
//        }
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            backtrack(n, k, i + 1, path, res);
            path.pop();
        }
    }


    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
