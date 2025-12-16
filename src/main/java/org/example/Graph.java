package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        this.adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList.get(source).add(destination);
    }

    public void removeVertex(int vertex) {
        this.adjacencyList.remove(vertex);

        for (List<Integer> neighbors : this.adjacencyList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    public void removeEdge(int source, int destination) {
        this.adjacencyList.get(source).remove(Integer.valueOf(destination));
    }

    public List<Integer> getNeighbors(int vertex) {
        return this.adjacencyList.get(vertex);
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer> > entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
