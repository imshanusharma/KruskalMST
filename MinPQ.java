package KruskalAlgorithm;

import java.util.ArrayList;

public class MinPQ<K extends Comparable<K>> {
    ArrayList<K> data;
    public MinPQ() {
        data = new ArrayList<>();
    }

    public void add(K val){
        data.add(val);
        swim(data.size()-1);
    }

    private void swim(int i){
        int parent = (i-1)/2;
        if(data.get(parent).compareTo(data.get(i)) > 0){
            swap(parent,i);
            swim(parent);
        }
    }

    private void sink(int i){
        int min = i;
        int left = i*2+1;
        if(left < data.size() && data.get(left).compareTo(data.get(min)) < 0){
            min = left;
        }
        int right = i*2+2;
        if(right < data.size() && data.get(right).compareTo(data.get(min)) < 0){
            min = right;
        }

        if(min != i) {
            swap(min,i);
            sink(min);

        }
    }

    private void swap(int i, int j){
        K ith = data.get(i);
        K jth = data.get(j);

        data.set(j, ith);
        data.set(i, jth);
    }

    public K poll(){
        if(isEmpty()){
            return null;
        }
        swap(0,data.size()-1);

        K val = data.remove(data.size()-1);
        sink(0);
        return val;
    }

    public K peek(){
        return data.get(0);
    }

    public boolean isEmpty(){
        return data.size() == 0;
    }

    public int size(){
        return data.size();
    }
}
