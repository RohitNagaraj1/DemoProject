import java.util.ArrayList;

public class AdjacencyList {
    
    int noOfVertices;
    ArrayList<ArrayList<Integer>> adjList;

    public AdjacencyList(int noOfVertices)
    {
        this.noOfVertices = noOfVertices;
        this.adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < noOfVertices; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int source, int destination)
    {
        ArrayList<Integer> sourceList = adjList.get(source);
        sourceList.add(destination);

        ArrayList<Integer> destinationList = adjList.get(destination);
        destinationList.add(source);
    }

    void printGraph()
    {
        for (int i = 1; i < adjList.size(); i++) 
        {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjList.get(i).size(); j++) 
            {
                System.out.print("-> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        int noOfVertices = 6;
        AdjacencyList graph = new AdjacencyList(noOfVertices);
        graph.addEdge(1, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.printGraph();
    }
}
