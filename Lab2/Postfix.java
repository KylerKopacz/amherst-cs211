import java.util.Scanner;

class Postfix {
  CS211Stack<Operator> stack = new CS211Stack<Operator>();

  public Postfix() {
    stack.init();
  }

  public String convert(Scanner in) {
    String output = "";
    int basePrecidence = 0;

    while (in.hasNext()) {
      if(in.hasNextInt()) {
        output += in.nextInt() + " ";
      } else {
        String nextThing = in.next();
        if(nextThing.length() > 1) {
          return "Error: Something you entered was not properly spaced. Make sure there is a spaced between everything.";
        }
        char nextChar = nextThing.charAt(0);
        if(nextChar != '+' && nextChar != '-' && nextChar != '/' && nextChar != '*' && nextChar != '(' && nextChar != ')' && nextChar != '=') {
          return "Error. Something you entered was not a +,-,/,*,(,), or =. Please fix and try again.";
        }

        switch (nextChar) {
          case '=':
            while(!stack.isEmpty()) {
              output += stack.pop().getType() + " ";
            }
            break;
          case '(':
            basePrecidence += 4;
            break;
          case ')':
            basePrecidence -= 4;
            break;
          default:
            Operator pushMe = new Operator(nextChar, basePrecidence);
            while(!stack.isEmpty() && stack.peek().getPrec() >= pushMe.getPrec()) {
              output += stack.pop().getType() + " ";
            }
            stack.push(pushMe);
            break;
        }
      }
      //stack.debugPrintStack();
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner getEq = new Scanner(System.in);
    System.out.println("Please enter the equation to be converted: ");
    String eq = getEq.nextLine();
    Scanner readS = new Scanner(eq);
    Postfix me = new Postfix();
    System.out.println(me.convert(readS));
  }
}
