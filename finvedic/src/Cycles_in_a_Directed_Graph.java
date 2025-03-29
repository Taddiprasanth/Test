import java.util.*;
public class Cycles_in_a_Directed_Graph { 
    private int numOfNodes;
    private List<List<Integer>> adjacencyList;
    public Cycles_in_a_Directed_Graph(int numOfNodes) { 
        this.numOfNodes = numOfNodes;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numOfNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void insertEdge(int start, int end) {  
        adjacencyList.get(start).add(end);
    }
    private boolean hasCycleUtil(int node, boolean[] visitedNodes, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true; 
        }
        if (visitedNodes[node]) {
            return false; 
        }
        visitedNodes[node] = true;
        recursionStack[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (hasCycleUtil(neighbor, visitedNodes, recursionStack)) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
    public boolean checkForCycle() { 
        boolean[] visitedNodes = new boolean[numOfNodes];
        boolean[] recursionStack = new boolean[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            if (!visitedNodes[i] && hasCycleUtil(i, visitedNodes, recursionStack)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int nodes = inputScanner.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = inputScanner.nextInt();
        Cycles_in_a_Directed_Graph graph = new Cycles_in_a_Directed_Graph(nodes);
        System.out.println("Enter the edges (start node -> end node): ");
        for (int i = 0; i < edges; i++) {
            int startNode = inputScanner.nextInt();
            int endNode = inputScanner.nextInt();
            graph.insertEdge(startNode, endNode);
        }
        if (graph.checkForCycle()) {
            System.out.println("The directed graph contains a cycle.");
        } else {
            System.out.println("The directed graph does not contain a cycle.");
        }
        inputScanner.close();
    }
}
