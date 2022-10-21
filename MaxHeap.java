import java.util.Scanner;

public class MaxHeap
{
    int maxSize;
    int currentSize;
    int[] nums;

    public MaxHeap(int size)
    {
        this.maxSize = size;
        this.currentSize = 0;
        this.nums = new int[size];
    }

    public void Hepify(int n, int index)
    {
        int largestIndex = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        if (left <= n && nums[left] > nums[largestIndex])
            largestIndex = left;

        if (right <= n && nums[right] > nums[largestIndex])
            largestIndex = right;

        if (index != largestIndex)
        {
            Swap(index, largestIndex);
            Hepify(n, largestIndex);
        }
    }

    public void Print()
    {
        for (int i = 0; i < this.currentSize ; i++)
        {
            System.out.print(this.nums[i] + "   ");
        }
        System.out.println();
    }

    public void Hepify(int[] nums, int size)
    {
        this.currentSize = size;
        //this.nums = Arrays.copyOf(nums, size);
        for (int i = 0; i < size; i++)
        {
            this.nums[i] = nums[i];
        }
        for (int i = size/2; i >= 0; i--)
        {
            Hepify(size, i);
        }
    }

    public void Swap(int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void Insert(int newValue)
    {
        if (currentSize < maxSize)
        {
            
            nums[currentSize] = newValue;
            int i = currentSize;
            while (i > 0)
            {
                int parent = i/2;
                if (nums[i] > nums[parent])
                {
                    Swap(parent, i);
                    i = parent;
                }
                else
                    return;
            }
            currentSize++;
        } 
    }

    public void Delete()
    {
        if (currentSize > 0)
        {
            nums[0] = nums[currentSize-1];
            currentSize--;
            int i = 0;
            while (i < currentSize)
            {
                int largestIndex = i;
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                
                if (left <= currentSize && nums[left] > nums[largestIndex])
                    largestIndex = left;
        
                if (right <= currentSize && nums[right] > nums[largestIndex])
                    largestIndex = right;
        
                if (i != largestIndex)
                {
                    Swap(i, largestIndex);
                    Hepify(currentSize, largestIndex);
                    i = largestIndex;
                }
                else
                    return;
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int size = sc.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < strs.length; i++)
        {
            nums[i] = Integer.parseInt(strs[i]);
        }
        
        MaxHeap mh = new MaxHeap(size);
        mh.Hepify(nums, strs.length);
        mh.Print();

        for (int i = mh.currentSize; i < size; i++)
        {
            mh.Insert(i);
        }
        mh.Print();
        mh.Delete();
        mh.Print();
    }
}