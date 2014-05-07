package vb.week2.tabular;

public class HTMLEmitter extends Parser {
  private StringBuilder output;

  public HTMLEmitter(Lexer lexer) {
    super(lexer);
    this.output = new StringBuilder();
  }

  public String toString() {
    return this.output.toString();
  }

  public void parse() throws SyntaxError {
    this.output.append("<html>\r\n<body>\r\n");
    super.parse();
    this.output.append("</body>\r\n</html>");
  }

  protected void parseBeginTabular() throws SyntaxError {
    this.output.append("\t<table>\r\n"); super.parseBeginTabular();
  }

  protected void parseRow() throws SyntaxError {
    this.output.append("\t\t<tr>\r\n");
    super.parseRow();
    this.output.append("\t\t</tr>\r\n");
  }

  protected void parseEntry() throws SyntaxError {
    this.output.append("\t\t\t<td>");

    if (canReadToken(Token.Kind.IDENTIFIER) || canReadToken(Token.Kind.NUM)) {
      this.output.append(super.nextToken().getRepr()); super.parseEntry();
    }

    this.output.append("<td>\r\n");
  }

  protected void parseEndTabular() throws SyntaxError {
    super.parseEndTabular(); this.output.append("\t</table>\r\n");
  }

  public static void main(String[] args) {
    Lexer lexer = new Lexer(System.in);
    HTMLEmitter emitter = new HTMLEmitter(lexer);

    try {
      emitter.parse();
      System.out.println(emitter);
    } catch (SyntaxError e) {
      System.err.println("Syntax error: " + e.getMessage());
    }
  }
}
