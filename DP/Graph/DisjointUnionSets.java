public class DisjointUnionSets {

    int[] parent;
    int[] rank;
    int noOfVertices;

    public DisjointUnionSets(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.rank = new int[noOfVertices];
        this.parent = new int[noOfVertices];

        for (int i = 0; i < noOfVertices; i++)
        {
            parent[i] = i;
        }
    }

    int find(int vertex)
    {
        if (parent[vertex] == vertex)
            return vertex;
        
            return find(parent[vertex]);
    }

    void union(int vertexX, int vertexY)
    {
        int xRoot = find(vertexX);
        int yRoot = find(vertexY);

        if (xRoot == yRoot)
            return;
        
        if (rank[xRoot] < rank[yRoot])
        {
            parent[xRoot] = yRoot;
        }
        else if (rank[yRoot] < rank[xRoot])
        {
            parent[yRoot] = xRoot;
        }
        else 
        {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }

    public static void main(String[] args) {
        
    }
}
