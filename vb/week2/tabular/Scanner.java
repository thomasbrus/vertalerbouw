package vb.week2.tabular;

import java.io.IOException;
import java.io.InputStream;

import vb.week2.tabular.Token.Kind;

public class Scanner {
    private int             currentLineNr = 0;
    private InputStream     in;

    private static final char cSPACE    = ' ',
            cTAB      = '\t',
            cEOLr     = '\r',
            cEOLn     = '\n',
            cPERCENT  = '%',
            cEOT      = '\u0000',         /* End OF Text */
            cBSLASH   = '\u005C\u005C';
    // == '\\'
    // We cannot use the '\\' denotation here because
    // otherwise LaTeX's listings package will get very
    // confused. Students should use '\\' of course.

    /**
     * Constructor.
     * @param in the stream from which the characters will be read
     */
    public Scanner(InputStream in) {
        this.in = in;
    }


    /* Returns the next character.
     * Returns cEOT when end-of-file or in case of an error. */
    private char getNextChar() {
        try {
            int ch = this.in.read();

            if (ch == -1) {
                ch = cEOT;
            } else if (ch == cEOLn) {
                this.currentLineNr++;
            }

            return (char)ch;
        } catch (IOException e) {
            return cEOT;
        }
    }

    private char checkNextChar() {
    		this.in.mark(1);
    		char currentChar = getNextChar();
    		return currentChar;
    }

    private void resetChar() {
    	try {
			this.in.reset();
		} catch (IOException e) { e.printStackTrace(); }
    }


    /**
     * Returns the next Token from the input.
     * @return the next Token
     * @throws SyntaxError when an unknown or unexpected character
     *         has been found in the input.
     */
    public Token scan() throws SyntaxError
    {
        char currentChar = getNextChar();
        if(currentChar == cPERCENT)
	        	while(currentChar != cEOLr && currentChar != cEOLn) currentChar = getNextChar();

        while(currentChar == cSPACE || currentChar == cTAB || currentChar == cEOLr || currentChar == cEOLn)
        	currentChar = getNextChar();


        switch(currentChar){
        	case cEOT: return new Token(Kind.EOT, "\\eot");
	        case '{' : return new Token(Kind.LCURLY,"{");
	        case '}' : return new Token(Kind.RCURLY,"}");
	        case '-' : return new Token(Kind.BAR,"-");
	        case cBSLASH: if(checkNextChar() == cBSLASH) return new Token(Kind.DOUBLE_BSLASH,"\\\\");
						  this.resetChar();
						  return new Token(Kind.BSLASH,"\\");
	        case '&' : return new Token(Kind.AMPERSAND,"&");
        }

        String identifier = "";
        if (Character.isLetter(currentChar)) {
          identifier += currentChar;
          currentChar = checkNextChar();

          while (Character.isLetter(currentChar) || Character.isDigit(currentChar)) {
            identifier += currentChar;
            currentChar = checkNextChar();
          }
        }
        if(!identifier.isEmpty()){ this.resetChar(); return new Token(Kind.IDENTIFIER, identifier); }

        while(Character.isDigit(currentChar)){
        	identifier += currentChar;
        	currentChar = checkNextChar();
        }
        if(!identifier.isEmpty()) { this.resetChar(); return new Token(Kind.NUM, identifier); }

        throw new SyntaxError ("Character not recognized:" + currentChar);


    }

    public static void main (String[] vargs){
    	Scanner scanner =  new Scanner(System.in);
    	try {
    	Token token = scanner.scan();
    	while(token != null){
    		System.out.println(token.getKind() + "\t" + token.getRepr());
    		token = scanner.scan();
    	}
    	System.out.println("Scanning OK. Number of lines: " + scanner.currentLineNr);
    	} catch(SyntaxError e){
    		System.err.println(e);
    	}
    }

}
/** Exception class to signal problems with the SymbolTable */
class SyntaxError extends Exception {
    /** {@link serialVersionUID} is required for Serializable */
    public static final long serialVersionUID = 24362463L;
    public SyntaxError(String msg) { super(msg); }
}
