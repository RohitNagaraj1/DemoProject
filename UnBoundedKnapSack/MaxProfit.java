package UnBoundedKnapSack;

public class MaxProfit
{
    public int Profit(int[] wt, int[] profit, int mw, int n)
    {
        if (n == 0 || mw == 0)
            return 0;
        
        if (wt[n-1] > mw)
            return Profit(wt, profit, mw, n-1);
        
        int reducesWeight = mw - wt[n-1];
        int ans = Math.max(Profit(wt, profit, mw, n-1), profit[n-1] + Profit(wt, profit, reducesWeight, n));

        return ans;
    }

    public static void main(String[] args) {
        
    }
}