import java.util.*;

public class KruskalsAlgorithm {

    static class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that)
        {
            return this.weight - that.weight;
        }
    }
    
    int[] rank, parent;

    int find(int vertex)
    {
        if (parent[vertex] == vertex)
            return vertex;
        
        return find(parent[vertex]);
    }

    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] > rank[rootY])
        {
            parent[rootY] = rootX;
        }
        else if (rank[rootY] > rank[rootX])
        {
            parent[rootX] = rootY; 
        }
        else 
        {
            parent[rootY] = rootX;
            rank[rootX] = rank[rootX] + 1;
        }
    }

    int spanningTreeCost(int vertex, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        boolean[][] added = new boolean[vertex][vertex];
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++)
        {
            for (int j = 0; j < adj.get(i).size(); j++)
            {
                ArrayList<Integer> current = adj.get(i).get(j);

                if (!added[i][current.get(0)])
                {
                    added[i][current.get(0)] = true;
                    added[current.get(0)][i] = true;
                    edges.add(new Edge(i, current.get(0), current.get(1)));
                }
            }
        }

        rank = new int[vertex];
        parent = new int[vertex];

        for (int i = 0; i < vertex; i++)
        {
            parent[i] = i;
        }

        Collections.sort(edges);

        int count = 1;
        int minCost = 0;

        for (int i = 0; count < vertex; i++)
        {
            Edge currentEdge = edges.get(i);

            int rootX = find(currentEdge.src);
            int rootY = find(currentEdge.dest);

            if (rootX != rootY)
            {
                union(rootX, rootY);
                count++;
                minCost += currentEdge.weight;
            }
        }

        return minCost;
    }

}
