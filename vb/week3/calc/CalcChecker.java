// $ANTLR 3.5.2 vb/week3/calc/CalcChecker.g 2014-05-08 14:14:46

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BECOMES", "COLON", "COMMENT", 
		"DIGIT", "IDENTIFIER", "INTEGER", "LETTER", "LOWER", "LPAREN", "MINUS", 
		"NUMBER", "PLUS", "PRINT", "PROGRAM", "RPAREN", "SEMICOLON", "UPPER", 
		"VAR", "WS"
	};
	public static final int EOF=-1;
	public static final int BECOMES=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int DIGIT=7;
	public static final int IDENTIFIER=8;
	public static final int INTEGER=9;
	public static final int LETTER=10;
	public static final int LOWER=11;
	public static final int LPAREN=12;
	public static final int MINUS=13;
	public static final int NUMBER=14;
	public static final int PLUS=15;
	public static final int PRINT=16;
	public static final int PROGRAM=17;
	public static final int RPAREN=18;
	public static final int SEMICOLON=19;
	public static final int UPPER=20;
	public static final int VAR=21;
	public static final int WS=22;

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
				else if ( (LA1_0==BECOMES||LA1_0==PRINT) ) {
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
			match(input,VAR,FOLLOW_VAR_in_declaration128); 
			match(input, Token.DOWN, null); 
			id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration132); 
			pushFollow(FOLLOW_type_in_declaration134);
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
	// vb/week3/calc/CalcChecker.g:43:1: statement : ( ^( BECOMES id= IDENTIFIER expr ) | ^( PRINT expr ) );
	public final void statement() throws RecognitionException {
		CommonTree id=null;

		try {
			// vb/week3/calc/CalcChecker.g:44:5: ( ^( BECOMES id= IDENTIFIER expr ) | ^( PRINT expr ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==BECOMES) ) {
				alt2=1;
			}
			else if ( (LA2_0==PRINT) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:44:9: ^( BECOMES id= IDENTIFIER expr )
					{
					match(input,BECOMES,FOLLOW_BECOMES_in_statement167); 
					match(input, Token.DOWN, null); 
					id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement171); 
					pushFollow(FOLLOW_expr_in_statement173);
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
					match(input,PRINT,FOLLOW_PRINT_in_statement195); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_statement197);
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
	// $ANTLR end "statement"



	// $ANTLR start "expr"
	// vb/week3/calc/CalcChecker.g:51:1: expr : ( operand | ^( PLUS expr expr ) | ^( MINUS expr expr ) );
	public final void expr() throws RecognitionException {
		try {
			// vb/week3/calc/CalcChecker.g:52:5: ( operand | ^( PLUS expr expr ) | ^( MINUS expr expr ) )
			int alt3=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
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
					// vb/week3/calc/CalcChecker.g:52:9: operand
					{
					pushFollow(FOLLOW_operand_in_expr222);
					operand();
					state._fsp--;

					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:53:9: ^( PLUS expr expr )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr233); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr235);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr237);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// vb/week3/calc/CalcChecker.g:54:9: ^( MINUS expr expr )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr249); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr251);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr253);
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



	// $ANTLR start "operand"
	// vb/week3/calc/CalcChecker.g:57:1: operand : (id= IDENTIFIER |n= NUMBER );
	public final void operand() throws RecognitionException {
		CommonTree id=null;
		CommonTree n=null;

		try {
			// vb/week3/calc/CalcChecker.g:58:5: (id= IDENTIFIER |n= NUMBER )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IDENTIFIER) ) {
				alt4=1;
			}
			else if ( (LA4_0==NUMBER) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// vb/week3/calc/CalcChecker.g:58:9: id= IDENTIFIER
					{
					id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand279); 
					   if (!isDeclared((id!=null?id.getText():null)))
					                throw new CalcException(id, "is not declared");
					        
					}
					break;
				case 2 :
					// vb/week3/calc/CalcChecker.g:62:9: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_operand302); 
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
	// vb/week3/calc/CalcChecker.g:65:1: type : INTEGER ;
	public final void type() throws RecognitionException {
		try {
			// vb/week3/calc/CalcChecker.g:66:5: ( INTEGER )
			// vb/week3/calc/CalcChecker.g:66:9: INTEGER
			{
			match(input,INTEGER,FOLLOW_INTEGER_in_type326); 
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
	public static final BitSet FOLLOW_declaration_in_program97 = new BitSet(new long[]{0x0000000000210018L});
	public static final BitSet FOLLOW_statement_in_program101 = new BitSet(new long[]{0x0000000000210018L});
	public static final BitSet FOLLOW_VAR_in_declaration128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration132 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_type_in_declaration134 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_statement167 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_statement171 = new BitSet(new long[]{0x000000000000E100L});
	public static final BitSet FOLLOW_expr_in_statement173 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_statement195 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_statement197 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expr222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expr233 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr235 = new BitSet(new long[]{0x000000000000E100L});
	public static final BitSet FOLLOW_expr_in_expr237 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr249 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr251 = new BitSet(new long[]{0x000000000000E100L});
	public static final BitSet FOLLOW_expr_in_expr253 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type326 = new BitSet(new long[]{0x0000000000000002L});
}
