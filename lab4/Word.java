
public class Word implements Comparable<Word> {

	private String theWord;
	private int theCount;

	//this is added to we can make a min or max queue
	private static boolean isMinHeap;

	public String toString() {
		return theWord+"  "+theCount;
	}

	public Word(String word, Integer count) {
		//by default, we will make this a min heap
		isMinHeap = true;

		//we set the other variables to be their values that are passed in
		theWord = word;
		theCount = count;
	}

	/* compare to should return a positive number if this is greater
	 * than other, 0 if they are equal and a negative number if this is less.
	 *
	 * this is greater (less than) if its count is greater (less than) that of
	 * other.  If the counts are equal, you should determine which theWord is
	 * larger as a String.  compareTo is implemented in Java for Strings, you
	 * should use it
	 */
	public int compareTo(Word other) {
		if(isMinHeap) {
			if(this.getCount() < other.getCount()) {
				return 1;
			} else if(this.getCount() > other.getCount()) {
				return -1;
			} else {
				if(this.getString().compareTo(other.getString()) > 0) {
					return -1;
				} else {
					return 1;
				}
			}
		} else {
			if(this.getCount() > other.getCount()) {
				return 1;
			} else if(this.getCount() < other.getCount()) {
				return -1;
			} else {
				if(this.getString().compareTo(other.getString()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}

	public String getString() {
		return theWord;
	}

	public void addCount() {
		theCount++;
	}

	public int getCount() {
		return theCount;
	}

	public boolean isMinHeap() {
		return isMinHeap;
	}

	public static void setMinHeap(boolean isMin) {
		isMinHeap = isMin;
	}
}
