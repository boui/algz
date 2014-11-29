package algz.graph;

import algz.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//17
public class MinimalContraction {
    private Random r = new Random();
    public int count(Map<Integer, LinkedList<Integer>> currentList){
        Utils.Tuple t = determineRandomEdgeNumber(currentList);
        collapseEdge(currentList, t.v1, t.v2);

        if(currentList.size() == 2){
            Integer[] r = new Integer[2];
            int c = 0;
            for(Map.Entry<Integer, LinkedList<Integer>> e: currentList.entrySet()){
                r[c] = e.getValue().size(); c++;
            }
            return Math.min(r[0], r[1]);
        }

        return count(currentList);
    }

    private void collapseEdge(Map<Integer, LinkedList<Integer>> currentList, int v1, int v2){
        int targetV = Math.min(v1, v2);
        int toRemoveV = Math.max(v1, v2);

        LinkedList<Integer> toMergeEdges = currentList.get(toRemoveV);
        currentList.remove(toRemoveV);

        for(Integer e:toMergeEdges){
            if(!e.equals(targetV)){
                currentList.get(targetV).add(e);
            }
        }


        for(Map.Entry<Integer, LinkedList<Integer>> e: currentList.entrySet()){
            for(int i=0; i< e.getValue().size(); i++){
                if(e.getValue().get(i).equals(toRemoveV)){
                    e.getValue().set(i, targetV);
                }
            }
        }

        currentList.get(targetV).removeAll(Arrays.asList(targetV));
    }

    private Utils.Tuple determineRandomEdgeNumber(Map<Integer, LinkedList<Integer>> currentList){
        int n = currentList.entrySet().size();
        ArrayList<Utils.Tuple> tmp = new ArrayList<Utils.Tuple>(n*n);
        for(Map.Entry<Integer, LinkedList<Integer>> edges:currentList.entrySet()){
            for(int i=0; i<edges.getValue().size(); i++){
               if(!edges.getKey().equals(edges.getValue().get(i))){
                   tmp.add(new Utils.Tuple(edges.getKey(), edges.getValue().get(i)));
               }
            }
        }

        return tmp.get(r.nextInt(tmp.size()));
    }


}
