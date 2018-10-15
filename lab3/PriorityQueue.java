import java.util.Vector;

public class PriorityQueue<V extends Comparable> implements CS211PriorityQueueInterface<V> {
  //the actual queue
  private Comparable[] theQ;

  //the number of things in the array, and the index that we are currently on
  private int size;
  private int index;

  public PriorityQueue(int capacity) {
    index = 1;
    size = 0;
    theQ = new Comparable[capacity];
  }

  //inserts something into the underlying array, and bubbles
  public void insert(V w){
    //insert the thing
    theQ[index] = w;

    //time to bubble up to see if it is in the right place
    this.bubbleUp(index);
    index++;
  }

  //returns the first thing in the queue
  public V peek(){
    return (V) theQ[1];
  }

  //takes the first thing out of the array and returns it, and bubbles
  public V remove(){
    //make a copy of the thing
    Comparable returnMe = theQ[1];

    //switch the things, decrease the size, and bubble down
    theQ[1] = theQ[size];
    theQ[size] = null;
    size--;
    bubbleDown(1);

    //return the thing
    return (V) returnMe;
  }

  public void bubbleDown(int position) {
    //now we have the positions of the things we need to compare
    int parent = position;
    int leftChild = parent * 2;
    int rightChild = parent * 2 + 1;

    //instead of checking if there are child nodes, we can simply use them
    //if they are there, and if not then we don't have to
    Comparable greatest = theQ[parent];

    //now we need to compare the left child with the parent, assuming it exists
    if(leftChild < size && theQ[leftChild].compareTo(theQ[parent]) == 1 ) {
      greatest = theQ[leftChild];
    }

    //now we need to check the right child, assuming it exists
    if(rightChild < size && theQ[rightChild].compareTo(greatest) == 1 ) {
      greatest = theQ[rightChild];
    }

    //now if the greatest is not the parent, then we have to swap
    if(!greatest.equals(theQ[parent])) {
      if(greatest.equals(theQ[leftChild])) {
        Comparable swap = theQ[parent];
        theQ[parent] = theQ[leftChild];
        theQ[leftChild] = swap;
        bubbleDown(leftChild);
      } else {
        Comparable swap = theQ[parent];
        theQ[parent] = theQ[rightChild];
        theQ[rightChild] = swap;
        bubbleDown(rightChild);
      }
    }
  }

  public void bubbleUp(int lastElement) {
    //start with a value that is the last element in the array
    int child = lastElement;

    //if its not the root, then we will keep checking its value to its parent
    //and keep swapping until we reach the top of the tree.
		while(child > 1 && theQ[child].compareTo(theQ[child/2]) == 1) {
      Comparable tmp = theQ[child];
      theQ[child] = theQ[child/2];
      theQ[child/2] = tmp;
      child /= 2;
    }
  }

  //takes everything from the vector and adds it to the queue
  public void build(Vector<V> words){
    System.out.println(words.size());

    //this resets the index so we can overwrite things that might be
    //there if we switch the queue style
    index = 1;
    size = words.size();
    for(V thing: words) {
      this.insert(thing);
    }
    System.out.println("Queue built");
  }

  //checks to see if the array is empty
  public boolean isEmpty(){
    if(size == 0) {
      return true;
    } else {
      return false;
    }
  }
}
