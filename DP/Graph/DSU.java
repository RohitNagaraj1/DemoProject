import java.util.*;

public class DSU 
{
    int noOfVertices;
    LinkedList<Integer> adj[];

    public DSU(int noOfVertices) 
    {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];

        for (int i = 0; i < noOfVertices; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int source, int dest)
    {
        LinkedList<Integer> sourceList = adj[source];
        sourceList.add(dest);
    }

    int find(int current, int[] parent)
    {
        if (parent[current] == current)
            return current;
        
        return find(parent[current], parent);
    }

    void union(int x, int y, int[] parent)
    {
        parent[x] = y;
    }

    boolean isCycle()
    {
        int[] parent = new int[noOfVertices];

        for (int i = 0; i < noOfVertices; i++)
            parent[i] = i;
        
        for (int source = 0; source < noOfVertices; source++)
        {
            for (Integer dest : adj[source])
            {
                int x = find(source, parent);
                int y = find(dest, parent);

                if (x == y)
                    return true;
                
                union(x, y, parent);
            }
        }

        return false;
    }


    public static void main(String[] args) 
    {
        DSU dsu = new DSU(3);
        dsu.addEdge(0, 1);
        dsu.addEdge(1, 2);
        //dsu.addEdge(2, 0);

        System.out.println(dsu.isCycle());
    }
}
