package algz.eulerproject;

public class T9 {

    public int findProduct() {
        int b;
        boolean found = true;
        for(int c=5; c<500; c++){
            for(int a = 3; a<500; a++){
               b = runComparison(a, c);
               if(b>0){
                   return a*b*c;
               }
            }

        }
        return -1;
    }

    public int runComparison(int a, int c){
        for(int b = a+1; b<500;b++){
            if(isEqual(a,b, c)){
                if(a+b+c == 1000){
                   return b;
                }
            }
        }
        return -1;
    }

    private int getCSqr(int a, int b){
        return a*a+b*b;
    }
    private boolean isEqual(int a, int b, int c){
        return a*a+b*b == c*c;
    }

    private boolean isABLess(int a, int b, int c){
        return a*a+b*b < c*c;
    }

}
