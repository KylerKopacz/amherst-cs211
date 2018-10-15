import java.util.Vector;

public class TrieNode {

	private Word wordHere;

	private TrieNode[] links;

	public TrieNode() {
		wordHere = null;
		links= new TrieNode[26];
	}

	private int let(char c) {
		return c - 'a';
	}

	private char firstChar(String key) {
		return key.charAt(0);
	}

	private String rest(String key) {
		return key.substring(1,key.length());
	}

	private TrieNode linkWordStart(String start) {
		return links[let(firstChar(start))];
	}

	public void insert(String key, String toHere) {
		//now that we have the node that we have, we need to traverse down to
		//place it
		String remainingString = key;
		TrieNode nodeStep = this;
		for(int i = 0; i < key.length(); i++) {
			//we need to make a node to insert
			TrieNode addedNode = new TrieNode();
			//this is traversing down the tree to find the node that we need to make
			if(nodeStep.linkWordStart(remainingString) == null) {
				nodeStep.links[let(firstChar(remainingString))] = addedNode;
				nodeStep = addedNode;
			} else {
				nodeStep = nodeStep.links[let(firstChar(remainingString))];
			}
			System.out.println(remainingString);
			remainingString = rest(remainingString);

		}
		//now we have nodeStep equal to the place that we need to to insert
		if(nodeStep.wordHere != null && nodeStep.wordHere.getString().equals(key)) {
			nodeStep.wordHere.addCount();
		} else {
			nodeStep.setWord(key);
		}
		System.out.println("Inserted " + key);
	}


	public Word find(String key) {
		if (key.length() == 0) {
			if (wordHere==null)
				return null;
			else return wordHere;
		}
		else {
			if (linkWordStart(key) == null)
				return null;
			else return linkWordStart(key).find(rest(key));
		}
	}

	public boolean delete(String key) {
		return delete(key,key);
	}

	public boolean delete(String key, String keyRemaining) {
		String findMe = key;
		String remaining = keyRemaining;
		//this is the base case
		if(wordHere != null && wordHere.getString().equalsIgnoreCase(findMe)) {
			//System.out.println("Found the thing!");
			if(anyChildren() == true) {
				//System.out.println("Has children, not deleting");
				wordHere = null;
				return false;
			} else {
				//System.out.println("No children, deleting");
				return true;
			}
		} else {
			if(remaining.length() == 0) {
				//System.out.println("Apparently we could not find the thing.");
				return false;
			}
			//this is the parent case
			//System.out.println("Not found, Accessing Child");
			boolean deletedPrev = linkWordStart(remaining).delete(key,rest(remaining));
			//System.out.println("After boolean");
			if(deletedPrev) {
				//System.out.println("Accessed if, and deleted child");

				links[let(firstChar(remaining))] = null;
				if(anyChildren() == true) {
					//System.out.println("Not deleting child, returning false");
					return false;
				} else {
					//System.out.println("Deleting child, returning true.");
					return true;
				}
			} else {
				//System.out.println("You did not delete the previous node");
				return false;
			}
		}
	}

	public boolean anyChildren() {
		for(int i = 0; i < 26; i++) {
			if(links[i] != null) {
				return true;
			}
		}
		return false;
	}

	public void allKeyValue(Vector<Word> v) {
		getWords(v);
	}

	public void getWords(Vector<Word> v) {
		if(wordHere != null) {
			v.add(wordHere);
		}
		for(int i = 0; i < 26; i++) {
			if(links[i] != null) {
				links[i].getWords(v);
			}
		}
	}

	public void prefixMatch(Vector<Word> v, String start){
		Vector<Word> allWords = new Vector<Word>();
		allKeyValue(allWords);
		for(Word w: allWords) {
			if(w.getString().startsWith(start)) {
				//System.out.println("Added " + w.getString());
				v.add(w);
			}
		}
	}

	public void spellCheck1(Vector v, String start) {
		//base case we need to see if we have reached the end of the word, or if
		//we have reached the longest prefix
		if(start.length() > 0) {
			if(linkWordStart(start) == null) {
				//we have reached the point where this is the longest prefix of any word
				getWords(v);
			} else {
				//if this runs, that means that there are more words that have this prefix
				//and we need to go down another node to see if there is more matches
				linkWordStart(start).spellCheck1(v, rest(start));
			}
		} else {
			//this runs when we have reached the end of the prefix
		  getWords(v);
		}
	}

	public void spellCheck2(Vector ws, String key, int errs) {
		if(key.length() > 0) {
			//System.out.println("Key greater than 0");
			for(int i = 0; i < 26; i++) {
				if(links[i] != null) {
					//System.out.println("found link that wasnt null");
					if((char) i + 97 == firstChar(key)) {
						//System.out.println("index matched first character of key");
						links[i].spellCheck2(ws, rest(key), errs);
					} else {
						//System.out.println("index did not match, adding error");
						links[i].spellCheck2(ws, rest(key), errs - 1);
					}
				}
			}
		} else {
			//System.out.println("reached the end of the target word");
			if(wordHere != null && errs >= 1) {
				ws.add(wordHere);
			}
		}
	}

	public String findShortestWord() {
		Vector<Word> words = new Vector<Word>();
		getWords(words);
		String shortest = words.get(1).getString();
		for(Word w: words) {
			if(w.getString().length() < shortest.length()) {
				shortest = w.getString();
			}
		}
		return shortest;
	}

	public void findWordsThatEndWith(Vector v, char c) {
		Vector<Word> words = new Vector<Word>();
		getWords(words);
		for(Word w: words) {
			if(w.getString().charAt(w.getString().length() - 1) == c) {
				v.add(w);
			}
		}
	}

	public void print(String string) {
		if (wordHere != null)
			System.out.println(string+" "+wordHere);
		else System.out.println(string+" empty");
		for (int i =0; i<26; i++) {
			if (links[i]!=null){
				links[i].print(string+"-");
			}
		}
	}

	public void setWord(String word) {
		wordHere = new Word(word,1);
	}
}
