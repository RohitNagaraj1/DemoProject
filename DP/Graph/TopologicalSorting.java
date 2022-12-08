import java.util.*;

public class TopologicalSorting 
{
    int noOfVertices;
    LinkedList<Integer> adj[];

    public TopologicalSorting(int noOfVertices) 
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
        LinkedList sourceList = adj[source];
        sourceList.add(dest);
    }

    void printGraphElements()
    {
        for (int i = 0; i < noOfVertices; i++)
        {
            System.out.print("Vertex   " + i + "    :   ");
            for (Integer nodes : adj[i])
            {
                System.out.print("---> " + nodes);
            }
            System.out.println();
        }
    }

    public void dFS(int source, boolean[] visited, ArrayList<Integer> dfsList)
    {
        dfsList.add(source);
        visited[source] = true;

        for (Integer node : adj[source])
        {
            if (!visited[node])
            {
                dFS(node, visited, dfsList);
            }
        }
    }

    public ArrayList<Integer> topologicalSorting(int source)
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++)
        {
            if (!visited[i])
            {
                topologicalSorting(i, visited, stack);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (stack.size() > 0)
        {
            result.add(stack.pop());
        }

        return result;
    }

    public void topologicalSorting(int source, boolean[] visited, Stack<Integer> stack)
    {
        visited[source] = true;
        for (Integer node : adj[source])
        {
            if (!visited[node])
            {
                topologicalSorting(node, visited, stack);
            }
        }

        stack.push(source);
    }

    public static void main(String[] args) 
    {
        int noOfVertices = 6;
        TopologicalSorting graph = new TopologicalSorting(noOfVertices);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);


        graph.printGraphElements();

        ArrayList<Integer> result = graph.topologicalSorting(0);
        System.out.println("topological sorting  :- " + result);

    }
}
