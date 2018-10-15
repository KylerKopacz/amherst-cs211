import java.util.Scanner;

public class Reverser {
  public CS211Stack<Character> stack = new CS211Stack<Character>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Reverser r = new Reverser();

    System.out.println("Please enter the string that you want reversed.");
    String s = in.nextLine();
    System.out.println(r.reverse(s));
  }

  public Reverser(){}

  public String reverse(String s) {
    String reversed = "";
    stack.init();

    if(s.length() > 0) {
      for(int i = 0; i < s.length(); i++) {
        stack.push(s.charAt(i));
      }
      for(int i = 0; i < s.length(); i++) {
        if(stack.size() != 0) {
          reversed += stack.pop();
        }
      }
      return reversed;
    }
    return "Error: Please enter a string.";
  }
}
