import java.util.*;
public class Graph_colouring {
    private int V; 
    private ArrayList<Integer>[] adj; 
    @SuppressWarnings("unchecked") 
    public Graph_colouring(int vertices) {
        this.V = vertices;
        adj = (ArrayList<Integer>[]) new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    public void greedyColoring() {
        int[] result = new int[V];
        Arrays.fill(result, -1);
        result[0] = 0;
        boolean[] available = new boolean[V];
        Arrays.fill(available, true);
        for (int u = 1; u < V; u++) {
            for (int neighbor : adj[u]) {
                if (result[neighbor] != -1) {
                    available[result[neighbor]] = false;
                }
            }
            int color;
            for (color = 0; color < V; color++) {
                if (available[color]) {
                    break;
                }
            }
            result[u] = color;
            Arrays.fill(available, true);
        }
        System.out.println("Vertex Coloring:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Color " + result[i]);
        }
    }
    public static void main(String[] args) {
        Graph_colouring graph = new Graph_colouring(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.greedyColoring();
    }
}
