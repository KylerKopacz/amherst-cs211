import java.util.Vector;
public class CountingDictionary implements CS211CountingDictionaryInterface {
  Node[] dict;
  int sizeOfDict;

  public CountingDictionary(int size) {
    dict = new Node[size];
    sizeOfDict = size;
  }

  /* insert the given key storing 1 as the value if the key does not already exist
  *  if the key already
  *  exists, increment the associated value
  */
  public void insert(String key) {
    //we need to get the index of the key
    String convertedKey = key.toLowerCase();
    int index = this.hash(convertedKey);
    if(dict[index] == null) {
      dict[index] = new Node(convertedKey, 1);
    } else {
      Node top = dict[index];
      do {
        if(top.getWord().getString().equals(convertedKey)) {
          top.getWord().addCount();
          break;
        } else {
          if(top.getNext() == null) {
            top.setNext(new Node(convertedKey, 1));
            break;
          } else {
            top = top.getNext();
          }
        }
      } while(true);
    }
    //System.out.println("Inserted " + key);
  }

  /* delete the given key, if the key was in the dictionary, return true
	 * otherwise, return false  Implementing this is optional unless you use
	 * an array as your D/S, in which case it is required
	 */
	public boolean delete(String key) {
    return true;
  }

  /* return the value associated with the given key,  If the key is NOT in the dictionary,
	 * return -1
	 */
	public int find(String key) {
    return -1;
  }

  /* return a list of all the key-value Words in the dictionary.  If your D/S is
	 * a BST or an ordered array, they should be in order.
	 */
	public Vector<Word> allKeyValue() {
    Vector<Word> allWords = new Vector<Word>();
    Node top;
    for(int i = 0; i < sizeOfDict; i++) {
      if(dict[i] != null) {
        top = dict[i];
        allWords.add(top.getWord());
        while(top.getNext() != null) {
          top = top.getNext();
          allWords.add(top.getWord());
        }
      }
    }
    System.out.println("Added all the words to a vector");
    return allWords;
  }

  public int hash(String key) {
    int index = 5;
    for(int i = 0; i < key.length(); i++) {
      index = index * 7 + key.charAt(i);
    }
    return Math.abs(index % sizeOfDict);
  }

  public void printDictionary(Vector<Word> v) {
    int sum = 0;
    for(Word w: v) {
      System.out.println(w.toString());
      sum += w.getCount();
    }
    System.out.println("Printed " + v.size() + " word objects. There were " + sum  + " words (strings) total.");
  }

}
