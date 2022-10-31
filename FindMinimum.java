public class FindMinimum
{
    public static void main(String[] args) 
    {
        int[] arr = {6, 1, 2, 3, 4, 5};
        System.out.println(findMin(arr)); 
    }

    public static int findMin(int[] a) 
    { 
        int low = 0;
        int high = a.length - 1;
        while (low < high)
        {
            int mid = low + (high-low)/2;
            if (a[mid] > a[high])
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
  
        return a[low];
    } 
}
