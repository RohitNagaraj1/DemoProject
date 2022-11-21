import java.util.*;

public class MinimumNumberOfDeletionsAndInsertions {

    public static int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    char[] x = str1.toCharArray();
	    char[] y = str2.toCharArray();
	    
	    int[][] dp = new int[x.length+1][y.length+1];
	    
	    for (int i = 1; i <= x.length; i++)
	    {
	        for (int j = 1; j <= y.length; j++)
	        {
	            if (x[i-1] == y[j-1])
	            {
	                dp[i][j] = 1 + dp[i-1][j-1];
	            }
	            else
	            {
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	    }
	    
	    int insertion = y.length - dp[x.length][y.length];
	    int deletion = x.length - dp[x.length][y.length];
	    
	    return insertion + deletion;
	}
    
    public static void main(String[] args) {
        System.out.println(minOperations("geeksforgeeks", "geeks"));
        System.out.println(minOperations("heap", "pea"));
    }
}
