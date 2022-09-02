package backtrack;

import java.util.*;

/**
 * 全排列
 *
 * @author lzh
 * @create 2022/9/2 10:31
 */
public class Permute {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        // 记录选择路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径  记录在track中
     * 选择列表  nums中不存在于track中的那些元素
     * 结束条件： nums中所有元素均出现在track中
     *
     * @param nums
     * @param track
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        //终止条件
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //数字不能重复选择  排除非法选择
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }

    }

//    private static void backtrack(int[] nums, List<List<Integer>> res, Stack<Integer> path, boolean[] used) {
//        if (path.size() == nums.length) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i]) continue; //选过了就不用了
//            //做选择；
//            path.push(nums[i]);
//            used[i] = true;
//            //递归：开始下一轮选择；
//            backtrack(nums, res, path, used);
//            //撤销选择：回溯；
//            path.pop();
//            used[i] = false;
//        }
//    }


    /**
     * 全排列  包含重复数字
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute2(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, track, used);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            if(used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i]=true;
            backtrack(nums,track, used);
            track.removeLast();
            used[i]=false;
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, path, used);
        return res;
    }
    private static void backtrack(int[] nums, List<List<Integer>> res, Stack<Integer> path, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;   //树层不能选一样的；
            }
            if(used[i]) continue;  //同一树枝上去重；
            //做选择；
            path.push(nums[i]);
            used[i] = true;
            //递归：开始下一轮选择；
            backtrack(nums, res, path, used);
            //撤销选择：回溯；
            path.pop();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        System.out.println(permuteUnique(nums));
    }


}
