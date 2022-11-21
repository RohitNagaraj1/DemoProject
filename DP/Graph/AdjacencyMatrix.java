public class AdjacencyMatrix
{
    int[][] adjMatrix;
    int noOfVertices;

    public AdjacencyMatrix(int noOfVertices) 
    {
        this.noOfVertices = noOfVertices;
        this.adjMatrix = new int[noOfVertices][noOfVertices];
    }

    public void addEdge(int source, int destination)
    {
        adjMatrix[source][destination] = 1;
        adjMatrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination)
    {
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < noOfVertices; i++)
        {
            sb.append(i + " :   ");

            for (int j = 1; j < noOfVertices; j++)
            {
                sb.append(adjMatrix[i][j] + "  ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrix adj = new AdjacencyMatrix(6);
        adj.addEdge(1, 2);
        adj.addEdge(1, 4);
        adj.addEdge(1, 5);

        adj.addEdge(4, 5);
        adj.addEdge(4, 2);
        adj.addEdge(5, 3);

        System.out.println(adj.toString());
    }
}