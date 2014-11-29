package algz.graph;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Dijkstra {
    Map<Integer, List<Edge>> graph;
    private boolean[] visited;
    private int[] distance;

    class Edge implements Comparable {
        private int vertex;
        private int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }


        @Override
        public String toString() {
            return "{" + vertex + "=>" + weight + "}";
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.weight, ((Edge) o).weight);
        }
    }

    public Dijkstra() {
        try {
            readGraph();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = graph.size();

        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        visited = new boolean[n];
        Arrays.fill(visited, false);

    }

    public void dijkstra(Integer from) {
        int n = graph.size();
        distance[from] = 0;

        int v = from;

        while (!visited[v]) {
            visited[v] = true;
            for (Edge edge : graph.get(v)) {
                if (distance[edge.vertex] > distance[v] + edge.weight) {
                    distance[edge.vertex] = distance[v] + edge.weight;
                }
            }

            v = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < distance.length; i++) {
                if (!visited[i] && min > distance[i]) {
                    min = distance[i];
                    v = i;
                }
            }

            if(min == Integer.MAX_VALUE) break;
        }

        System.out.println(Arrays.toString(distance));
    }

    public void readGraph() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream("Dijkstra.txt")));
        graph = new HashMap<Integer, List<Edge>>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] edge = line.split(" ");

            Integer from = Integer.parseInt(edge[0]) - 1;
            Integer to = Integer.parseInt(edge[1]) - 1;
            Integer dist = Integer.parseInt(edge[2]);
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<Edge>());
            }
            if (!graph.containsKey(to)) {
                graph.put(to, new ArrayList<Edge>());
            }
            graph.get(from).add(new Edge(to, dist));
        }
    }
}
