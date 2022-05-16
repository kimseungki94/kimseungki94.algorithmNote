package dataStructure;

public class Edge implements Comparable<Edge> {
    Integer distance;
    String name;

    public Edge(Integer distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }
}
