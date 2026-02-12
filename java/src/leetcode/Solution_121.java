package leetcode;

public class Solution_121 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[prices.length - 1];
    }

    public static  void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution_121().maxProfit(prices));
    }
}
