package algz.graph;

import algz.Utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class StronglyConnectedComponents {
    private static int SIZE;
    private boolean[] visited;
    private Integer countV;
    private List<List<Integer>> graph;//small graph
    private List<List<Integer>> graphRev;
    private Deque<Integer> stack = new ArrayDeque<Integer>();

    public StronglyConnectedComponents(List<List<Integer>> graph, int size) {
        SIZE = size;
        this.graph = graph;
        graphRev = reverseGraph(graph);

        visited = new boolean[SIZE];
        countV = 0;
        Arrays.fill(visited, false);
    }

    public List<Integer> countSCCs() {
        dfsLoop1(graphRev);
        List<Integer> result =  dfsLoop2(graph);
        return result;
    }

    private void dfs(List<List<Integer>> graph, int i, boolean s) {
        for(int v: graph.get(i)){
            if(!visited[v]){
                addVisited(v);
                dfs(graph, v, s);
                if(s) stack.push(v);
            }
        }
    }

    private void addVisited(Integer v){
        if(!visited[v]) countV++;
        visited[v] = true;
    }

    private void dfsLoop1(List<List<Integer>> graph) {
        for(int i = SIZE-1; i >=0; i--){
            if(!visited[i]){
                addVisited(i);
                dfs(graph, i, true);
                stack.push(i);
            }
        }
    }

    private List<Integer> dfsLoop2(List<List<Integer>> graph) {
        List<Integer> scc = new ArrayList<Integer>();
        Arrays.fill(visited, false);

        while(!stack.isEmpty()){
            Integer i = stack.pop();
            if(!visited[i]){
                countV = 0;
                addVisited(i);
                dfs(graph, i, false);
                scc.add(countV);
            }
        }

        return scc;
    }

    public List<List<Integer>> reverseGraph(List<List<Integer>> graph) {
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();

        for (int i = 0; i < SIZE; i++) {
            tmp.add(new LinkedList<Integer>());
        }

        for (int s = 0; s < SIZE; s++) {
            for (Integer end : graph.get(s)) {
                tmp.get(end).add(s);
            }
        }

        return tmp;
    }
}
