// $ANTLR 3.5.2 vb/week3/calc/CalcInterpreter.g 2014-05-08 16:09:49

package vb.week3.calc;
import java.util.Map;
import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcInterpreter extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BECOMES", "COLON", "COMMENT", 
		"DIGIT", "DIV", "IDENTIFIER", "INTEGER", "LETTER", "LOWER", "LPAREN", 
		"MINUS", "MUL", "NUMBER", "PLUS", "PRINT", "PROGRAM", "RPAREN", "SEMICOLON", 
		"UPPER", "VAR", "WS"
	};
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public CalcInterpreter(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalcInterpreter(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return CalcInterpreter.tokenNames; }
	@Override public String getGrammarFileName() { return "vb/week3/calc/CalcInterpreter.g"; }


	    private Map<String,Integer> store = new HashMap<String,Integer>();



	// $ANTLR start "program"
	// vb/week3/calc/CalcInterpreter.g:32:1: program : ^( PROGRAM ( declaration | statement )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// vb/week3/calc/CalcInterpreter.g:33:5: ( ^( PROGRAM ( declaration | statement )+ ) )
			// vb/week3/calc/CalcInterpreter.g:33:9: ^( PROGRAM ( declaration | statement )+ )
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_program100); 
			match(input, Token.DOWN, null); 
			// vb/week3/calc/CalcInterpreter.g:33:19: ( declaration | statement )+
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
					// vb/week3/calc/CalcInterpreter.g:33:20: declaration
					{
					pushFollow(FOLLOW_declaration_in_program103);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// vb/week3/calc/CalcInterpreter.g:33:34: statement
					{
					pushFollow(FOLLOW_statement_in_program107);
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

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declaration"
	// vb/week3/calc/CalcInterpreter.g:36:1: declaration : ^( VAR id= IDENTIFIER type ) ;
	public final void declaration() throws RecognitionException {
		CommonTree id=null;

		try {
			// vb/week3/calc/CalcInterpreter.g:37:5: ( ^( VAR id= IDENTIFIER type ) )
			// vb/week3/calc/CalcInterpreter.g:37:9: ^( VAR id= IDENTIFIER type )
			{
			match(input,VAR,FOLLOW_VAR_in_declaration130); 
			match(input, Token.DOWN, null); 
			id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration134); 
			pushFollow(FOLLOW_type_in_declaration136);
			type();
			state._fsp--;

			match(input, Token.UP, null); 

			 store.put((id!=null?id.getText():null), 0); 
			}

		}

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration"



	// $ANTLR start "statement"
	// vb/week3/calc/CalcInterpreter.g:41:1: statement : ( ^( BECOMES id= IDENTIFIER v= expr ) | ^( PRINT v= expr ) );
	public final void statement() throws RecognitionException {
		CommonTree id=null;
		int v =0;

		try {
			// vb/week3/calc/CalcInterpreter.g:42:5: ( ^( BECOMES id= IDENTIFIER v= expr ) | ^( PRINT v= expr ) )
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
					// vb/week3/calc/CalcInterpreter.g:42:9: ^( BECOMES id= IDENTIFIER v= expr )
					{
					match(input,BECOMES,FOLLOW_BECOMES_in_statement171); 
					match(input, Token.DOWN, null); 
					id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement175); 
					pushFollow(FOLLOW_expr_in_statement179);
					v=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 store.put((id!=null?id.getText():null), v);       
					}
					break;
				case 2 :
					// vb/week3/calc/CalcInterpreter.g:44:9: ^( PRINT v= expr )
					{
					match(input,PRINT,FOLLOW_PRINT_in_statement205); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_statement209);
					v=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 System.out.println("" + v);   
					}
					break;

			}
		}

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "expr"
	// vb/week3/calc/CalcInterpreter.g:48:1: expr returns [int val = 0;] : (z= expr2 | ^( PLUS x= expr y= expr ) | ^( MINUS x= expr y= expr ) );
	public final int expr() throws RecognitionException {
		int val =  0;;


		int z =0;
		int x =0;
		int y =0;

		try {
			// vb/week3/calc/CalcInterpreter.g:49:5: (z= expr2 | ^( PLUS x= expr y= expr ) | ^( MINUS x= expr y= expr ) )
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
					// vb/week3/calc/CalcInterpreter.g:49:9: z= expr2
					{
					pushFollow(FOLLOW_expr2_in_expr249);
					z=expr2();
					state._fsp--;

					 val = z;      
					}
					break;
				case 2 :
					// vb/week3/calc/CalcInterpreter.g:50:9: ^( PLUS x= expr y= expr )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr278); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr282);
					x=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr286);
					y=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 val = x + y;  
					}
					break;
				case 3 :
					// vb/week3/calc/CalcInterpreter.g:51:9: ^( MINUS x= expr y= expr )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr302); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr306);
					x=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr310);
					y=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 val = x - y;  
					}
					break;

			}
		}

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return val;
	}
	// $ANTLR end "expr"



	// $ANTLR start "expr2"
	// vb/week3/calc/CalcInterpreter.g:54:1: expr2 returns [int val = 0;] : (z= operand | ^( MUL x= expr y= expr ) | ^( DIV x= expr y= expr ) );
	public final int expr2() throws RecognitionException {
		int val =  0;;


		int z =0;
		int x =0;
		int y =0;

		try {
			// vb/week3/calc/CalcInterpreter.g:55:5: (z= operand | ^( MUL x= expr y= expr ) | ^( DIV x= expr y= expr ) )
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
					// vb/week3/calc/CalcInterpreter.g:55:9: z= operand
					{
					pushFollow(FOLLOW_operand_in_expr2339);
					z=operand();
					state._fsp--;

					 val = z;      
					}
					break;
				case 2 :
					// vb/week3/calc/CalcInterpreter.g:56:9: ^( MUL x= expr y= expr )
					{
					match(input,MUL,FOLLOW_MUL_in_expr2366); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr2370);
					x=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr2374);
					y=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 val = x * y;  
					}
					break;
				case 3 :
					// vb/week3/calc/CalcInterpreter.g:57:9: ^( DIV x= expr y= expr )
					{
					match(input,DIV,FOLLOW_DIV_in_expr2390); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr2394);
					x=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr2398);
					y=expr();
					state._fsp--;

					match(input, Token.UP, null); 


					          if (y == 0) throw new CalcException("Cannot divide by zero!");
					          val = x / y;
					        
					}
					break;

			}
		}

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return val;
	}
	// $ANTLR end "expr2"



	// $ANTLR start "operand"
	// vb/week3/calc/CalcInterpreter.g:63:1: operand returns [int val = 0] : (id= IDENTIFIER |n= NUMBER );
	public final int operand() throws RecognitionException {
		int val =  0;


		CommonTree id=null;
		CommonTree n=null;

		try {
			// vb/week3/calc/CalcInterpreter.g:64:5: (id= IDENTIFIER |n= NUMBER )
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
					// vb/week3/calc/CalcInterpreter.g:64:9: id= IDENTIFIER
					{
					id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand427); 
					 val = store.get((id!=null?id.getText():null));       
					}
					break;
				case 2 :
					// vb/week3/calc/CalcInterpreter.g:65:9: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_operand443); 
					 val = Integer.parseInt((n!=null?n.getText():null)); 
					}
					break;

			}
		}

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return val;
	}
	// $ANTLR end "operand"



	// $ANTLR start "type"
	// vb/week3/calc/CalcInterpreter.g:68:1: type : INTEGER ;
	public final void type() throws RecognitionException {
		try {
			// vb/week3/calc/CalcInterpreter.g:69:5: ( INTEGER )
			// vb/week3/calc/CalcInterpreter.g:69:9: INTEGER
			{
			match(input,INTEGER,FOLLOW_INTEGER_in_type471); 
			}

		}

		    catch (CalcException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"

	// Delegated rules



	public static final BitSet FOLLOW_PROGRAM_in_program100 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program103 = new BitSet(new long[]{0x0000000000840018L});
	public static final BitSet FOLLOW_statement_in_program107 = new BitSet(new long[]{0x0000000000840018L});
	public static final BitSet FOLLOW_VAR_in_declaration130 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration134 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_type_in_declaration136 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_statement171 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_statement175 = new BitSet(new long[]{0x000000000003C300L});
	public static final BitSet FOLLOW_expr_in_statement179 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_statement205 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_statement209 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr2_in_expr249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expr278 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr282 = new BitSet(new long[]{0x000000000003C300L});
	public static final BitSet FOLLOW_expr_in_expr286 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr302 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr306 = new BitSet(new long[]{0x000000000003C300L});
	public static final BitSet FOLLOW_expr_in_expr310 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expr2339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MUL_in_expr2366 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2370 = new BitSet(new long[]{0x000000000003C300L});
	public static final BitSet FOLLOW_expr_in_expr2374 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr2390 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2394 = new BitSet(new long[]{0x000000000003C300L});
	public static final BitSet FOLLOW_expr_in_expr2398 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type471 = new BitSet(new long[]{0x0000000000000002L});
}
