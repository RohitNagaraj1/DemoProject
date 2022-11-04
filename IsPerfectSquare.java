import java.util.Scanner;

public class IsPerfectSquare
{
    public static boolean CheckIsPerfectSquare(int num)
    {
        int low = 1;
        int high = num;

        while (low <= high)
        {
            int mid = low + (high-low)/2;

            if (mid*mid == num)
                return true;
            
            if (mid*mid > num)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(CheckIsPerfectSquare(num));
    }
}