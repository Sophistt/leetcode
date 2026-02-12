package leetcode;

public class Solution_238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        // res[i] = nums[i] 左边所有元素的乘积 * nums[i] 右边所有元素的乘积

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++)
            res[i] = L[i] * R[i];

        return res;
    }

    public static void main(String[] args) {
        Solution_238 sol = new Solution_238();
    }
}
