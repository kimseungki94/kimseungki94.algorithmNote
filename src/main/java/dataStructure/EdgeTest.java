package dataStructure;

import java.util.Arrays;
import java.util.Comparator;

public class EdgeTest implements Comparable<EdgeTest> {
    String name;
    Integer distance;

    public EdgeTest(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(EdgeTest e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        EdgeTest edge1 = new EdgeTest("A", 12);
        EdgeTest edge2 = new EdgeTest("A", 10);
        EdgeTest edge3 = new EdgeTest("A", 15);

        EdgeTest[] edge = new EdgeTest[]{edge1, edge2, edge3};
        Arrays.sort(edge, new Comparator<EdgeTest>() {
            @Override
            public int compare(EdgeTest e1, EdgeTest e2) {
                return e2.distance - e1.distance;
            }
        });
        for (int index = 0; index < edge.length; index++) {
            System.out.println(edge[index].distance);
        }
    }
}
