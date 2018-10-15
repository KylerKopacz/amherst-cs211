import java.util.Vector;

public class TestLab3 {
  public static void main(String[] args) {
    CountingDictionary dictionary = new CountingDictionary(1000);
    ReadFile read = new ReadFile("TextFile1.txt");
    
    CountingDictionary common = new CountingDictionary(1000);
    CountingDictionary uncommon = new CountingDictionary(12000);
    read.setFileName("CommonWords.txt");
    read.addFileToDict(common);
    read.setFileName("TextFile2.txt");
    read.addFileToDict(uncommon, common);
    uncommon.printDictionary(uncommon.allKeyValue());
  }
}
