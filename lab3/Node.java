public class Node {
  Word theWord;
  Node next;

  public Word getWord() {
    return theWord;
  }

  public Node getNext() {
    return next;
  }

  public Node(String word, int count) {
    theWord = new Word(word, count);
  }

  public Node findBotton() {
    if(this.getNext() == null) {
      return this;
    } else {
      return this.getNext().findBotton();
    }
  }

  public void setNext(Node n) {
    next = n;
  }
}
