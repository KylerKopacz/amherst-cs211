import java.util.Vector;

public class CS211Stack<E> {

	private Vector<E> theStack;


	public void init() {
		theStack = new Vector<E>();
	}

	public void push(E x) {
		theStack.add(x);
	}

	public E pop() {
		if (theStack.size()!=0)
			return theStack.remove(theStack.size()-1);
		else return null;
	}

	public E top() {
		if (theStack.size()!=0)
			return theStack.elementAt(theStack.size()-1);
		else return null;
	}

	public boolean isEmpty() {
		return theStack.size() == 0;
	}

	public E peek() {
		return top();
	}

	public void debugPrintStack() {
		System.out.println("____________________________");
		for (E x : theStack)
			System.out.println(x);
		System.out.println("____________________________");
	}

	public int size() {
		return theStack.size();
	}
}
