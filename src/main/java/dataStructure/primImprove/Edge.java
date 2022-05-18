package dataStructure.primImprove;

public class Edge implements Comparable<Edge>{
    public String node;
    public int weight;

    public Edge(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
