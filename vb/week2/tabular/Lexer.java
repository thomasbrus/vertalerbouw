package vb.week2.tabular;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.regex.Pattern;
import java.util.ArrayList;

import vb.week2.tabular.Token.Kind;
import vb.week2.tabular.Parser.SyntaxError;

public class Lexer implements Cloneable {
  // Exception that occurs when a character is found that is not in the grammar
  static class UnexpectedCharacterError extends Parser.SyntaxError {
    private static final long serialVersionUID = 1L;

    public UnexpectedCharacterError(char encounteredCharacter, int lineNumber) {
      super("Unexpected character: '" + encounteredCharacter + "'", lineNumber);
    }
  }

  private int currentLineNumber = 1;
  private InputStream inputStream;

  private static final char cSPACE = ' ';
  private static final char cTAB = '\t';
  private static final char cEOLr = '\r';
  private static final char cEOLn = '\n';
  private static final char cPERCENT = '%';
  private static final char cEOT = '\u0000';
  private static final char cBSLASH = '\u005C\u005C';

  public Lexer(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public int getCurrentLineNumber() {
    return this.currentLineNumber;
  }

  // Returns the next token without affecting the lexer
  public Token nextToken() throws UnexpectedCharacterError {
    byte[] lookAheadBytes = new byte[32];

    try {
      this.inputStream.mark(32);
      this.inputStream.read(lookAheadBytes);
      this.inputStream.reset();
    } catch (IOException e) { return null; }

    ByteArrayInputStream lookAheadStream = new ByteArrayInputStream(lookAheadBytes);
    return new Lexer(lookAheadStream).readToken();
  }

  // Advances the lexer by reading a single token
  public Token readToken() throws UnexpectedCharacterError {
    while (receivesWhitespace()) { skipCharacter(); return readToken(); }
    if (receivesComment()) { skipLine(); return readToken(); }

    char currentCharacter = readCharacter();

    switch (currentCharacter) {
      case '{': return new Token(Kind.LCURLY, "{");
      case '}': return new Token(Kind.RCURLY, "}");
      case '-': return new Token(Kind.BAR, "-");
      case '&': return new Token(Kind.AMPERSAND, "&");
      case cEOT: return new Token(Kind.EOT, "\\eot");
    }

    if (currentCharacter == cBSLASH) {
      try {
        readCharacter(cBSLASH);
        return new Token(Kind.DOUBLE_BSLASH, "\\\\");
      } catch (UnexpectedCharacterError e) {
        return new Token(Kind.BSLASH,"\\");
      }
    }

    if (Character.isLetter(currentCharacter)) {
      return new Token(Kind.IDENTIFIER, currentCharacter + readPattern("[a-zA-Z0-9]+"));
    }

    if (Character.isDigit(currentCharacter)) {
      return new Token(Kind.NUM, currentCharacter + readPattern("[0-9]+"));
    }

    throw new UnexpectedCharacterError(currentCharacter, this.currentLineNumber);
  }

  // Returns the next character without advancing the inputstream
  private char nextCharacter() {
    this.inputStream.mark(1);
    char nextCharacter = readCharacter();
    // Throws IOException if: "this stream has not been marked or if
    // the mark has been invalidated."
    try { this.inputStream.reset(); } catch (IOException e) {};
    return nextCharacter;
  }

  // Checks whether the next character is an end of line character
  private boolean receivesEndOfLine() {
    return (nextCharacter() == cEOLr || nextCharacter() == cEOLn);
  }

  // Checks whether the next character is a whitespace character
  private boolean receivesWhitespace() {
    return Character.isWhitespace(nextCharacter());
  }

  // Checks whether the next character indicates a comment
  private boolean receivesComment() {
    return (nextCharacter() == cPERCENT);
  }

  // Ignore everything on this line and advance the lexer to the next line
  private void skipLine() {
    while (!receivesEndOfLine()) skipCharacter();
  }

  // Skip a single character
  private void skipCharacter() {
    if (nextCharacter() == cEOLn) this.currentLineNumber++;
    try { this.inputStream.skip(1); } catch (IOException e) {}
  }

  // Advance the inputstream by reading a single character. Also stores
  // the read character and increases the current line number if neccessary
  private char readCharacter() {
    try {
      int inputByte = this.inputStream.read();
      if (inputByte == -1) return cEOT;
      return (char)inputByte;
    } catch (IOException e) {
      return cEOT;
    }
  }

  // Advance the inputstream by reading the given character
  private char readCharacter(char expectedCharacter) throws UnexpectedCharacterError {
    if (nextCharacter() == expectedCharacter) {
      return readCharacter();
    } else {
      throw new UnexpectedCharacterError(nextCharacter(), this.currentLineNumber);
    }
  }

  // Consumes as much as possible from the input stream and returns the result
  private String readPattern(String regex) {
    String consumedInput = "";

    while (Pattern.matches(regex, consumedInput + nextCharacter())) {
      consumedInput += readCharacter();
    }

    return consumedInput;
  }

  public static void main (String[] args) {
    Lexer lexer = new Lexer(System.in);
    ArrayList<Token> tokens = new ArrayList<Token>();

    try {
      Token currentToken = lexer.readToken();

      while (currentToken.getKind() != Token.Kind.EOT) {
        tokens.add(currentToken);
        currentToken = lexer.readToken();
      }

      System.out.println("Lexer ran succesfully (scanned " +
        lexer.getCurrentLineNumber()  + " lines).");

      for (Token token : tokens) {
        System.out.println(token.getKind() + "\t" + token.getRepr());
      }

    } catch (UnexpectedCharacterError e) {
      System.err.println(e.getMessage());
    }
  }
}
