public class Operator {
  private char type;
  private int prec;

  public Operator(char operation, int basePrecidence) {
    type = operation;
    if(type == '-' || type == '+') {
      prec = 1 + basePrecidence;
    } else if(type == '/' || type == '*') {
      prec = 2 + basePrecidence;
    }
  }

  public int getPrec() {
    return this.prec;
  }

  public char getType() {
    return this.type;
  }
}
