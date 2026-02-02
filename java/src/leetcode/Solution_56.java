package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

    示例 1：

    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2：

    输入：intervals = [[1,4],[4,5]]
    输出：[[1,5]]
    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
    示例 3：

    输入：intervals = [[4,7],[1,4]]
    输出：[[1,7]]
    解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 **/

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        // 使用左端点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 创建一个新的 res 数组，里面插入结果
        List<int[]> res = new ArrayList<int[]>();
        res.add(intervals[0]);
        for(int [] num : intervals){
            int [] end = res.get(res.size() - 1);
            if (num[0] > end[1]) {
                res.add(num);
            } else {
                end[1] = Math.max(end[1], num[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    // Debug 结果
    public static void main(String[] args) {
        int [][] intervals = {{1,3}, {8,10}, {2,6}, {15, 18}};
        Solution_56 s = new Solution_56();
        int[][] res = s.merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
