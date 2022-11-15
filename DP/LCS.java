import java.util.Arrays;

public class LCS
{
    public static int LCSRecusion(char[] s1, char[] s2, int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
        
        if (s1[m-1] == s2[n-1])
            return 1 + LCSRecusion(s1, s2, m-1, n-1);

        return Math.max(LCSRecusion(s1, s2, m-1, n), LCSRecusion(s1, s2, m, n-1));
        
    }

    public static int LCSMemoization(char[] s1, char[] s2, int m, int n, int[][] dp)
    {
        if (m == 0 || n == 0)
            return 0;
        
        if (dp[m][n] != -1)
            return dp[m][n];
        
        if (s1[m-1] == s2[n-1])
            return 1 + LCSMemoization(s1, s2, m-1, n-1, dp);

        dp[m][n] = Math.max(LCSMemoization(s1, s2, m-1, n, dp), LCSMemoization(s1, s2, m, n-1, dp));

        return dp[m][n];
        
    }

    // 0 0 0 0 
    // 0 1 0 0
    // 0 0 0 0 

    public static int LCSTabulation(char[] s1, char[] s2, int m, int n)
    {
        int[][] dp = new int[s1.length+1][s2.length+1];

        for (int i = 1; i <= s1.length; i++)
        {
            for (int j = 1; j <= s2.length; j++)
            {
                if (s1[i-1] == s2[j-1])
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for (int i = 0; i <= s1.length; i++)
        {
            for (int j = 0; j <= s2.length; j++)
            {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }

        return dp[s1.length][s2.length];
        
    }

    public static void main(String[] args) {
        String s1 = "ABCS";
        String s2 = "ABS";

        int result = LCSRecusion(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println("Recursion   " + result);

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int[] rows : dp)
        {
            Arrays.fill(rows, -1);
        }

        result = LCSMemoization(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), dp);
        System.out.println("Memoization   " + result);

        result = LCSTabulation(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println("Tabulation   " + result);
    }
}