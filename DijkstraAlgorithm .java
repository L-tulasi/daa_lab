package test;

import java.util.Arrays;

import java.util.PriorityQueue;

import java.util.Scanner;



public class DijkstraAlgorithm {



    static class Node implements Comparable<Node> {

        int vertex;

        int distance;



        public Node(int vertex, int distance) {

            this.vertex = vertex;

            this.distance = distance;

        }



        @Override

        public int compareTo(Node other) {

            return Integer.compare(this.distance, other.distance);

        }

    }



    public static void dijkstra(int[][] graph, int source) {

        int n = graph.length;

        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;



        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        minHeap.add(new Node(source, 0));



        while (!minHeap.isEmpty()) {

            Node currentNode = minHeap.poll();

            int currentVertex = currentNode.vertex;



            for (int neighbor = 0; neighbor < n; neighbor++) {

                if (graph[currentVertex][neighbor] != 0) {

                    int newDistance = distance[currentVertex] + graph[currentVertex][neighbor];

                    if (newDistance < distance[neighbor]) {

                        distance[neighbor] = newDistance;

                        minHeap.add(new Node(neighbor, newDistance));

                    }

                }

            }

        }



        // Print the distances from the source to all vertices

        System.out.println("Shortest distances from source " + source + ":");

        for (int i = 0; i < n; i++) {

            System.out.println("To " + i + ": " + distance[i]);

        }

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        // Get the number of vertices

        System.out.print("Enter the number of vertices: ");

        int n = scanner.nextInt();



        // Create a 2D array to represent the graph

        int[][] graph = new int[n][n];



        // Get the graph input

        System.out.println("Enter the adjacency matrix for the graph:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                graph[i][j] = scanner.nextInt();

            }

        }



        // Get the source vertex

        System.out.print("Enter the source vertex: ");

        int source = scanner.nextInt();



        // Perform Dijkstra's algorithm

        dijkstra(graph, source);



        // Close the scanner

        scanner.close();

    }

}
