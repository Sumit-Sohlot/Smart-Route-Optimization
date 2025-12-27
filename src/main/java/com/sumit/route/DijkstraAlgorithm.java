package com.sumit.route;
import java.util.*;

public class DijkstraAlgorithm {

    public static void shortestPath(Graph graph, String source, String destination) {

        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String city : graph.getCities()) {
            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Edge edge : graph.getNeighbors(current.city)) {
                int newDist = distance.get(current.city) + edge.getEffectiveWeight();

                if (newDist < distance.get(edge.destination)) {
                    distance.put(edge.destination, newDist);
                    parent.put(edge.destination, current.city);
                    pq.add(new Node(edge.destination, newDist));
                }
            }
        }

        printPath(parent, source, destination, distance.get(destination));
    }

    private static void printPath(Map<String, String> parent,
                                  String source,
                                  String destination,
                                  int totalDistance) {

        List<String> path = new ArrayList<>();
        String current = destination;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("\n Traffic-Aware Shortest Path:");
        System.out.println(String.join(" -> ", path));
        System.out.println("Total Cost (with traffic): " + totalDistance);
    }
}

