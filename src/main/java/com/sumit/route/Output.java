package com.sumit.route;
import java.util.*;

public class Output {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addRoad("Delhi", "Agra", 200);
        graph.addRoad("Agra", "Kanpur", 300);
        graph.addRoad("Kanpur", "Lucknow", 90);
        graph.addRoad("Lucknow", "Patna", 500);
        graph.addRoad("Delhi", "Jaipur", 280);
        graph.addRoad("Jaipur", "Udaipur", 400);
        graph.addRoad("Udaipur", "Mumbai", 760);

        //  Apply PEAK hour traffic
        graph.applyTraffic(TrafficType.PEAK_HOUR);

        // Simulate accident
        graph.simulateAccident("Agra", "Kanpur");

        // Dijkstra
        DijkstraAlgorithm.shortestPath(graph, "Delhi", "Patna");

        // Heuristic values for A*
        Map<String, Integer> heuristic = new HashMap<>();
        heuristic.put("Delhi", 700);
        heuristic.put("Agra", 600);
        heuristic.put("Kanpur", 400);
        heuristic.put("Lucknow", 300);
        heuristic.put("Patna", 0);
        heuristic.put("Jaipur", 800);
        heuristic.put("Udaipur", 900);
        heuristic.put("Mumbai", 1200);

        // A*
        AStarAlgorithm.findPath(graph, "Delhi", "Patna", heuristic);
    }
}

