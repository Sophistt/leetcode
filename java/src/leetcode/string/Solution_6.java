package leetcode.string;

//    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
// 示例 1：
//    输入：s = "PAYPALISHIRING", numRows = 3
//    输出："PAHNAPLSIIGYIR"
// 示例 2：
//    输入：s = "PAYPALISHIRING", numRows = 4
//    输出："PINALSIGYAHRPI"
//    解释：
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I
// 示例 3：
//    输入：s = "A", numRows = 1
//    输出："A"

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        int idx = 1;
        int direction = 1;
        for (char c : s.toCharArray()) {
            map.computeIfAbsent(idx, v -> new ArrayList<>()).add(String.valueOf(c));
            idx += direction;
            if(idx == 1 || idx == numRows)
                direction = -direction;
        }
        StringBuilder sb = new StringBuilder();
        map.values().forEach(list -> sb.append(String.join("", list)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_6 sol = new Solution_6();
        System.out.println(sol.convert("PAYPALISHIRING", 3));
    }
}
