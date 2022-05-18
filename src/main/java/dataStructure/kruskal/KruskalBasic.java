package dataStructure.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalBasic {
    static HashMap<String, Integer> rank = new HashMap<>();
    static HashMap<String, String> parent = new HashMap<>();
    static ArrayList<Edge> edges = new ArrayList<Edge>();

    public String find(String node) {
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public String union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(nodeU, nodeV);
        }
        parent.put(nodeV, nodeU);
        if (rank.get(root1) == rank.get(root2)) {
            rank.put(root2, rank.get(root2) + 1);
        }

        return nodeU;
    }

    public void makeSet(String node) {
        rank.put(node, 0);
        parent.put(node, node);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge> edges) {
        Edge currentEdge;
        ArrayList<Edge> mst = new ArrayList<>();

        for (int index = 0; index < vetices.size(); index++) {
            makeSet(vetices.get(index));
        }
        Collections.sort(edges);

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (find(currentEdge.nodeU) != find(currentEdge.nodeV)) {
                union(currentEdge.nodeU, currentEdge.nodeV);
                mst.add(currentEdge);
            }
        }
        Collections.sort(edges);
        return mst;
    }

    public static void main(String[] args) {

        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        KruskalBasic kruskalBasic = new KruskalBasic();
        System.out.println(kruskalBasic.kruskalFunc(vetices, edges));
    }
}
