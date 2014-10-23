package algz.sorts.algz.sorts.again;

import algz.Utils;

/**
 * User: boui
 * Date: 10/16/14
 */
public class BubleSort {
   public Integer[] sort(Integer[] array){
       int n = array.length;
       Integer[] result = Utils.arrayFullCopy(n, array);

       for(int i = n-1; i >  0; i--){
         for(int j = 0; j<i; j++){
           if(result[i]<result[j]){
               Utils.swap(i, j, result);
           }
         }
       }

       return result;
   }
}
