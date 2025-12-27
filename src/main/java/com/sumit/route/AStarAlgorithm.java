package com.sumit.route;
import java.util.*;

public class AStarAlgorithm {

    public static void findPath(Graph graph,
                                String source,
                                String destination,
                                Map<String, Integer> heuristic) {

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String city : graph.getCities()) {
            gScore.put(city, Integer.MAX_VALUE);
        }

        gScore.put(source, 0);
        openSet.add(new Node(source, heuristic.get(source)));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.city.equals(destination)) {
                printPath(parent, source, destination, gScore.get(destination));
                return;
            }

            for (Edge edge : graph.getNeighbors(current.city)) {
                int tentativeG = gScore.get(current.city) + edge.getEffectiveWeight();

                if (tentativeG < gScore.get(edge.destination)) {
                    gScore.put(edge.destination, tentativeG);
                    parent.put(edge.destination, current.city);

                    int fScore = tentativeG + heuristic.get(edge.destination);
                    openSet.add(new Node(edge.destination, fScore));
                }
            }
        }
    }

    private static void printPath(Map<String, String> parent,
                                  String source,
                                  String destination,
                                  int distance) {

        List<String> path = new ArrayList<>();
        String current = destination;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("\n A* Traffic-Optimized Path:");
        System.out.println(String.join(" -> ", path));
        System.out.println("Total Cost (with traffic): " + distance);
    }
}
