package algz.graph;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Prim {
    Map<Integer, List<Edge>> graph;
    private boolean[] visited;
    private int[] distance;
    private int[] parent;

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

    public Prim() {
        try {
            readGraph();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = graph.size();

        visited = new boolean[n];
        distance = new int[n];
        parent = new int[n];

        Arrays.fill(visited, false);
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
    }

    /**
     * Minimal spanning tree
     */
    public Map<Integer, List<Edge>> prim() {
        int n = graph.size();
        Map<Integer, List<Edge>> map = new HashMap<Integer, List<Edge>>();

        distance[0] = 0;
        int v = 0;

        map.put(0, new ArrayList<Edge>());

        int minD = Integer.MAX_VALUE;
        while(!visited[v]){
            visited[v] = true;

            for(Edge edge : graph.get(v)){
                if(!visited[edge.vertex] && distance[edge.vertex]>edge.weight){
                    distance[edge.vertex] = edge.weight;
                    parent[edge.vertex] = v;
                }
            }

            v = 0;
            minD = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(!visited[i] && minD>distance[i]){
                    v = i;
                    minD = distance[i];
                }
            }
        }



        for(int i=0; i< parent.length; i++){
            if(parent[i] != -1){
                if(!map.containsKey(parent[i])) map.put(parent[i], new ArrayList<Edge>());
                map.get(parent[i]).add(new Edge(i, distance[i]));
            }
        }

        return map;
    }

    public void readGraph() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream("Prim.txt")));
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
            graph.get(to).add(new Edge(from, dist));
        }
    }
}

