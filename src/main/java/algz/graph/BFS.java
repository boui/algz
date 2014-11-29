package algz.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

    private boolean[] visited;
    private Queue<Integer> queue;
    private List<List<Integer>> graph;

    public BFS(List<List<Integer>> graph) {
        visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        queue = new LinkedList<Integer>();
        this.graph = graph;
    }

    public void traverse(Integer vertex) {
        if (!visited[vertex]) {
            visited[vertex] = true;

            System.out.println(vertex+1);
            for (Integer v : graph.get(vertex)) {
                if (!visited[v]) queue.offer(v);
            }
        }

        if (!queue.isEmpty()) {
            traverse(queue.poll());
        }

    }
}
