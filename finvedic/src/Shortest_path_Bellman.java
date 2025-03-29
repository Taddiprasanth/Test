import java.util.*;
public class Shortest_path_Bellman {
    private int vertices;
    private List<Edge> edges;
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public Shortest_path_Bellman(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
    public void bellmanFord(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }
        printSolution(dist, src);
    }
    private void printSolution(int[] dist, int src) {
        System.out.println("Shortest paths from vertex " + src + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " -> Distance: " + dist[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();
        Shortest_path_Bellman graph = new Shortest_path_Bellman(vertices);
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }
        System.out.print("Enter source vertex: ");
        int src = scanner.nextInt();
        graph.bellmanFord(src);
        scanner.close();
    }
}
