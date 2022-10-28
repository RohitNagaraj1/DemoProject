import java.util.Scanner;

public class Maximum {

    public static int MaximumProduct(int[] nums)
    {
        if (nums.length == 1)
            return nums[0];

        int negativeCount = 0;
        int negativeProduct = 1;
        int positiveProduct = 1;
        int zeroCount = 0;
        int minPositive = Integer.MAX_VALUE;
        int minNegative = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0)
            {
                negativeCount++;
                negativeProduct *= nums[i];
                minNegative = Math.min(minNegative, Math.abs(nums[i]));
            }

            if (nums[i] > 0)
            {
                positiveProduct *= nums[i];
                minPositive = Math.min(minPositive, nums[i]);
            }
            
            if (nums[i] == 0)
            {
                zeroCount++;
            } 
        }

        if (zeroCount == nums.length)
        {
            return 0;
        }

        if (negativeCount % 2 == 1)
        {
            return (-1) * positiveProduct * negativeProduct / minNegative;
        }

        return positiveProduct * negativeProduct;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        //int[] nums = { -1, 0, -2, 0};
        String[] number = sc.nextLine().split(" ");
        int[] nums = new int[number.length];

        for (int i = 0; i < number.length; i++)
        {
            nums[i] = Integer.parseInt(number[i]);
        }

        System.out.println(MaximumProduct(nums));
    }
}
