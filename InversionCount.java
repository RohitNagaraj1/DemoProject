import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {
    class SegmentTree
    {
        int[] st;
        int n;

        public void build(int n)
        {
            this.n = n;
            st = new int[4*n];
        }

        public void Update(int index, int value)
        {
            Update(0, n-1, 0, index, value);
        }

        private void Update(int start, int end, int node, int index, int value)
        {
            if (index < start || index > end)
            {
                return;
            }

            if (start == end)
            {
                st[node] = value;
                return;
            }

            st[node] = st[node] + value;
            if (start != end) 
            {
                int mid = start + (end - start) / 2;
                Update(start, mid, 2 * node + 1, index, value);
                Update(mid + 1, end, 2 * node + 2, index, value);
            }

            st[node] = st[2 * node + 1] + st[2 * node + 2];
        }

        public int Query(int left, int right)
        {
            return Query(0, n-1, left, right, 0);
        }

        private int Query(int start, int end, int left, int right, int node)
        {
            if (start > right || left > end)
                return 0;

            if (start >= left && end <= right)
                return st[node];
            
            int mid = start + (end-start)/2;

            int query1 = Query(start, mid, left, right, 2*node+1);
            int query2 = Query(mid+1, end, left, right, 2*node+2);

            return query1 + query2;
        }
    }

    class Pair
    {
        public int value;
        public int index;
        public Pair(int index, int value)
        {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int size = sc.nextInt();
        Pair[] pairs = new Pair[size];
        InversionCount ic = new InversionCount();

        for (int i = 0; i < strs.length; i++)
        {
            int value = Integer.parseInt(strs[i]);
            pairs[i] = ic.new Pair(i, value);
        }

        Arrays.sort(pairs, (a, b) -> a.value - b.value);
        SegmentTree st = ic.new SegmentTree();
        st.build(size);

        int count = 0;

        for (int i = 0; i < pairs.length; i++)
        {
            Pair current = pairs[i];
            st.Update(current.index, 1);
            count += st.Query(current.index+1, size-1);
        }

        System.out.println(count);
    }
}
