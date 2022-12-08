import java.util.*;

public class PrimsAlgorithm
{
    int spanningTreeCost(int vertex, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        boolean[] visited = new boolean[vertex];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0));
        int minCost = 0;

        while (queue.size() > 0)
        {
            Pair curPair = queue.poll();
            int curVertex = curPair.vertex;

            if (visited[curVertex])
                continue;
            
            visited[curVertex] = true;
            minCost += curPair.weight;

            ArrayList<ArrayList<Integer>> neighbours = adj.get(curVertex);
            for (ArrayList<Integer> eachNeighbours : neighbours)
            {
                int eachNeighbourVertex = eachNeighbours.get(0);
                int eachNeighbourWeight = eachNeighbours.get(1);

                if (!visited[eachNeighbourVertex])
                {
                    queue.add(new Pair(eachNeighbourVertex, eachNeighbourWeight));
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        
    }
}