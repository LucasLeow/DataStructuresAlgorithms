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

    public void printGraph() {
        System.out.println(this.adjList);
    }
}
