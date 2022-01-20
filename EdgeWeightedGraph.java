package KruskalAlgorithm;

public class EdgeWeightedGraph {

    private final Bag<Edge>[] adj;
    private final int V;
    private int E;
    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj =(Bag<Edge>[]) new Bag[V];
        for(int i = 0; i < V; i++)
        {
            adj[i] = new Bag<Edge>();
        }
    }

    public void addEdge(int v, int w, double weight) {
        Edge e = new Edge(v,w,weight);
//        int V = e.either();
//        int W = e.other(V);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public int getV() {
        return V;
    }
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
