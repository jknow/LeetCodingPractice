package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {
        // Create a graph
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(0, 5);

        System.out.println(graph.topologicalSort());

        // Print the graph
        System.out.println("Graph:");
        graph.printGraph();
        System.out.println(graph.bfsSearch(0,1));
        System.out.println(graph.dfsSearch(0,1));

        // Remove an edge and print the graph
        graph.removeEdge(0, 1);
        System.out.println("After removing edge (0, 1):");
        graph.printGraph();
        System.out.println(graph.bfsSearch(0,1));
        System.out.println(graph.dfsSearch(0,1));

        // Remove a vertex and print the graph
        graph.removeVertex(2);
        System.out.println("After removing vertex 2:");
        graph.printGraph();
    }

    private static void testBinarySearch() {
        int[] nums = {-1,0,3,5,9,12};
        int target = -1;

        Search search = new Search();
        System.out.println(search.binarySearch(nums, target));
        target = 0;
        System.out.println(search.binarySearch(nums, target));
        target = 3;
        System.out.println(search.binarySearch(nums, target));
        target = 5;
        System.out.println(search.binarySearch(nums, target));
        target = 9;
        System.out.println(search.binarySearch(nums, target));
        target = 12;
        System.out.println(search.binarySearch(nums, target));
        target = 13;
        System.out.println(search.binarySearch(nums, target));
    }

    private static void testQuicksort() {
        System.out.println("testQuicksort");
        Sorts sorts = new Sorts();

        // int[] arr = {2, 3, 4, 4, 4, 6, 6, 7, 8, 8, 9, 9};

        int[] arr = {6,4,7,8,3,6,8,9,2,4,9,4};
        //sorts.quickSort(arr, 0, arr.length - 1);
        sorts.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2, 3, 4, 4, 4, 6, 6, 8, 7, 8, 9, 9};
        sorts.quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {9, 9, 8, 8, 7, 6, 6, 4, 4, 4, 3, 2};
        sorts.quickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
    }

    private static void testQueue() {
        System.out.println("testQueue");

        QueueImpl<Integer> q = new QueueImpl<>(2);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println("New Queue");

        q = new QueueImpl<>(2);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        System.out.println(q.dequeue()); // 4
        System.out.println(q.dequeue()); // 5
        System.out.println(q.dequeue()); // 6
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        System.out.println(q.dequeue()); // 7
        System.out.println(q.dequeue()); // 8
    }

    public static void testStack() {
        System.out.println("testStack");

        StackImpl<Integer> stack = new StackImpl<>(2);
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());}
}