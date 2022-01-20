package KruskalAlgorithm;

import java.util.Iterator;

public class Bag<K> implements Iterable<K> {
    private Node first;
    private class Node {
        private K data;
        private Node next;
        public Node(K data) {
            this.data =data;
            this.next = null;
        }
    }
    public void add(K data) {
        first = add(first,data);
    }
    private Node add(Node node, K data) {
        if(node == null)
        {
            return new Node(data);
        }
        node = add(node.next,data);
        return node;
    }
    public Iterator<K> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<K> {
        private Node n = first;

        @Override
        public K next() {
            Node temp = n;
            n = n.next;
            return temp.data;
        }

        @Override
        public boolean hasNext() {
            return n != null;
        }

        @Override
        public void remove() {}
    }
}
