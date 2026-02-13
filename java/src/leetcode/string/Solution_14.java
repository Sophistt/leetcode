package leetcode.string;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//
//
//示例 1：
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//示例 2：
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。

public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {return strs[0];}
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.isEmpty())
                break;
        }
        return commonPrefix;
    }

    public String getCommonPrefix(String strs1, String strs2) {
        int idx = 0;
        StringBuilder commonPrefix = new StringBuilder();
        while (idx < strs1.length() && idx < strs2.length()) {
            if (strs1.charAt(idx) == strs2.charAt(idx)) {
                commonPrefix.append(strs1.charAt(idx));
            } else {
                break;
            }
            idx++;
        }
        return commonPrefix.toString();
    }
}