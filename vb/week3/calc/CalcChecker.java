// $ANTLR 3.5.2 vb/week3/calc/CalcChecker.g 2014-05-08 16:31:45

package vb.week3.calc;
import java.util.Set;
import java.util.HashSet;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcChecker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BECOMES", "COLON", "COMMA", "COMMENT", 
		"DIGIT", "DIV", "IDENTIFIER", "INTEGER", "LETTER", "LOWER", "LPAREN", 
		"MINUS", "MUL", "NUMBER", "PLUS", "PRINT", "PROGRAM", "RPAREN", "SEMICOLON", 
		"SWAP", "UPPER", "VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int BECOMES=4;
	public static final int COLON=5;
	public static final int COMMA=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int IDENTIFIER=10;
	public static final int INTEGER=11;
	public static final int LETTER=12;
	public static final int LOWER=13;
	public static final int LPAREN=14;
	public static final int MINUS=15;
	public static final int MUL=16;
	public static final int NUMBER=17;
	public static final int PLUS=18;
	public static final int PRINT=19;
	public static final int PROGRAM=20;
	public static final int RPAREN=21;
	public static final int SEMICOLON=22;
	public static final int SWAP=23;
	public static final int UPPER=24;
	public static final int VAR=25;
	public static final int WS=26;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public CalcChecker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalcChecker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return CalcChecker.tokenNames; }
	@Override public String getGrammarFileName() { return "vb/week3/calc/CalcChecker.g"; }


	    // idset - a set of declared identifiers.
	    private Set<String> idset = new HashSet<String>();

	    public boolean  isDeclared(String s)     { return idset.contains(s); }
	    public void     declare(String s)        { idset.add(s);             }



	// $ANTLR start "program"
	// vb/week3/calc/CalcChecker.g:30:1: program : ^( PROGRAM ( declaration | statement )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// vb/week3/calc/CalcChecker.g:31:5: ( ^( PROGRAM ( declaration | statement )+ ) )
			// vb/week3/calc/CalcChecker.g:31:9: ^( PROGRAM ( declaration | statement )+ )
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program94); 
			match(input, Token.DOWN, null); 
			// vb/week3/calc/CalcChecker.g:31:19: ( declaration | statement )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==VAR) ) {
					alt1=1;
				}
				else if ( (LA1_0==BECOMES||LA1_0==PRINT||LA1_0==SWAP) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:31:20: declaration
					{
					pushFollow(FOLLOW_declaration_in_program97);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:31:34: statement
					{
					pushFollow(FOLLOW_statement_in_program101);
					statement();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); 

			}

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declaration"
	// vb/week3/calc/CalcChecker.g:34:1: declaration : ^( VAR id= IDENTIFIER type ) ;
	public final void declaration() throws RecognitionException {
		CommonTree id=null;

		try {
			// vb/week3/calc/CalcChecker.g:35:5: ( ^( VAR id= IDENTIFIER type ) )
			// vb/week3/calc/CalcChecker.g:35:9: ^( VAR id= IDENTIFIER type )
			{
			match(input,VAR,FOLLOW_VAR_in_declaration124); 
			match(input, Token.DOWN, null); 
			id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration128); 
			pushFollow(FOLLOW_type_in_declaration130);
			type();
			state._fsp--;

			match(input, Token.UP, null); 

			   if (isDeclared((id!=null?id.getText():null)))
			                throw new CalcException(id, "is already declared");
			            else
			                declare(id.getText());
			        
			}

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration"



	// $ANTLR start "statement"
	// vb/week3/calc/CalcChecker.g:43:1: statement : ( ^( BECOMES id= IDENTIFIER expr ) | ^( PRINT expr ) | ^( SWAP IDENTIFIER IDENTIFIER ) );
	public final void statement() throws RecognitionException {
		CommonTree id=null;

		try {
			// vb/week3/calc/CalcChecker.g:44:5: ( ^( BECOMES id= IDENTIFIER expr ) | ^( PRINT expr ) | ^( SWAP IDENTIFIER IDENTIFIER ) )
			int alt2=3;
			switch ( input.LA(1) ) {
			case BECOMES:
				{
				alt2=1;
				}
				break;
			case PRINT:
				{
				alt2=2;
				}
				break;
			case SWAP:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:44:9: ^( BECOMES id= IDENTIFIER expr )
					{
					match(input,BECOMES,FOLLOW_BECOMES_in_statement161); 
					match(input, Token.DOWN, null); 
					id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement165); 
					pushFollow(FOLLOW_expr_in_statement167);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					   if (!isDeclared((id!=null?id.getText():null)))
					                throw new CalcException(id, "is not declared");
					        
					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:48:9: ^( PRINT expr )
					{
					match(input,PRINT,FOLLOW_PRINT_in_statement189); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_statement191);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// vb/week3/calc/CalcChecker.g:49:9: ^( SWAP IDENTIFIER IDENTIFIER )
					{
					match(input,SWAP,FOLLOW_SWAP_in_statement203); 
					match(input, Token.DOWN, null); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement205); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement207); 
					match(input, Token.UP, null); 

					}
					break;

			}
		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "expr"
	// vb/week3/calc/CalcChecker.g:52:1: expr : ( expr2 | ^( PLUS expr expr ) | ^( MINUS expr expr ) );
	public final void expr() throws RecognitionException {
		try {
			// vb/week3/calc/CalcChecker.g:53:5: ( expr2 | ^( PLUS expr expr ) | ^( MINUS expr expr ) )
			int alt3=3;
			switch ( input.LA(1) ) {
			case DIV:
			case IDENTIFIER:
			case MUL:
			case NUMBER:
				{
				alt3=1;
				}
				break;
			case PLUS:
				{
				alt3=2;
				}
				break;
			case MINUS:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:53:9: expr2
					{
					pushFollow(FOLLOW_expr2_in_expr227);
					expr2();
					state._fsp--;

					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:54:9: ^( PLUS expr expr )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr238); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr240);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr242);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// vb/week3/calc/CalcChecker.g:55:9: ^( MINUS expr expr )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr254); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr256);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr258);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "expr2"
	// vb/week3/calc/CalcChecker.g:58:1: expr2 returns [int val = 0] : ( operand | ^( MUL expr expr ) | ^( DIV e1= expr e2= expr ) );
	public final int expr2() throws RecognitionException {
		int val =  0;


		try {
			// vb/week3/calc/CalcChecker.g:59:5: ( operand | ^( MUL expr expr ) | ^( DIV e1= expr e2= expr ) )
			int alt4=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
			case NUMBER:
				{
				alt4=1;
				}
				break;
			case MUL:
				{
				alt4=2;
				}
				break;
			case DIV:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:59:9: operand
					{
					pushFollow(FOLLOW_operand_in_expr2282);
					operand();
					state._fsp--;

					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:60:9: ^( MUL expr expr )
					{
					match(input,MUL,FOLLOW_MUL_in_expr2293); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr2295);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr2297);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// vb/week3/calc/CalcChecker.g:61:9: ^( DIV e1= expr e2= expr )
					{
					match(input,DIV,FOLLOW_DIV_in_expr2309); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr2313);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr2317);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return val;
	}
	// $ANTLR end "expr2"



	// $ANTLR start "operand"
	// vb/week3/calc/CalcChecker.g:64:1: operand : (id= IDENTIFIER |n= NUMBER );
	public final void operand() throws RecognitionException {
		CommonTree id=null;
		CommonTree n=null;

		try {
			// vb/week3/calc/CalcChecker.g:65:5: (id= IDENTIFIER |n= NUMBER )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IDENTIFIER) ) {
				alt5=1;
			}
			else if ( (LA5_0==NUMBER) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:65:9: id= IDENTIFIER
					{
					id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand339); 
					 if (!isDeclared((id!=null?id.getText():null)))
					            throw new CalcException(id, "is not declared");
					        
					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:69:9: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_operand361); 
					}
					break;

			}
		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "operand"



	// $ANTLR start "type"
	// vb/week3/calc/CalcChecker.g:72:1: type : INTEGER ;
	public final void type() throws RecognitionException {
		try {
			// vb/week3/calc/CalcChecker.g:73:5: ( INTEGER )
			// vb/week3/calc/CalcChecker.g:73:9: INTEGER
			{
			match(input,INTEGER,FOLLOW_INTEGER_in_type380); 
			}

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"

	// Delegated rules



	public static final BitSet FOLLOW_PROGRAM_in_program94 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program97 = new BitSet(new long[]{0x0000000002880018L});
	public static final BitSet FOLLOW_statement_in_program101 = new BitSet(new long[]{0x0000000002880018L});
	public static final BitSet FOLLOW_VAR_in_declaration124 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration128 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_type_in_declaration130 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_statement161 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_statement165 = new BitSet(new long[]{0x0000000000078600L});
	public static final BitSet FOLLOW_expr_in_statement167 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_statement189 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_statement191 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SWAP_in_statement203 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_statement205 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_IDENTIFIER_in_statement207 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr2_in_expr227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expr238 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr240 = new BitSet(new long[]{0x0000000000078600L});
	public static final BitSet FOLLOW_expr_in_expr242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr254 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr256 = new BitSet(new long[]{0x0000000000078600L});
	public static final BitSet FOLLOW_expr_in_expr258 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expr2282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MUL_in_expr2293 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2295 = new BitSet(new long[]{0x0000000000078600L});
	public static final BitSet FOLLOW_expr_in_expr2297 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr2309 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2313 = new BitSet(new long[]{0x0000000000078600L});
	public static final BitSet FOLLOW_expr_in_expr2317 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type380 = new BitSet(new long[]{0x0000000000000002L});
}
