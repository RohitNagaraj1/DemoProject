import java.util.LinkedList;

public class DetectCycleInADirectedGraph 
{
    static int noOfVertices;
    LinkedList<Integer> adj[];

    public DetectCycleInADirectedGraph(int noOfVertices) 
    {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) 
        {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) 
    {
        DetectCycleInAGraph graph = new DetectCycleInAGraph(5);
        // graph.addEdge(0, 1);
        // graph.addEdge(2, 1); // not a cycle

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // cycle

        boolean result = false;
        int visited1[] = new int[noOfVertices + 1];
        for (int i = 0; i < noOfVertices; i++)
        {
            if (visited1[i] != 2)
            {
                result |= dfsFindCycleInDirectedGraph(i, graph.adj, visited1);
            }
        }
        System.out.println("Do we have cycle in the graph :- " + result);
    }

    public static boolean dfsFindCycleInDirectedGraph(int vertex, LinkedList<Integer> adj[], int visited[]) 
    {
        if (visited[vertex] == 1)
            return true;

        visited[vertex] = 1;

        LinkedList<Integer> vertexAdjacentNodes = adj[vertex];
        for (int node : vertexAdjacentNodes) 
        {
            if (visited[node] != 2) 
            {
                boolean findCycle = dfsFindCycleInDirectedGraph(node, adj, visited);
                if (findCycle) 
                {
                    return true;
                }
            }
        }
        visited[vertex] = 2;
        return false;
    }

    public void printGraphElements(LinkedList<Integer> adjList[]) 
    {
        for (int i = 0; i < adjList.length; i++) 
        {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjList[i].size(); j++) 
            {
                System.out.print("-> " + adjList[i].get(j));
            }
            System.out.println();
        }
    }

    public void addEdge(int source, int dest) 
    {
        LinkedList<Integer> sourceList = adj[source];
        sourceList.add(dest);
    }
}
