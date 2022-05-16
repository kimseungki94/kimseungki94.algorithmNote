package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class EdgePriorityQueue implements Comparable<EdgePriorityQueue>{
    public int distance;
    public String vertex;

    public EdgePriorityQueue(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "EdgePriorityQueue{" +
                "distance=" + distance +
                ", vertex='" + vertex + '\'' +
                '}';
    }


    @Override
    public int compareTo(EdgePriorityQueue e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<EdgePriorityQueue>> graph = new HashMap<>();
        graph.put("A", new ArrayList<EdgePriorityQueue>(Arrays.asList(new EdgePriorityQueue(8, "B"), new EdgePriorityQueue(1, "C"), new EdgePriorityQueue(2, "D"))));
        graph.put("B", new ArrayList<EdgePriorityQueue>());
        graph.put("C", new ArrayList<EdgePriorityQueue>(Arrays.asList(new EdgePriorityQueue(5, "B"), new EdgePriorityQueue(2, "D"))));
        graph.put("D", new ArrayList<EdgePriorityQueue>(Arrays.asList(new EdgePriorityQueue(3, "E"), new EdgePriorityQueue(5, "F"))));
        graph.put("E", new ArrayList<EdgePriorityQueue>(Arrays.asList(new EdgePriorityQueue(1, "F"))));
        graph.put("F", new ArrayList<EdgePriorityQueue>(Arrays.asList(new EdgePriorityQueue(5, "A"))));

        for(String key : graph.keySet()) {
            System.out.println(key);
            System.out.println(graph.get(key));
        }
        PriorityQueue<EdgePriorityQueue> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new EdgePriorityQueue(2,"A"));
        priorityQueue.add(new EdgePriorityQueue(5,"B"));
        priorityQueue.add(new EdgePriorityQueue(1,"C"));
        priorityQueue.add(new EdgePriorityQueue(7,"D"));
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());


    }
}
