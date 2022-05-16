package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {
    public static HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String startNode) {
        HashMap<String, Integer> distances = new HashMap<>();
        Edge currentNode, adjacentNode;
        int currentDistance, adjacentDistance, weight;
        String currentVertex, adjacentVertex;
        ArrayList<Edge> adjacentNodes;
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        distances.put(startNode, 0);
        priorityQueue.add(new Edge(0, startNode));
        while (priorityQueue.size() != 0) {
            currentNode = priorityQueue.poll();
            currentVertex = currentNode.name;
            currentDistance = currentNode.distance;
            if (distances.get(currentVertex) < currentDistance) {
                continue;
            }
            adjacentNodes = graph.get(currentNode.name);
            for (int index = 0; index < adjacentNodes.size(); index++) {
                adjacentNode = adjacentNodes.get(index);
                adjacentVertex = adjacentNode.name;
                adjacentDistance = adjacentNode.distance;
                weight = adjacentDistance + currentDistance;
                if (weight < distances.get(adjacentVertex)) {
                    distances.put(adjacentVertex, weight);
                    priorityQueue.add(new Edge(weight, adjacentVertex));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        System.out.println(dijkstraFunc(graph, "A"));
    }
}
