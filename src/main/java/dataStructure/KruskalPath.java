package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalPath {
    HashMap<String, Integer> rank = new HashMap<>();
    HashMap<String, String> parent = new HashMap<>();

    public String find(String node) {
        if (node != parent.get(node)) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        }
        parent.put(root1, root2);
        if (rank.get(root1) == rank.get(root2)) {
            rank.put(root2, rank.get(root2) + 1);
        }
    }
    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public ArrayList<KruskalEdge> kruskalFunc(ArrayList<String> vetices, ArrayList<KruskalEdge> edges) {
        ArrayList<KruskalEdge> mst = new ArrayList<>();
        KruskalEdge currentNode;
        for(int index=0;index<vetices.size();index++) {
            makeSet(vetices.get(index));
        }
        Collections.sort(edges);
        for(int index=0;index<edges.size();index++) {
            currentNode = edges.get(index);
            if(find(currentNode.nodeV) != find(currentNode.nodeU)) {
                union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<KruskalEdge> edges = new ArrayList<>();
        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        edges.add(new KruskalEdge(7, "A", "B"));
        edges.add(new KruskalEdge(5, "A", "D"));
        edges.add(new KruskalEdge(7, "B", "A"));
        edges.add(new KruskalEdge(8, "B", "C"));
        edges.add(new KruskalEdge(9, "B", "D"));
        edges.add(new KruskalEdge(7, "B", "E"));
        edges.add(new KruskalEdge(8, "C", "B"));
        edges.add(new KruskalEdge(5, "C", "E"));
        edges.add(new KruskalEdge(5, "D", "A"));
        edges.add(new KruskalEdge(9, "D", "B"));
        edges.add(new KruskalEdge(7, "D", "E"));
        edges.add(new KruskalEdge(6, "D", "F"));
        edges.add(new KruskalEdge(7, "E", "B"));
        edges.add(new KruskalEdge(5, "E", "C"));
        edges.add(new KruskalEdge(7, "E", "D"));
        edges.add(new KruskalEdge(8, "E", "F"));
        edges.add(new KruskalEdge(9, "E", "G"));
        edges.add(new KruskalEdge(6, "F", "D"));
        edges.add(new KruskalEdge(8, "F", "E"));
        edges.add(new KruskalEdge(11, "F", "G"));
        edges.add(new KruskalEdge(9, "G", "E"));
        edges.add(new KruskalEdge(11, "G", "F"));

        KruskalBasic kruskalBasic = new KruskalBasic();

        ArrayList<KruskalEdge> mst = kruskalBasic.kruskalFunc(vetices, edges);
        for(int index=0;index<mst.size();index++) {
            System.out.println(mst.get(index));
        }

    }
}
