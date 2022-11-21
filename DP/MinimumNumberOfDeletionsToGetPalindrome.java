public class MinimumNumberOfDeletionsToGetPalindrome {
    static int minDeletions(String str, int n)
    {
        // code here
        char[] s1 = str.toCharArray();
        char[] s2 = new StringBuilder(str).reverse().toString().toCharArray();
        
        
        int[][] dp = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
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
        
        return n - dp[n][n];
        
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aebcbda", 7));
        System.out.println(minDeletions("aba", 3));
    }
}
