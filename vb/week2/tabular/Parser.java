package vb.week2.tabular;

import vb.week2.tabular.Token.Kind;

public class Parser {
  protected Scanner scanner;
  protected Token currentToken;

  /**
  * @param scanner the Scanner object to be used for parsing
  * @requires scanner != null;
  */
  public Parser(Scanner scanner) {
    this.scanner = scanner;
    this.currentToken = null;
  }

  protected void nextChar() throws SyntaxError {
    this.currentToken = scanner.scan();
  }

  protected void nextChar(Token.Kind kind) throws SyntaxError {
    if(currentToken.getKind().equals(kind)){
      this.currentToken = scanner.scan();
    } else {
      throw new SyntaxError("Unexpected token " + currentToken.getKind() + " while expecting " + kind);
    }
  }

  protected void parseLatexTabular() throws SyntaxError{
    parseBeginTabular();
    parseColsSpec();
    parseRows();
    parseEndTabular();
  }

  protected void parseColsSpec() throws SyntaxError {
    nextChar(Token.Kind.LCURLY);
    nextChar(Token.Kind.IDENTIFIER);
    nextChar(Token.Kind.RCURLY);
  }

  protected void parseRows() throws SyntaxError {
    while (currentToken.getKind().equals(Token.Kind.DOUBLE_BSLASH) ||
           currentToken.getKind().equals(Token.Kind.AMPERSAND) ||
           currentToken.getKind().equals(Token.Kind.NUM) ||
           currentToken.getKind().equals(Token.Kind.IDENTIFIER)) {
      parseRow();
    }
  }

  protected void parseRow() throws SyntaxError {
    parseEntries();
    nextChar(Token.Kind.DOUBLE_BSLASH);
  }

  protected void parseEntries() throws SyntaxError {
    // Support multiple entries inbetween ampersands by replacing
    // this with a while loop
    if (currentToken.getKind().equals(Token.Kind.NUM) ||
        currentToken.getKind().equals(Token.Kind.IDENTIFIER)) {
      parseEntry();
    }

    if (currentToken.getKind().equals(Token.Kind.AMPERSAND)) {
      nextChar(Token.Kind.AMPERSAND); parseEntries();
    }
  }

  protected void parseEntry() throws SyntaxError {
    if (currentToken.getKind().equals(Token.Kind.IDENTIFIER)) {
      nextChar(Token.Kind.IDENTIFIER);
    } else if (currentToken.getKind().equals(Token.Kind.NUM)) {
      nextChar(Token.Kind.NUM);
    } else {
      throw new SyntaxError("Unexpected token " + currentToken.getKind() + " while expecting NUM or IDENTIFIER");
    }
  }

  protected void parseBeginTabular() throws SyntaxError {
    nextChar(Token.Kind.BSLASH);
    nextChar(Token.Kind.BEGIN);
    nextChar(Token.Kind.LCURLY);
    nextChar(Token.Kind.TABULAR);
    nextChar(Token.Kind.RCURLY);
  }

  protected void parseEndTabular() throws SyntaxError {
    nextChar(Token.Kind.BSLASH);
    nextChar(Token.Kind.END);
    nextChar(Token.Kind.LCURLY);
    nextChar(Token.Kind.TABULAR);
    nextChar(Token.Kind.RCURLY);
  }

  /**
  * Parses the input as LaTeX tabular specification.
  * @returns {@code true} if parsing was successful
  */
  public boolean parse() {
    try {
      nextChar();
      parseLatexTabular();
      if(currentToken.getKind() != Token.Kind.EOT)
        new SyntaxError("Unexpected token " + currentToken.getKind() + " while expecting " + Token.Kind.EOT);
    } catch (SyntaxError e) {
      System.err.println(e);
      return false;
    }
    return true;
  }

  public static void main(String[] vargs){
    Scanner s = new Scanner(System.in);
    Parser p = new Parser(s);
    if(p.parse()){
      System.out.println("Successfully parsed.");
    } else {
      System.out.println("An error occured while parsing.");
    }

  }
}
