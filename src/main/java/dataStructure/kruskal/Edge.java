package dataStructure.kruskal;

public class Edge implements Comparable<Edge> {
    Integer weight;
    String nodeV;
    String nodeU;

    public Edge(Integer weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }


    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
