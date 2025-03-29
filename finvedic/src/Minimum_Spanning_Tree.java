import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
class Subset {
    int parent, rank;
}
public class Minimum_Spanning_Tree {
        private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    private void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);
        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }
    public void kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges);
        Edge[] result = new Edge[V - 1];
        int e = 0;
        int i = 0;
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        while (e < V - 1 && i < edges.size()) {
            Edge nextEdge = edges.get(i++);
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if (x != y) { // No cycle
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }
        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : result) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (src, dest, weight):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(src, dest, weight));
        }
        Minimum_Spanning_Tree mst = new Minimum_Spanning_Tree();
        mst.kruskalMST(edges, V);
        scanner.close();
    }
}
