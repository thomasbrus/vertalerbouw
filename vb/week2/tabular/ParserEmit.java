package vb.week2.tabular;

public class ParserEmit extends Parser {
  private String output;

  public ParserEmit(Scanner scanner) {
    super(scanner);
    output = "";
  }

  protected void nextChar() throws SyntaxError {
    if(currentToken != null && (currentToken.getKind().equals(Token.Kind.IDENTIFIER) || currentToken.getKind().equals(Token.Kind.NUM)))
        output += currentToken.getRepr();
    this.currentToken = scanner.scan();
  }

  protected void parseRows() throws SyntaxError{
    if(currentToken.getKind().equals(Token.Kind.RCURLY)) return;
    while(currentToken.getKind().equals(Token.Kind.NUM) || currentToken.getKind().equals(Token.Kind.IDENTIFIER) || currentToken.getKind().equals(Token.Kind.AMPERSAND)){
      output += "  <tr>\r\n";
      parseEntries();
      nextChar(Token.Kind.DOUBLE_BSLASH);
      output += "  </tr>\r\n";
    }
  }

  protected void parseEntry() throws SyntaxError {
    output += "    <td>";
    super.parseEntry();
    output += "</td>\r\n";
  }

  protected void parseBeginTabular() throws SyntaxError {
    super.parseBeginTabular();
    output += "<table border=\"1\">\r\n";
  }

  protected void parseEndTabular() throws SyntaxError {
    super.parseEndTabular();
    output += "</table>\r\n";
  }

  public String getOutput(){
    return "<html><body>\r\n" + output + "</body></html>";
  }

  public static void main(String[] vargs){
    Scanner s = new Scanner(System.in);
    ParserEmit p = new ParserEmit(s);
    if(p.parse()){
      System.out.println(p.getOutput());
    }
  }
}
