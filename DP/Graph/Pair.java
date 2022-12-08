public class Pair implements Comparable<Pair> {

    int vertex;
    int weight;

    public Pair(int vertex, int weight)
    {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Pair that)
    {
        return this.weight - that.weight;
    }
}
