package dataStructure;

public class KruskalEdge implements Comparable<KruskalEdge> {
    Integer weight;
    String nodeV;
    String nodeU;

    public KruskalEdge(Integer weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }


    @Override
    public int compareTo(KruskalEdge e) {
        return this.weight - e.weight;
    }

    @Override
    public String toString() {
        return "KruskalEdge{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }
}
