import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Experiment exp = new Experiment();

        // 10 вершин
        System.out.println("===== GRAPH 10 =====");
        Graph g10 = createGraph(10);
        g10.printGraph();
        exp.runTraversals(g10);

        // 30 вершин
        System.out.println("\n===== GRAPH 30 =====");
        Graph g30 = createGraph(30);
        exp.runTraversals(g30);

        // 100 вершин
        System.out.println("\n===== GRAPH 100 =====");
        Graph g100 = createGraph(100);
        exp.runTraversals(g100);
    }

    // генерация графа
    public static Graph createGraph(int size) {
        Graph g = new Graph();
        Random rand = new Random();

        // создаём вершины
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        // создаём случайные связи
        for (int i = 0; i < size; i++) {
            int edges = rand.nextInt(3) + 1; // 1–3 связи

            for (int j = 0; j < edges; j++) {
                int to = rand.nextInt(size);
                if (to != i) {
                    g.addEdge(i, to);
                }
            }
        }

        return g;
    }
}