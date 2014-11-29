package algz.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class RunClass {

    public static void main(String[] argv){

//        try {
//
//            MinimalContraction alg = new MinimalContraction();
//            for(int i=0; i<20; i++){
//                Map<Integer, LinkedList<Integer>> graph = readMinimalContractionGraph("graph.txt");
//                System.out.println(alg.count(graph));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


//        try {
//            StronglyConnectedComponents alg = new StronglyConnectedComponents(readSCCGraph("SCC.txt", 875714), 875714);
//            StronglyConnectedComponents alg = new StronglyConnectedComponents("SCC1.txt", 12);
//        StronglyConnectedComponents alg = new StronglyConnectedComponents("SCC2.txt", 4);
//        StronglyConnectedComponents alg = new StronglyConnectedComponents("SCC3.txt", 4);
//        System.out.println("start counting");
//        List<Integer> res = alg.countSCCs();
//        System.out.println("started sorting");
//        Collections.sort(res);
//        Collections.reverse(res);
//        System.out.println("finished sorting");
//        System.out.println(res.subList(0, 5));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


//        try {
//
//            List<List<Integer>> g = readSCCGraph("DFS.txt",12);
////            DFS dfs = new DFS(g);
//            BFS bfs = new BFS(g);
////            dfs.traverse();
//            bfs.traverse(0);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        Dijkstra d = new Dijkstra();
        d.dijkstra(0);
//        Prim p = new Prim();
//        p.prim();
    }


    private static List<List<Integer>> readSCCGraph(String filename, int SIZE) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(filename)));

        List<List<Integer>> graph = new ArrayList<List<Integer>>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            graph.add(new LinkedList<Integer>());
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] vertexPair = line.trim().split("\\s");
            Integer start = Integer.parseInt(vertexPair[0]) - 1;
            Integer end = Integer.parseInt(vertexPair[1]) - 1;
            if(!start.equals(end)) graph.get(start).add(end);
        }

        scanner.close();
        return graph;
    }

    private static Map<Integer, LinkedList<Integer>> readMinimalContractionGraph(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));

        Map<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
        while(scanner.hasNextLine()){
            LinkedList<Integer> edgeL = new LinkedList<Integer>();
            String line = scanner.nextLine();
            String[] edges = line.trim().split("\\s");
            int vert = Integer.parseInt(edges[0]) - 1;
            for(int i=1; i<edges.length; i++){
                int tvert = Integer.parseInt(edges[i]) - 1;
                if(vert != tvert) edgeL.add(tvert);
            }
            graph.put(vert, edgeL);
        }
        scanner.close();
        return graph;
    }
}
