public class BracketsBalance 
{
    static int minimumSwap(String S)
    {
        char[] chars = S.toCharArray();
        int imbalance = 0;
        int swap = 0;
        
        int leftCount = 0, rightCount = 0;
        
        for (char ch : chars)
        {
            if (ch == '[')
            {
                leftCount++;
                
                if (imbalance > 0)
                {
                    swap += imbalance;
                    imbalance--;
                }
            }
            else
            {
                rightCount++;
                imbalance = rightCount - leftCount;
            }
        }
        
        return swap;
    }

    public static void main(String[] args) 
    {
        System.out.println("[]][][");
        System.out.println(minimumSwap("[]][]["));
    }
}
