// $ANTLR 3.5.2 vb/week3/calc/Calc.g 2014-05-08 16:09:48

package vb.week3.calc;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcLexer extends Lexer {
	public static final int EOF=-1;
	public static final int BECOMES=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int DIGIT=7;
	public static final int DIV=8;
	public static final int IDENTIFIER=9;
	public static final int INTEGER=10;
	public static final int LETTER=11;
	public static final int LOWER=12;
	public static final int LPAREN=13;
	public static final int MINUS=14;
	public static final int MUL=15;
	public static final int NUMBER=16;
	public static final int PLUS=17;
	public static final int PRINT=18;
	public static final int PROGRAM=19;
	public static final int RPAREN=20;
	public static final int SEMICOLON=21;
	public static final int UPPER=22;
	public static final int VAR=23;
	public static final int WS=24;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public CalcLexer() {} 
	public CalcLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalcLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "vb/week3/calc/Calc.g"; }

	// $ANTLR start "BECOMES"
	public final void mBECOMES() throws RecognitionException {
		try {
			int _type = BECOMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:11:9: ( ':=' )
			// vb/week3/calc/Calc.g:11:11: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BECOMES"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:12:7: ( ':' )
			// vb/week3/calc/Calc.g:12:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:13:5: ( '/' )
			// vb/week3/calc/Calc.g:13:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:14:9: ( 'integer' )
			// vb/week3/calc/Calc.g:14:11: 'integer'
			{
			match("integer"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:15:8: ( '(' )
			// vb/week3/calc/Calc.g:15:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:16:7: ( '-' )
			// vb/week3/calc/Calc.g:16:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MUL"
	public final void mMUL() throws RecognitionException {
		try {
			int _type = MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:17:5: ( '*' )
			// vb/week3/calc/Calc.g:17:7: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:18:6: ( '+' )
			// vb/week3/calc/Calc.g:18:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:19:7: ( 'print' )
			// vb/week3/calc/Calc.g:19:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "PROGRAM"
	public final void mPROGRAM() throws RecognitionException {
		try {
			int _type = PROGRAM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:20:9: ( 'program' )
			// vb/week3/calc/Calc.g:20:11: 'program'
			{
			match("program"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROGRAM"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:21:8: ( ')' )
			// vb/week3/calc/Calc.g:21:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:22:11: ( ';' )
			// vb/week3/calc/Calc.g:22:13: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:23:5: ( 'var' )
			// vb/week3/calc/Calc.g:23:7: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:95:5: ( LETTER ( LETTER | DIGIT )* )
			// vb/week3/calc/Calc.g:95:9: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); 

			// vb/week3/calc/Calc.g:95:16: ( LETTER | DIGIT )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// vb/week3/calc/Calc.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:99:5: ( ( DIGIT )+ )
			// vb/week3/calc/Calc.g:99:9: ( DIGIT )+
			{
			// vb/week3/calc/Calc.g:99:9: ( DIGIT )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// vb/week3/calc/Calc.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:104:5: ( '//' ( . )* '\\n' )
			// vb/week3/calc/Calc.g:104:9: '//' ( . )* '\\n'
			{
			match("//"); 

			// vb/week3/calc/Calc.g:104:14: ( . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\n') ) {
					alt3=2;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// vb/week3/calc/Calc.g:104:14: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match('\n'); 
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week3/calc/Calc.g:109:5: ( ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+ )
			// vb/week3/calc/Calc.g:109:9: ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+
			{
			// vb/week3/calc/Calc.g:109:9: ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||(LA4_0 >= '\f' && LA4_0 <= '\r')||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// vb/week3/calc/Calc.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// vb/week3/calc/Calc.g:113:17: ( ( '0' .. '9' ) )
			// vb/week3/calc/Calc.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "LOWER"
	public final void mLOWER() throws RecognitionException {
		try {
			// vb/week3/calc/Calc.g:114:17: ( ( 'a' .. 'z' ) )
			// vb/week3/calc/Calc.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWER"

	// $ANTLR start "UPPER"
	public final void mUPPER() throws RecognitionException {
		try {
			// vb/week3/calc/Calc.g:115:17: ( ( 'A' .. 'Z' ) )
			// vb/week3/calc/Calc.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPPER"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// vb/week3/calc/Calc.g:116:17: ( LOWER | UPPER )
			// vb/week3/calc/Calc.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	@Override
	public void mTokens() throws RecognitionException {
		// vb/week3/calc/Calc.g:1:8: ( BECOMES | COLON | DIV | INTEGER | LPAREN | MINUS | MUL | PLUS | PRINT | PROGRAM | RPAREN | SEMICOLON | VAR | IDENTIFIER | NUMBER | COMMENT | WS )
		int alt5=17;
		switch ( input.LA(1) ) {
		case ':':
			{
			int LA5_1 = input.LA(2);
			if ( (LA5_1=='=') ) {
				alt5=1;
			}

			else {
				alt5=2;
			}

			}
			break;
		case '/':
			{
			int LA5_2 = input.LA(2);
			if ( (LA5_2=='/') ) {
				alt5=16;
			}

			else {
				alt5=3;
			}

			}
			break;
		case 'i':
			{
			int LA5_3 = input.LA(2);
			if ( (LA5_3=='n') ) {
				int LA5_19 = input.LA(3);
				if ( (LA5_19=='t') ) {
					int LA5_22 = input.LA(4);
					if ( (LA5_22=='e') ) {
						int LA5_26 = input.LA(5);
						if ( (LA5_26=='g') ) {
							int LA5_30 = input.LA(6);
							if ( (LA5_30=='e') ) {
								int LA5_33 = input.LA(7);
								if ( (LA5_33=='r') ) {
									int LA5_36 = input.LA(8);
									if ( ((LA5_36 >= '0' && LA5_36 <= '9')||(LA5_36 >= 'A' && LA5_36 <= 'Z')||(LA5_36 >= 'a' && LA5_36 <= 'z')) ) {
										alt5=14;
									}

									else {
										alt5=4;
									}

								}

								else {
									alt5=14;
								}

							}

							else {
								alt5=14;
							}

						}

						else {
							alt5=14;
						}

					}

					else {
						alt5=14;
					}

				}

				else {
					alt5=14;
				}

			}

			else {
				alt5=14;
			}

			}
			break;
		case '(':
			{
			alt5=5;
			}
			break;
		case '-':
			{
			alt5=6;
			}
			break;
		case '*':
			{
			alt5=7;
			}
			break;
		case '+':
			{
			alt5=8;
			}
			break;
		case 'p':
			{
			int LA5_8 = input.LA(2);
			if ( (LA5_8=='r') ) {
				switch ( input.LA(3) ) {
				case 'i':
					{
					int LA5_23 = input.LA(4);
					if ( (LA5_23=='n') ) {
						int LA5_27 = input.LA(5);
						if ( (LA5_27=='t') ) {
							int LA5_31 = input.LA(6);
							if ( ((LA5_31 >= '0' && LA5_31 <= '9')||(LA5_31 >= 'A' && LA5_31 <= 'Z')||(LA5_31 >= 'a' && LA5_31 <= 'z')) ) {
								alt5=14;
							}

							else {
								alt5=9;
							}

						}

						else {
							alt5=14;
						}

					}

					else {
						alt5=14;
					}

					}
					break;
				case 'o':
					{
					int LA5_24 = input.LA(4);
					if ( (LA5_24=='g') ) {
						int LA5_28 = input.LA(5);
						if ( (LA5_28=='r') ) {
							int LA5_32 = input.LA(6);
							if ( (LA5_32=='a') ) {
								int LA5_35 = input.LA(7);
								if ( (LA5_35=='m') ) {
									int LA5_37 = input.LA(8);
									if ( ((LA5_37 >= '0' && LA5_37 <= '9')||(LA5_37 >= 'A' && LA5_37 <= 'Z')||(LA5_37 >= 'a' && LA5_37 <= 'z')) ) {
										alt5=14;
									}

									else {
										alt5=10;
									}

								}

								else {
									alt5=14;
								}

							}

							else {
								alt5=14;
							}

						}

						else {
							alt5=14;
						}

					}

					else {
						alt5=14;
					}

					}
					break;
				default:
					alt5=14;
				}
			}

			else {
				alt5=14;
			}

			}
			break;
		case ')':
			{
			alt5=11;
			}
			break;
		case ';':
			{
			alt5=12;
			}
			break;
		case 'v':
			{
			int LA5_11 = input.LA(2);
			if ( (LA5_11=='a') ) {
				int LA5_21 = input.LA(3);
				if ( (LA5_21=='r') ) {
					int LA5_25 = input.LA(4);
					if ( ((LA5_25 >= '0' && LA5_25 <= '9')||(LA5_25 >= 'A' && LA5_25 <= 'Z')||(LA5_25 >= 'a' && LA5_25 <= 'z')) ) {
						alt5=14;
					}

					else {
						alt5=13;
					}

				}

				else {
					alt5=14;
				}

			}

			else {
				alt5=14;
			}

			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt5=14;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt5=15;
			}
			break;
		case '\t':
		case '\n':
		case '\f':
		case '\r':
		case ' ':
			{
			alt5=17;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// vb/week3/calc/Calc.g:1:10: BECOMES
				{
				mBECOMES(); 

				}
				break;
			case 2 :
				// vb/week3/calc/Calc.g:1:18: COLON
				{
				mCOLON(); 

				}
				break;
			case 3 :
				// vb/week3/calc/Calc.g:1:24: DIV
				{
				mDIV(); 

				}
				break;
			case 4 :
				// vb/week3/calc/Calc.g:1:28: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 5 :
				// vb/week3/calc/Calc.g:1:36: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 6 :
				// vb/week3/calc/Calc.g:1:43: MINUS
				{
				mMINUS(); 

				}
				break;
			case 7 :
				// vb/week3/calc/Calc.g:1:49: MUL
				{
				mMUL(); 

				}
				break;
			case 8 :
				// vb/week3/calc/Calc.g:1:53: PLUS
				{
				mPLUS(); 

				}
				break;
			case 9 :
				// vb/week3/calc/Calc.g:1:58: PRINT
				{
				mPRINT(); 

				}
				break;
			case 10 :
				// vb/week3/calc/Calc.g:1:64: PROGRAM
				{
				mPROGRAM(); 

				}
				break;
			case 11 :
				// vb/week3/calc/Calc.g:1:72: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 12 :
				// vb/week3/calc/Calc.g:1:79: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 13 :
				// vb/week3/calc/Calc.g:1:89: VAR
				{
				mVAR(); 

				}
				break;
			case 14 :
				// vb/week3/calc/Calc.g:1:93: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 15 :
				// vb/week3/calc/Calc.g:1:104: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 16 :
				// vb/week3/calc/Calc.g:1:111: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 17 :
				// vb/week3/calc/Calc.g:1:119: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
