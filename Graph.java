import java.util.*;

public class Graph {

    // adjacency list: vertex -> neighbors
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // add vertex
    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // add edge with validation
    public void addEdge(int from, int to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            throw new IllegalArgumentException("Vertex does not exist");
        }
        adjList.get(from).add(to);
    }

    // print graph
    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // BFS traversal using queue
    public void bfs(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start vertex not found");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal using recursion
    public void dfs(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start vertex not found");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}