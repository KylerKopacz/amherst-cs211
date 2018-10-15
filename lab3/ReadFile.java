import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ReadFile {
	private String fileName;

	public ReadFile(String s) {
		fileName = s;
	}

	public void setFileName(String s) {
		fileName = s;
	}

	public void addFileToDict(CountingDictionary dict) {
		Vector<String> words = this.process();
		for(int i = 0; i < words.size(); i++) {
			dict.insert(words.get(i));
		}
	}

	public void addFileToDict(CountingDictionary dict, CountingDictionary commonWords) {
		Vector<Word> common = commonWords.allKeyValue();
		Vector<String> checkCommon = this.process();
		Vector<String> commonVector = new Vector<String>();

		for(Word w: common) {
			commonVector.add(w.getString().toLowerCase());
		}

		for(String check: checkCommon) {
			if(!commonVector.contains(check.toLowerCase())) {
				dict.insert(check);
			}
		}
	}

	public Vector<String> process() {

		File f = new File(fileName);
		Scanner sc = null;

		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Is it possible that file "+fileName+" does not exist?");
			System.exit(-1);
		}

		Vector<String> toR = new Vector<String>();

		while (sc.hasNext()) {
			toR.add(sc.next());
		}

		return toR;
	}
}
