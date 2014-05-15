// $ANTLR 3.5.2 vb/week4/decluse/Decluse.g 2014-05-15 14:14:10

package vb.week4.decluse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class DecluseLexer extends Lexer {
	public static final int EOF=-1;
	public static final int D=4;
	public static final int LETTER=5;
	public static final int LOWER=6;
	public static final int LPAREN=7;
	public static final int RPAREN=8;
	public static final int U=9;
	public static final int UPPER=10;
	public static final int WS=11;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public DecluseLexer() {} 
	public DecluseLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public DecluseLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "vb/week4/decluse/Decluse.g"; }

	// $ANTLR start "D"
	public final void mD() throws RecognitionException {
		try {
			int _type = D;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week4/decluse/Decluse.g:11:3: ( 'D:' )
			// vb/week4/decluse/Decluse.g:11:5: 'D:'
			{
			match("D:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week4/decluse/Decluse.g:12:8: ( '(' )
			// vb/week4/decluse/Decluse.g:12:10: '('
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

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week4/decluse/Decluse.g:13:8: ( ')' )
			// vb/week4/decluse/Decluse.g:13:10: ')'
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

	// $ANTLR start "U"
	public final void mU() throws RecognitionException {
		try {
			int _type = U;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week4/decluse/Decluse.g:14:3: ( 'U:' )
			// vb/week4/decluse/Decluse.g:14:5: 'U:'
			{
			match("U:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "U"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// vb/week4/decluse/Decluse.g:46:4: ( ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+ )
			// vb/week4/decluse/Decluse.g:46:6: ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+
			{
			// vb/week4/decluse/Decluse.g:46:6: ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// vb/week4/decluse/Decluse.g:
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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

	// $ANTLR start "LOWER"
	public final void mLOWER() throws RecognitionException {
		try {
			// vb/week4/decluse/Decluse.g:48:16: ( ( 'a' .. 'z' ) )
			// vb/week4/decluse/Decluse.g:
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
			// vb/week4/decluse/Decluse.g:49:16: ( ( 'A' .. 'Z' ) )
			// vb/week4/decluse/Decluse.g:
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
			// vb/week4/decluse/Decluse.g:50:17: ( LOWER | UPPER )
			// vb/week4/decluse/Decluse.g:
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
		// vb/week4/decluse/Decluse.g:1:8: ( D | LPAREN | RPAREN | U | WS )
		int alt2=5;
		switch ( input.LA(1) ) {
		case 'D':
			{
			alt2=1;
			}
			break;
		case '(':
			{
			alt2=2;
			}
			break;
		case ')':
			{
			alt2=3;
			}
			break;
		case 'U':
			{
			alt2=4;
			}
			break;
		case '\t':
		case '\n':
		case '\f':
		case '\r':
		case ' ':
			{
			alt2=5;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 2, 0, input);
			throw nvae;
		}
		switch (alt2) {
			case 1 :
				// vb/week4/decluse/Decluse.g:1:10: D
				{
				mD(); 

				}
				break;
			case 2 :
				// vb/week4/decluse/Decluse.g:1:12: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 3 :
				// vb/week4/decluse/Decluse.g:1:19: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 4 :
				// vb/week4/decluse/Decluse.g:1:26: U
				{
				mU(); 

				}
				break;
			case 5 :
				// vb/week4/decluse/Decluse.g:1:28: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
