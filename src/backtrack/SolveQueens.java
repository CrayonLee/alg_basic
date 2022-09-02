package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后问题  回溯解法
 *
 * @author Lizihao
 * @create 2022/9/2 16:50
 */
public class SolveQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] path = new char[n][n];
        for (char[] chars : path) Arrays.fill(chars, '.');
        backtrack(n, 0, res, path);
        return res;
    }

    private static void backtrack(int n, int row, List<List<String>> res, char[][] path) {
        if (row == n) {
            res.add(toList(n, path));
            return;
        }

        for (int col = 0; col < n; col++)
            if (isValid(path, row, col, n)) {
                path[row][col] = 'Q';
                backtrack(n, row + 1, res, path);
                path[row][col] = '.';
            }

    }

    private static List<String> toList(int n, char[][] path) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) ans.add(String.valueOf(path[i]));
        return ans;
    }

    /**
     * 检查row,col位置能否放皇后
     *
     * @param path
     * @param row
     * @param col
     * @param n
     * @return
     */
    private static boolean isValid(char[][] path, int row, int col, int n) {
        //检查列
        for (int i = 0; i < n; i++) if (path[row][col] == 'Q') return false;
        //检查45度
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (path[row][col] == 'Q') return false;
        //检查135度
        for (int i = row - 1, j = col + 1; i >= 0 && j < n >; i--, j++) if (path[row][col] == 'Q') return false;
        return true;
    }


}
