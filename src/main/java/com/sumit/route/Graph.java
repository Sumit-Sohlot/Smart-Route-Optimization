package com.sumit.route;
import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();
    private final Random random = new Random();

    public void addCity(String city) {
        adjacencyList.putIfAbsent(city, new ArrayList<>());
    }

    public void addRoad(String source, String destination, int distance) {
        addCity(source);
        addCity(destination);

        adjacencyList.get(source).add(new Edge(destination, distance));
        adjacencyList.get(destination).add(new Edge(source, distance));
    }

    //  Accident Simulation
    public void simulateAccident(String from, String to) {
        for (Edge edge : adjacencyList.getOrDefault(from, new ArrayList<>())) {
            if (edge.destination.equals(to)) {
                edge.applyAccident();
            }
        }

        for (Edge edge : adjacencyList.getOrDefault(to, new ArrayList<>())) {
            if (edge.destination.equals(from)) {
                edge.applyAccident();
            }
        }

        System.out.println(" Accident reported between " + from + " and " + to);
    }


    //  Peak vs Non-Peak Traffic
    public void applyTraffic(TrafficType trafficType) {
        for (List<Edge> edges : adjacencyList.values()) {
            for (Edge edge : edges) {

                if (trafficType == TrafficType.PEAK_HOUR) {
                    // 1.5x – 2.5x traffic
                    edge.trafficFactor = 1.5 + random.nextDouble();
                } else {
                    // 1.0x – 1.3x traffic
                    edge.trafficFactor = 1.0 + (random.nextDouble() * 0.3);
                }
            }
        }
    }

    public List<Edge> getNeighbors(String city) {
        return adjacencyList.getOrDefault(city, new ArrayList<>());
    }

    public Set<String> getCities() {
        return adjacencyList.keySet();
    }
}

