package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFSSearch {
    public static ArrayList<String> dfsSearch(HashMap<String,ArrayList<String>> graph, String startNode) {
        ArrayList<String> isVisited = new ArrayList<>();
        ArrayList<String> isNeeded = new ArrayList<>();

        isNeeded.add(startNode);
        while (isNeeded.size()>0) {
            String node = isNeeded.remove(isNeeded.size()-1);
            if(!isVisited.contains(node)) {
                isVisited.add(node);
                isNeeded.addAll(graph.get(node));
            }
        }
        return isVisited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        System.out.println(graph);
        System.out.println(dfsSearch(graph,"A"));
    }
}
