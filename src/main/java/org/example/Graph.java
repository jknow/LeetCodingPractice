package org.example;

import java.util.*;

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

    public boolean bfsSearch(int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        q.add(source);

        while (!q.isEmpty()) {
            int vertex = q.poll();
            for (Integer neighbor : this.adjacencyList.get(vertex)) {
                if (neighbor == destination) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return false;
    }

    public boolean dfsSearch(int source, int destination) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        stack.push(source);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            for (Integer neighbor : this.adjacencyList.get(vertex)) {
                if (neighbor == destination) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> vertex : this.adjacencyList.entrySet()) {
            if (!visited.contains(vertex.getKey())) {
                topologicalDfs(vertex.getKey(), vertex.getValue(), stack, visited);
            }
        }

        List<Integer> output = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }

    private void topologicalDfs(
            Integer vertex,
            List<Integer> neighbors,
            Stack<Integer> stack,
            Set<Integer> visited
    ) {
        visited.add(vertex);
        for (Integer neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                topologicalDfs(neighbor, this.adjacencyList.get(neighbor), stack, visited);
            }
        }
        stack.push(vertex);
    }
}
