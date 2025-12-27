package com.sumit.route;
public class Edge {
    String destination;
    int baseWeight;
    double trafficFactor;
    boolean accident;

    public Edge(String destination, int baseWeight) {
        this.destination = destination;
        this.baseWeight = baseWeight;
        this.trafficFactor = 1.0;
        this.accident = false;
    }

    public void applyAccident() {
        this.accident = true;
        this.trafficFactor = 5.0; // massive slowdown
    }

    public void clearAccident() {
        this.accident = false;
        this.trafficFactor = 1.0;
    }

    public int getEffectiveWeight() {
        return (int) (baseWeight * trafficFactor);
    }
}

