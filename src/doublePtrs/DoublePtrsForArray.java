package doublePtrs;

import java.util.Arrays;

public class DoublePtrsForArray {
    // LeetCode 26
    // 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序
    // 应该保持 一致 。然后返回 nums 中唯一元素的个数。
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast]; // slow 指向的第一个元素肯定是非重复的，因此需要先偏移再赋值
            }
            fast++;
        }
        return slow + 1;
    }

    // LeetCode 27
    // 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。
    // 然后返回 nums 中与 val 不同的元素的数量。
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast]; // 遇到不等于 val 的第一个值，先赋值给 num[slow]，然后 slow++
            }
            fast++;
        }
        return slow + 1;
    }

    // LeetCode 283
    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

    // LeetCode 344
    // 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
    // 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        char temp;
        while (start < end) {
            temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    // LeetCode 167 TwoSum
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start+1, end+1};
            }
            if (sum < target) {
                start++;
            }
            if (sum > target) {
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    // LeetCode 5
    // 以 l, r 为起点，找到 s 中最长的回文串
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    // 给你一个字符串 s，找到 s 中最长的 回文子串
    // 解法：遍历 s，调用 palindrome 找到以每个 index 为起点的最长回文串，刷新结果
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //977. 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        return Arrays.stream(res).sorted().toArray();
    }

    // 151. 反转字符串中的单词 -> 用处理字符串的思路来解决问题
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
//        for (String string : strings) {
//            sb.append(new StringBuilder(string).reverse().toString()).append(" ");
//        }
        for (int i = strings.length - 1; i > 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().strip();
    }
}
