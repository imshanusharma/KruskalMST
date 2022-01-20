package KruskalAlgorithm;

public class UF {
    private int[] id;
    public UF(int n){
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    public boolean find(int v, int w){
        return id[v] == id[w];
    }
    public void union(int v, int w){
        int idV = id[v];
        int idW = id[w];
        for(int i = 0; i < id.length; i++){
            if(id[i] == idW)
            {
                id[i] = idV;
            }
        }
    }
}