import java.util.LinkedList;

public class DetectCycleInAGraph {

    static int noOfVertices;
    LinkedList<Integer> adj[];

    public DetectCycleInAGraph(int noOfVertices) 
    {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) 
        {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        DetectCycleInAGraph graph = new DetectCycleInAGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);

        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        boolean visited[] = new boolean[noOfVertices + 1];
        graph.printGraphElements(graph.adj);

        boolean hasCycle = graph.dfsFindCycle(0, -1, graph.adj, visited);
        System.out.println("Do we have cycle in the graph :- " + hasCycle);
    }


    public boolean dfsFindCycle(int vertex, int parent, LinkedList<Integer> adj[], boolean visited[]) 
    {
        visited[vertex] = true;

        LinkedList<Integer> vertexAdjacentNodes = adj[vertex];
        for (int node : vertexAdjacentNodes) 
        {
            if (!visited[node]) 
            {
                boolean findCycle = dfsFindCycle(node, vertex, adj, visited);
                if (findCycle) {
                    return true;
                }
            } 
            else if (node != parent) 
            {
                return true;
            }
        }
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

        LinkedList<Integer> destinationList = adj[dest];
        destinationList.add(source);
    }
}