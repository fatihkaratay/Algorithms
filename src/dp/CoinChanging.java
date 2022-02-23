package dp;

import java.util.Arrays;

/**
 * Coin Change - Print Count: Given a set of coin denominations, print out the number of ways you can
 * make a target amount. You can use as many coins of each denomination as you like.
 *
 * For example: If coins are [1,2,5] and the target is 5, the different ways are:
 *
 * [1,1,1,1,1]
 *
 * [1,1,1,2]
 *
 * [1,2,2]
 *
 * [5]
 *
 * The Output will be 4.
 */

public class CoinChanging {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
    }

    public static int coinChange(int[] coins, int total) {
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                } else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }

    // more clear and space efficient version
    public static int coinChange2(int[] coins, int total) {
        int[] dp = new int[total + 1];
        dp[0] = 1;

        for (int coin : coins)
            for (int i = coin; i < total + 1; i++)
                dp[i] = dp[i] + dp[i - coin];

        return dp[total];
    }
}
