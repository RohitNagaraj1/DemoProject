import java.util.*;
import java.lang.*;

public class LexicographicallySmallestArray {

    public static int[] Smallest(int[] nums, int k)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int min = nums[i];
            int index = -1;

            for (int j = i+1; j < Math.min(nums.length, i + k+1); j++)
            {
                if (nums[j] < min)
                {
                    min = nums[j];
                    index = j;
                }
            }

            if (index != -1)
            {
                Swap(nums, i, index);
                k -= index - i;
            }
        }
        return nums;
    }

    public static void Swap(int[] nums, int i, int j)
    {
        for (int k = j; k > i; k--)
        {
            int temp = nums[k];
            nums[k] = nums[k-1];
            nums[k-1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ids = sc.nextLine().split(" ");
        
        int[] nums = new int[ids.length];
        for (int i = 0; i < ids.length; i++)
        {
            nums[i] = Integer.parseInt(ids[i]);
        }

        int k = sc.nextInt();
        int[] result = Smallest(nums, k);
        for (int item : result)
            System.out.print(item);
    }
}
