package dataStructure.prim;

public class Edge implements Comparable<Edge> {
    public int weight;
    public String node1;
    public String node2;

    public Edge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
