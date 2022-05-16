package dataStructure;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge> {
    String name;
    Integer distance;

    public Edge(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge("A", 12);
        Edge edge2 = new Edge("A", 10);
        Edge edge3 = new Edge("A", 15);

        Edge[] edge = new Edge[]{edge1, edge2, edge3};
        Arrays.sort(edge, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e2.distance-e1.distance;
            }
        });
        for(int index=0;index<edge.length;index++) {
            System.out.println(edge[index].distance);
        }
    }
}
