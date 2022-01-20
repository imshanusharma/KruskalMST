package KruskalAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Kruskal {
    private Queue<Edge> q = new LinkedList<>();
    public Kruskal(EdgeWeightedGraph g) {
        MinPQ<Edge> pq = new MinPQ<>();
        UF uf = new UF(g.getV());
        while (!pq.isEmpty() && q.size() < g.getV()-1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if(uf.find(v,w)){
                uf.union(v,w);
                q.add(e);
            }
        }
    }

    public void print() {
        if(q.isEmpty()) {
            System.out.println("kdaksbdaksbd");
        }
        for(Edge e : q) {
            System.out.println(e.either());
        }
        System.out.println(" ");
    }
    public Iterable<Edge> edges() {
        return q;
    }
}
