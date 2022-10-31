import java.util.Scanner;
import java.util.*;

public class JobSequencing {

    class JobDetails
    {
        public int id;
        public int deadLine;
        public int profit;

        public JobDetails(int id, int deadLine, int profit)
        {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }
    }

    public static int MaxProfit(int[] id, int[] deadLine, int[] profit)
    {
        JobDetails[] jobs = new JobDetails[id.length];
        JobSequencing js = new JobSequencing();
        for (int i = 0; i < jobs.length; i++)
        {
            jobs[i] = js.new JobDetails(id[i], deadLine[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> {
            return b.profit - a.profit;
        });

        HashSet<Integer> hset = new HashSet();
        int max = 0;

        for (int i = 0; i < jobs.length; i++)
        {
            if (!hset.contains(jobs[i].deadLine))
            {
                hset.add(jobs[i].deadLine);
                max += jobs[i].profit;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] ids = sc.nextLine().split(" ");
        int size = ids.length;

        
        int[] id = new int[size];
        for (int i = 0; i < size; i++)
        {
            id[i] = Integer.parseInt(ids[i]);
        }

        String[] deadLines = sc.nextLine().split(" ");
        int[] deadLine = new int[size];
        for (int i = 0; i < size; i++)
        {
            deadLine[i] = Integer.parseInt(deadLines[i]);
        }

        String[] profits = sc.nextLine().split(" ");
        int[] profit = new int[size];
        for (int i = 0; i < size; i++)
        {
            profit[i] = Integer.parseInt(profits[i]);
        }

        System.out.println(MaxProfit(id, deadLine, profit));
    }
}
