import java.util.Vector;

public class Trie implements CS211CountingDictionaryInterface {

	TrieNode root = new TrieNode();

	public void insert(String key) {
		root.insert(key,"");
	}

	public boolean delete(String key) {
		if (root.find(key)==null)
			return false;
		else root.delete(key);
		return true;
	}

	public int find(String key) {
		if (root == null)
			return -1;
		else {
			Word w = root.find(key);
			if (w==null)
				return -1;
			else return w.getCount();
		}
	}

	public Vector<Word> prefixMatch(String start) {
		Vector v = new Vector<Word>();
		root.prefixMatch(v,start);
		return v;
	}

	public Vector<Word> spellCheck1(String start) {
		Vector v = new Vector<Word>();
		root.spellCheck1(v,start);
		return v;
	}

	@Override
	public Vector<Word> allKeyValue() {
		Vector v = new Vector<Word>();
		root.allKeyValue(v);
		return v;
	}

	public Vector<Word> spellCheck2(String key, int errs) {
		Vector ws = new Vector<Word>();
		root.spellCheck2(ws,key,errs+1);
		return ws;
	}

	public void print() {
		root.print("");
	}

	public String findShortestWord() {
		return root.findShortestWord();
	}

	public Vector<Word> findWordsThatEndWith(char c) {
		Vector ws = new Vector<Word>();
		root.findWordsThatEndWith(ws, c);
		return ws;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("hello");
		t.insert("why");;
		t.insert("hellor");
		t.insert("hello");
		t.insert("mezzo");
		t.insert("mezza");
		t.insert("freehand");
		t.insert("freehold");
		t.insert("freshman");
		t.insert("frequent");
		t.insert("frenzy");
		//t.insert("a");
		t.insert("he");
		t.insert("him");
		t.insert("there");
		t.insert("general");
		t.insert("kenobi");
		t.insert("ken");
		t.insert("zen");
		t.insert("new");
		t.insert("not");
		t.insert("caw");
		t.insert("cow");
		t.insert("cry");
		t.insert("gawp");
		t.insert("train");
		t.insert("pain");
		t.insert("stain");
		t.insert("rain");
		t.insert("lain");
		t.insert("plain");
		t.insert("grain");



		t.print();

		System.out.println("================================================");
		System.out.println(t.find("hello"));
		System.out.println(t.find("hellor"));
		System.out.println(t.find("why"));

		System.out.println("================================================");
		System.out.println("All Key Value");
		Vector<Word> ws = t.allKeyValue();
		for (Word w: ws) {
			System.out.println("WS "+w);
		}

		//testing prefix matching
		System.out.println("================================================");
		System.out.println("Prefix Match");
		ws = t.prefixMatch("hel");
		for (Word w: ws) {
			System.out.println("SS "+w);
		}

		System.out.println("================================================");
		System.out.println("Prefix Match Mez");
		ws = t.prefixMatch("mez");
		for(Word w: ws) {
			System.out.println("SS "+w);
		}

		System.out.println("================================================");
		System.out.println("Prefix Match H");
		ws = t.prefixMatch("h");
		for(Word w: ws) {
			System.out.println("SS "+w);
		}

		System.out.println("================================================");
		System.out.println("Spell Check 1");
		ws = t.spellCheck1("fre");
		for (Word w: ws) {
			System.out.println("ST "+w);
		}

		System.out.println("================================================");
		System.out.println("Spell Check 2");
		ws = t.spellCheck2("hezzo",2);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}

		System.out.println("================================================");
		System.out.println("Spell Check 2");
		ws = t.spellCheck2("ben",1);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}

		System.out.println("================================================");
		System.out.println("Spell Check 2");
		ws = t.spellCheck2("nat",2);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}

		System.out.println("================================================");
		System.out.println("Spell Check 2");
		ws = t.spellCheck2("crw",1);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}

		System.out.println("================================================");
		System.out.println("Spell Check 2");
		ws = t.spellCheck2("zpwp",2);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}

		System.out.println("================================================");
		System.out.println("Finding the Shortest");
		System.out.println(t.findShortestWord());

		System.out.println("================================================");
		System.out.println("Find all words that end in: n");
		ws = t.findWordsThatEndWith('n');
		for (Word w: ws) {
			System.out.println(w);
		}

		//testing delete
		System.out.println("================================================");
		System.out.println(t.delete("why"));
		System.out.println(t.delete("mezzo"));
		System.out.println(t.delete("mezza"));
		System.out.println(t.delete("hey"));
		System.out.println(t.delete("ken"));


		System.out.println("================================================");
		t.print();
	}
}
