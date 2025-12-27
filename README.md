# Smart-Route-Optimization
Smart Route Optimization System – A Java-based traffic-aware navigation system implementing Dijkstra’s Algorithm and A* with real-time traffic simulation, accident handling, and peak-hour optimization using advanced data structures.

🚦 Smart Route Optimization System

Java | Advanced Data Structures & Algorithms | Maven

📌 Overview

The Smart Route Optimization System is a Java-based application that computes the most efficient travel route between cities by considering real-world traffic conditions such as peak hours, accidents, and congestion.
It compares Dijkstra’s Algorithm and A* to demonstrate optimized pathfinding using advanced DSA concepts.

🎯 Key Features

🚗 Traffic-aware route optimization

⏰ Peak-hour vs non-peak traffic simulation

🚧 Accident simulation with dynamic cost updates

🧭 Shortest path calculation using Dijkstra’s Algorithm

⭐ Heuristic-based optimization using A* Algorithm

🗺️ Full path printing (e.g., Delhi → Agra → Kanpur → Patna)

📊 Cost comparison between normal and optimized routes

🛠️ Technologies Used

Language: Java

Build Tool: Maven

Algorithms:

Dijkstra’s Algorithm

A* Search Algorithm

Data Structures:

Graph (Adjacency List)

Priority Queue

HashMap, HashSet

IDE: VS Code

🧠 Core Concepts Implemented

Graph traversal and weighted graphs

Priority queues for shortest path optimization

Heuristic functions for A* search

Dynamic edge weight modification based on traffic conditions

Modular and object-oriented design

▶️ How to Run
mvn clean compile
mvn exec:java 

📂 Project Structure
smart-route-optimization
 └── src
     ├── main
     │   └── java
     │       └── com.sumit.route
     │           ├── Graph.java
     │           ├── Node.java
     │           ├── Edge.java
     │           ├── TrafficType.java
     │           ├── DijkstraAlgorithm.java
     │           ├── AStarAlgorithm.java
     │           └── Output.java
     └── test

📈 Sample Output
Accident reported between Agra and Kanpur

Traffic-Aware Shortest Path:
Delhi → Agra → Kanpur → Lucknow → Patna
Total Cost (with traffic): 3020

A* Traffic-Optimized Path:
Delhi → Agra → Kanpur → Lucknow → Patna
Total Cost (with traffic): 3020

🚀 Future Enhancements

Real-time traffic API integration

GUI-based route visualization

Multi-source and multi-destination routing

Performance comparison on large graphs


