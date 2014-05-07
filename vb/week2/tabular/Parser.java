package vb.week2.tabular;
import vb.week2.tabular.Token.Kind;

public class Parser {
  // General syntax error class
  static class SyntaxError extends Exception {
    private static final long serialVersionUID = 1L;

    public SyntaxError(String message, int lineNumber) {
      super(message + " at line " + lineNumber);
    }
  }

  // Exception that occurs when an unexpected token is encountered
  static class UnexpectedTokenError extends SyntaxError {
    private static final long serialVersionUID = 1L;

    public UnexpectedTokenError(Token actualToken, int lineNumber) {
      super("Unexpected token: '" + actualToken.getRepr() + "'", lineNumber);
    }

    public UnexpectedTokenError(Token actualToken, Token.Kind expectedKind, int lineNumber) {
      super("Unexpected token: '" + actualToken.getRepr() + "'" +
        " , expecting " + expectedKind, lineNumber);
    }

    public UnexpectedTokenError(Token actualToken, Token.Kind expectedKind, Token.Kind alternativeKind, int lineNumber) {
      super("Unexpected token: '" + actualToken.getRepr() + "'" +
        " , expecting " + expectedKind  +
        " or " + alternativeKind, lineNumber);
    }
  }

  protected Lexer lexer;

  public Parser(Lexer lexer) {
    this.lexer = lexer;
  }

  public int getCurrentLineNumber() {
    return this.lexer.getCurrentLineNumber();
  }

  public void parse() throws SyntaxError {
    parseLatexTabular();
    readToken(Token.Kind.EOT);
  }

  protected void parseLatexTabular() throws SyntaxError {
    parseBeginTabular();
    parseColsSpec();
    parseRows();
    parseEndTabular();
  }

  protected void parseBeginTabular() throws SyntaxError {
    readToken(Token.Kind.BSLASH);
    readToken(Token.Kind.BEGIN);
    readToken(Token.Kind.LCURLY);
    readToken(Token.Kind.TABULAR);
    readToken(Token.Kind.RCURLY);
  }

  protected void parseColsSpec() throws SyntaxError {
    readToken(Token.Kind.LCURLY);
    readToken(Token.Kind.IDENTIFIER);
    readToken(Token.Kind.RCURLY);
  }

  protected void parseRows() throws SyntaxError {
    while (canReadToken(Token.Kind.DOUBLE_BSLASH) ||
           canReadToken(Token.Kind.AMPERSAND) ||
           canReadToken(Token.Kind.NUM) ||
           canReadToken(Token.Kind.IDENTIFIER)) {
      parseRow();
    }
  }

  protected void parseRow() throws SyntaxError {
    parseEntries(); readToken(Token.Kind.DOUBLE_BSLASH);
  }

  protected void parseEntries() throws SyntaxError {
    parseEntry();

    if (canReadToken(Token.Kind.AMPERSAND)) {
      readToken(Token.Kind.AMPERSAND);
      parseEntries();
    }
  }

  protected void parseEntry() throws SyntaxError {
    if (!canReadToken(Token.Kind.AMPERSAND) && !canReadToken(Token.Kind.DOUBLE_BSLASH)) {
      readToken(Token.Kind.IDENTIFIER, Token.Kind.NUM);
    }
  }

  protected void parseEndTabular() throws SyntaxError {
    readToken(Token.Kind.BSLASH);
    readToken(Token.Kind.END);
    readToken(Token.Kind.LCURLY);
    readToken(Token.Kind.TABULAR);
    readToken(Token.Kind.RCURLY);
  }

  // Returns the next token without advancing the parser
  protected Token nextToken() throws SyntaxError {
    return this.lexer.nextToken();
  }

  // Returns whether a token of the given kind can be read
  protected boolean canReadToken(Token.Kind kind) {
    try {
      return nextToken().getKind() == kind;
    } catch (SyntaxError e) {
      return false;
    }
  }

  // Advances the scanner by reading one token
  private Token readToken() throws SyntaxError {
    return this.lexer.readToken();
  }

  // Advances the parser if a token of the given kind is found,
  // otherwise throws an error
  private Token readToken(Token.Kind expectedKind) throws SyntaxError {
    Token actualToken = readToken();

    if (actualToken.getKind() != expectedKind) {
      throw new UnexpectedTokenError(actualToken, expectedKind, this.getCurrentLineNumber());
    }

    return actualToken;
  }

  // Advances the parser if either one of the two tokens is found,
  // otherwise throws an error
  private Token readToken(Token.Kind expectedKind, Token.Kind alternativeKind) throws SyntaxError {
    Token actualToken = readToken();
    Token.Kind actualTokenKind = actualToken.getKind();

    if (actualTokenKind != expectedKind && actualTokenKind != alternativeKind) {
      throw new UnexpectedTokenError(actualToken, expectedKind, alternativeKind, this.getCurrentLineNumber());
    }

    return actualToken;
  }

  public static void main(String[] args) {
    Lexer lexer = new Lexer(System.in);
    Parser parser = new Parser(lexer);

    try {
      parser.parse();
      System.out.println("Successfully parsed.");
    } catch (SyntaxError e) {
      System.err.println("Syntax error: " + e.getMessage());
    }
  }
}
