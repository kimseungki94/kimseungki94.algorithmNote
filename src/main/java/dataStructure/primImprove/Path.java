package dataStructure.primImprove;

public class Path {
    String node1;
    String node2;
    int weight;

    public Path(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Path{" +
                "node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                ", weight=" + weight +
                '}';
    }
}
