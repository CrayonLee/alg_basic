package binary_search;

/**
 * @author Lizihao
 * @create 2022/9/5 17:27
 */
public class BinarySearch {
    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] == target) return mid;
        }
        return -1;
    }

    static int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] == target) right = mid - 1;
        }

        //最后需要检查left是否越界
        if (left >= nums.length || nums[left] != target) return -1;
        return left;
    }

    static int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] == target) left = mid + 1;
        }
        //检查right是否越界
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }
}
