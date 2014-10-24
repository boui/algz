package algz.dstruct;

import algz.Utils;

public class Heap {
    private static int  max_size = 1000;
    private int last = 1;
    private int[] heap = new int[max_size];

//    create-heap: create an empty heap
    public Heap createHeap(){
        return new Heap();
    }

//    heapify: create a heap out of given array of elements
    public Heap heapify(int[] array) {
        int n = array.length;
        if (n < 1) return new Heap();
        if (n > max_size){
            throw new IllegalArgumentException();
        }

        for( int i = 0; i < n; i++) insert(array[i]);
        return this;
    }

//    find-max or find-min: find the maximum item of a max-heap or a minimum item of a min-heap (aka, peek)
    public int findMin(){
        return heap[1];
    }

//    delete-max or delete-min: removing the root node of a max- or min-heap, respectively
    public void deleteMin(){
        Utils.swap(1, last-1, heap);
        last--;
        shiftDown(1);
    }

//    ExtractMin() [or ExtractMax()]: Returns the node of minimum value from a min heap [or maximum value from a max heap] after removing it from the heap
    public int extractMin(){
        int tmp = heap[1];

        deleteMin();
        return tmp;
    }


//    insert: adding a new key to the heap
    public Heap insert(int value){
        if(last+1 > max_size) throw new IllegalArgumentException();
        heap[last] = value;
        shiftUp(last);
        last+=1;
        return this;
    }

//    Shift-up: Move a node up in the tree, as long as needed (depending on the heap condition: min-heap or max-heap)
    public void shiftUp(int pos){
        int parentPos = getParent(pos);
        if(parentPos == -1) return;
        if(heap[parentPos] >= heap[pos]){
            Utils.swap(parentPos, pos, heap);
            shiftUp(parentPos);
        }
    }

//    Shift-down: Move a node down in the tree, similar to Shift-up
    public void shiftDown(int pos){
        int c1;//left child position
        int c2;//right child position
        int minPos = pos;
        c1 = getLessChild(pos); c2 = c1+1;

        if(c1 < last && heap[pos] > heap[c1]) minPos = c1;
        if(c2 < last && heap[pos] > heap[c2] && heap[c1] > heap[c2]) minPos = c2;

        if(minPos != pos){
            Utils.swap(minPos, pos, heap);
            shiftDown(minPos);
        }
    }

    private int getParent(int pos){
        if(pos == 1) return -1;
        return pos/2;
    }

    private int getLessChild(int position){
        return 2*position;
    }

//  size: return the number of items in the heap.
    public int getActualSize(){
        return last;
    }

//   isEmpty(): returns true if the heap is empty, false otherwise.
    public boolean isEmpty(){
        return last == 1;
    }

    /**???*/
//  merge: joining two heaps to form a valid new heap containing all the elements of both.
//  meld(h1,h2): Return the heap formed by taking the union of the item-disjoint heaps h1 and h2. Melding destroys h1 and h2.
//  Union(): Creates a new heap by joining two heaps given as input.
    /**???*/
}
