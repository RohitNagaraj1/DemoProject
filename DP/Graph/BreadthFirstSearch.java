import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {
    int noOfVertices;
    LinkedList<Integer> adj[];

    public BreadthFirstSearch(int noOfVertices)
    {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];

        for (int i = 0; i < noOfVertices; i++)
        {
            adj[i] = new LinkedList<Integer>();
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

    ArrayList<Integer> breadthFirstSearch(int source)
    {
        boolean visited[] = new boolean[noOfVertices + 1];
        visited[source] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        ArrayList<Integer> bfsList = new ArrayList<>();
        
        while (queue.size() > 0)
        {
            int current = queue.poll();
            bfsList.add(current);

            for (Integer eachVertex : adj[current])
            {
                if (!visited[eachVertex])
                {
                    visited[eachVertex] = true;
                    queue.add(eachVertex);
                }
            }
        }

        return bfsList;
    }

    boolean distanceBetweenNodes(int source, int dest, int pred[], int dist[]) 
    {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[noOfVertices + 1];
        for (int i = 0; i < noOfVertices; i++) 
        {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[source] = true;
        dist[source] = 0;
        queue.add(source);

        ArrayList<Integer> bfsList = new ArrayList<>();
        while (queue.size() != 0) 
        {
            int cur = queue.poll();
            bfsList.add(cur);

            for (Integer eachVertex : adj[cur]) 
            {
                if (!visited[eachVertex]) 
                {
                    queue.add(eachVertex);
                    visited[eachVertex] = true;

                    dist[eachVertex] = dist[cur] + 1;
                    pred[eachVertex] = cur;

                    if (eachVertex == dest)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.printGraph(graph.adj);
        System.out.println("breadthFirstSearch :- " + graph.breadthFirstSearch(2));
        int[] pred = new int[5];
        int[] dist = new int[5];
        graph.distanceBetweenNodes(0, 4, pred, dist);

        System.out.println(pred.toString());
        System.out.println(dist);
    }
}
