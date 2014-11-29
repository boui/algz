package algz.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class DFS {
    private boolean[] visited;
    private Deque<Integer> stack;
    private List<List<Integer>> graph;

    public DFS(List<List<Integer>> graph){
        visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        stack = new ArrayDeque<Integer>();
        this.graph = graph;

    }

    public void traverse(){
        traverse(0);
    }

    public void traverse(Integer from){
        if(!visited[from]){
            visited[from] = true;
            stack.push(from);

            System.out.println(from+1);
            for(Integer v : graph.get(from)){
                if(!visited[v]){
                    traverse(v);
                }
            }

            stack.pop();
        }
    }
}
