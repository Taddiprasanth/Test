import java.util.*;
public class Shortest_path_Dijkstra {
    static class Node implements Comparable<Node> {
        String vertex;
        int weight;
        public Node(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    public static Map<String, Integer> dijkstra(Map<String, List<Node>> graph, String start) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Map<String, Integer> shortestPaths = new HashMap<>();
        for (String node : graph.keySet()) {
            shortestPaths.put(node, Integer.MAX_VALUE);
        }
        shortestPaths.put(start, 0);
        minHeap.add(new Node(start, 0));
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            if (current.weight > shortestPaths.get(current.vertex)) {
                continue;
            }
            for (Node neighbor : graph.get(current.vertex)) {
                int distance = current.weight + neighbor.weight;
                if (distance < shortestPaths.get(neighbor.vertex)) {
                    shortestPaths.put(neighbor.vertex, distance);
                    minHeap.add(new Node(neighbor.vertex, distance));
                }
            }
        }
        return shortestPaths;
    }
    public static void main(String[] args) {
        Map<String, List<Node>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Node("B", 1), new Node("C", 4)));
        graph.put("B", Arrays.asList(new Node("A", 1), new Node("C", 2), new Node("D", 5)));
        graph.put("C", Arrays.asList(new Node("A", 4), new Node("B", 2), new Node("D", 1)));
        graph.put("D", Arrays.asList(new Node("B", 5), new Node("C", 1)));
        String startNode = "A";
        Map<String, Integer> shortestPaths = dijkstra(graph, startNode);
        System.out.println("Shortest paths from node " + startNode + ":");
        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("Distance to " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
