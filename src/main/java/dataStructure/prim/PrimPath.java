package dataStructure.prim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath  {
    public ArrayList<Edge> primFunc(String startEdge, ArrayList<Edge> myedges) {
        ArrayList<Edge> mst = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentEdge = new HashMap<>();
        ArrayList<String> connectedEdge = new ArrayList<>();
        ArrayList<Edge> adjacentEdges;
        PriorityQueue<Edge> priorityEdge = new PriorityQueue<>();
        Edge currentEdge, adjacentNode;
        for(int index=0;index<myedges.size();index++) {
            if(!adjacentEdge.containsKey(myedges.get(index).node1)) {
                adjacentEdge.put(myedges.get(index).node1, new ArrayList<Edge>());
            }
            if(!adjacentEdge.containsKey(myedges.get(index).node2)) {
                adjacentEdge.put(myedges.get(index).node2, new ArrayList<Edge>());
            }
        }
        for(int index=0;index<myedges.size();index++) {
            currentEdge = myedges.get(index);
            adjacentEdge.get(currentEdge.node1).add(new Edge(currentEdge.weight,currentEdge.node1,currentEdge.node2));
            adjacentEdge.get(currentEdge.node2).add(new Edge(currentEdge.weight,currentEdge.node2,currentEdge.node1));
        }
        connectedEdge.add(startEdge);
        adjacentEdges = adjacentEdge.getOrDefault(startEdge, new ArrayList<Edge>());
        for(int index=0;index<adjacentEdges.size();index++) {
            priorityEdge.add(adjacentEdges.get(index));
        }
        while (priorityEdge.size()>0) {
            currentEdge = priorityEdge.poll();
            if(!connectedEdge.contains(currentEdge.node2)) {
                connectedEdge.add(currentEdge.node2);
                mst.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
                adjacentEdges = adjacentEdge.getOrDefault(currentEdge.node2, new ArrayList<Edge>());
                for(int index = 0 ; index<adjacentEdges.size();index++) {
                    adjacentNode = adjacentEdges.get(index);
                    if(!connectedEdge.contains(adjacentNode.node2)) {
                        priorityEdge.add(adjacentNode);
                    }
                }
            }
        }
        return mst;
    }
    public static void main(String[] args) {

        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        PrimPath primPath = new PrimPath();
        System.out.println(primPath.primFunc("A",myedges));
    }
}
