package algz.sorts;

import algz.Utils;

public class InsertionSort {

  public Integer[] sort(Integer[] array){
      int n = array.length;
      Integer[] r = Utils.arrayFullCopy(n, array);

      for(int i=1; i<n; i++){
          int j = i;
          while(j > 0 && r[j] < r[j-1]){
              Utils.swap(j, j-1, r);
              j--;
          }
      }

      return r;
  }
}
