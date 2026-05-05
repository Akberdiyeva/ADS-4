public class Experiment {

    public void runTraversals(Graph g) {

        System.out.println("\n--- BFS ---");
        long start = System.nanoTime();
        g.bfs(0);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        System.out.println("\n--- DFS ---");
        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));
    }
}