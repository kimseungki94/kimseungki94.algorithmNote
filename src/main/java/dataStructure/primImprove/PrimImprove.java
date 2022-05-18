package dataStructure.primImprove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimImprove {
    public ArrayList<Path> primImproveFunc(String startNode, HashMap<String, HashMap<String, Integer>> graph) {
        Edge keysObject, poppedEdge, linkedObject;
        Path keysPath;
        HashMap<String, Edge> keysObjects = new HashMap<>();
        HashMap<String, String> mstPath = new HashMap<>();
        HashMap<String, Integer> linkedObjects;
        PriorityQueue<Edge> keys = new PriorityQueue<>();
        ArrayList<Path> mst = new ArrayList<>();
        Integer totalWeight = 0;

        for (String adjacent : graph.keySet()) {
            if (startNode == adjacent) {
                keysObject = new Edge(adjacent, 0);
                mstPath.put(adjacent, adjacent);
            } else {
                keysObject = new Edge(adjacent, Integer.MAX_VALUE);
                mstPath.put(adjacent, null);
            }
            keysObjects.put(adjacent, keysObject);
            keys.add(keysObject);
        }
        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);
            mst.add(new Path(poppedEdge.node, mstPath.get(poppedEdge.node), poppedEdge.weight));
            totalWeight += poppedEdge.weight;
            linkedObjects = graph.get(poppedEdge.node);
            for (String adjacent : linkedObjects.keySet()) {
                mstPath.put(adjacent, poppedEdge.node);
                if (keysObjects.containsKey(adjacent)) {
                    linkedObject = keysObjects.get(adjacent);
                    if(linkedObjects.get(adjacent) < linkedObject.weight) {
                        linkedObject.weight = linkedObjects.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);
                        keys.remove(linkedObject);
                        keys.add(linkedObject);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<String, HashMap<String, Integer>>();

        HashMap<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        System.out.println(mygraph);
        PrimImprove primImprove = new PrimImprove();
        System.out.println(primImprove.primImproveFunc("A", mygraph));
        ;
    }
}
