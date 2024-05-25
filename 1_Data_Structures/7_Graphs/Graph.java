import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (this.adjList.get(vertex) == null) {
            this.adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false; // vertex already exist
    }

    public boolean removeVertex(String vertex) {
        if (this.adjList.get(vertex) == null) return false;

        this.adjList.remove(vertex);

        for (ArrayList adjLs : this.adjList.values()) {
            adjLs.remove(vertex);
        }
        return true;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (this.adjList.get(vertex1) != null && this.adjList.get(vertex2) != null) {
            this.adjList.get(vertex1).add(vertex2);
            this.adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (this.adjList.get(vertex1) != null && this.adjList.get(vertex2) != null) {
            this.adjList.get(vertex1).remove(vertex2);
            this.adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public void printGraph() {
        System.out.println(this.adjList);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "C");

        g.printGraph();
        g.removeVertex("A");
        g.printGraph();
    }
}
