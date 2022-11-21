import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch 
{
    int noOfVertices;
    LinkedList<Integer> adj[];
    public DepthFirstSearch(int noOfVertices)
    {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
        {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination)
    {
        LinkedList<Integer> sourceList = adj[source];
        sourceList.add(destination);

        LinkedList<Integer> destiationList = adj[destination];
        destiationList.add(source);
    }

    void printGraph(LinkedList<Integer> adjList[])
    {
        for (int i = 0; i < noOfVertices; i++)
        {
            System.out.print("Vertex  " + i + "   :   ");
            for (int j = 0; j < adjList[i].size(); j++)
            {
                System.out.print("-->" + adjList[i].get(j));
            }
            System.out.println();
        }
    }

    public void depthFirstSearch(int source, ArrayList<Integer> dfsList, boolean visited[])
    {
        visited[source] = true;
        dfsList.add(source);

        for (Integer nodes : adj[source])
        {
            if (!visited[nodes])
            {
                depthFirstSearch(nodes, dfsList, visited);
            }
        }
    }

    public void depthFirstSearchIterative(int source, ArrayList<Integer> dfsList, boolean visited[])
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        dfsList.add(source);
        visited[source] = true;

        while (stack.size() > 0)
        {
            int current = stack.peek();
            boolean isTrue = false;

            for (Integer nodes : adj[current])
            {
                if (!visited[nodes])
                {
                    stack.add(nodes);
                    dfsList.add(nodes);
                    isTrue = true;
                    visited[nodes] = true;
                    break;
                }
            }

            if (!isTrue)
            {
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 9;
        DepthFirstSearch graph = new DepthFirstSearch(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);


        graph.addEdge(5, 8);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);


        graph.printGraph(graph.adj);

        boolean visited[] = new boolean[noOfVertices + 1];
        boolean visited1[] = new boolean[noOfVertices + 1];

        for (int i = 0; i < noOfVertices; i++) 
        {
            if (!visited[i]) 
            {
                System.out.println("visited :- " + i);
                ArrayList<Integer> dfsList = new ArrayList<>();
                graph.depthFirstSearch(i, dfsList, visited);
                System.out.println("depthFirstSearch :- " + dfsList);
                ArrayList<Integer> dfsList1 = new ArrayList<>();
                graph.depthFirstSearchIterative(i, dfsList1, visited1);
                System.out.println("depthFirstSearch :- " + dfsList1);
            }
        }
    }
}
