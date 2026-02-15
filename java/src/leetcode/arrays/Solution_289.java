package leetcode.arrays;

//  给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
//  每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
//
//    如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//    如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//    如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//    如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
//    下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是 同时 发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
//
//    给定当前 board 的状态，更新 board 到下一个状态。
//
//     注意 你不需要返回任何东西。

import java.util.ArrayList;
import java.util.List;

public class Solution_289 {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] nextState = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                nextState[i][j] = getNextState(board, i, j);
            }
        }

        for(int i = 0; i < rows; i++){
            System.arraycopy(nextState[i], 0, board[i], 0, cols);
        }
    }

    // 返回（i, j）的下一个状态
    public int getNextState(int[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        // 获取所有 neighbors
        List<Integer> neighbors = new ArrayList<>();
        for(int r = i - 1; r < i + 2; r++){
            for(int c = j - 1; c < j + 2; c++){
                if (r >= 0 && r < rows && c >= 0 && c < cols && !(r == i && c == j)) {
                    neighbors.add(board[r][c]);
                }
            }
        }

        int liveNums = 0;
        for(int neighbor : neighbors){
            if(neighbor == 1)
                liveNums++;
        }

        if (board[i][j] == 1)
            return (liveNums == 2 || liveNums == 3) ? 1 : 0;
        else
            return liveNums == 3 ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
