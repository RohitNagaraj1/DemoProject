import java.util.Arrays;

public class CoinChange1 
{
    int[] coins;
    int N;
    long[][] dp;

    public long count(int coins[], int N, int sum) 
    {
        this.coins = coins;
        this.N = N;
        this.dp = new long[N+1][sum+1];
        
        for (long[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        
        return CoinChangeMemoization(0, sum);
    }
    
    public long CoinChangeMemoization(int index, int sum)
    {
        if (sum == 0)
        {
            return 1;
        }
        
        if (index == N)
        {
            return 0;
        }
        
        if (dp[index][sum] != -1)
        {
            return dp[index][sum];
        }
        
        long count = 0;
        
        if (coins[index] <= sum)
        {
            count += CoinChangeMemoization(index, sum-coins[index]);
        }
        
        count += CoinChangeMemoization(index+1, sum);
        
        dp[index][sum] = count;
        
        return count;
    }

    public long CoinChangeTabulation(int coins[], int N, int sum)
    {
        long[][] result = new long[N][sum+1];

        for (int i = 0; i < N; i++)
        {
            result[i][0] = 1;
        }

        for (int i = 0; i < N; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                result[i][j] += (i) > 0 ? result[i-1][j] : 0 ;                  // without considering current coin
                result[i][j] += (j-coins[i]) >= 0 ? result[i][j-coins[i]] : 0;  // with considering current coin
            }
        }

        return result[N-1][sum];
    }

    public static void main(String[] args) {
        CoinChange1 coinChange1 = new CoinChange1();
        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChange1.count(coins,coins.length, sum));
        System.out.println(coinChange1.CoinChangeTabulation(coins,coins.length, sum));

        int[] coins2 = {2, 5, 3, 6};
        sum = 10;

        System.out.println(coinChange1.count(coins2,coins2.length, sum));
        System.out.println(coinChange1.CoinChangeTabulation(coins2,coins2.length, sum));
    }
}
