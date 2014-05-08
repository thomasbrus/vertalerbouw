// $ANTLR 3.5.2 vb/week3/calc/Calc.g 2014-05-08 16:31:45

package vb.week3.calc;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class CalcParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public CalcParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalcParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return CalcParser.tokenNames; }
	@Override public String getGrammarFileName() { return "vb/week3/calc/Calc.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// vb/week3/calc/Calc.g:41:1: program : declarations statements EOF -> ^( PROGRAM ( declarations )? statements ) ;
	public final CalcParser.program_return program() throws RecognitionException {
		CalcParser.program_return retval = new CalcParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope declarations1 =null;
		ParserRuleReturnScope statements2 =null;

		Object EOF3_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_statements=new RewriteRuleSubtreeStream(adaptor,"rule statements");
		RewriteRuleSubtreeStream stream_declarations=new RewriteRuleSubtreeStream(adaptor,"rule declarations");

		try {
			// vb/week3/calc/Calc.g:42:5: ( declarations statements EOF -> ^( PROGRAM ( declarations )? statements ) )
			// vb/week3/calc/Calc.g:42:9: declarations statements EOF
			{
			pushFollow(FOLLOW_declarations_in_program515);
			declarations1=declarations();
			state._fsp--;

			stream_declarations.add(declarations1.getTree());
			pushFollow(FOLLOW_statements_in_program517);
			statements2=statements();
			state._fsp--;

			stream_statements.add(statements2.getTree());
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_program519);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: statements, declarations
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 43:13: -> ^( PROGRAM ( declarations )? statements )
			{
				// vb/week3/calc/Calc.g:43:17: ^( PROGRAM ( declarations )? statements )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				// vb/week3/calc/Calc.g:43:27: ( declarations )?
				if ( stream_declarations.hasNext() ) {
					adaptor.addChild(root_1, stream_declarations.nextTree());
				}
				stream_declarations.reset();

				adaptor.addChild(root_1, stream_statements.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class declarations_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declarations"
	// vb/week3/calc/Calc.g:46:1: declarations : ( declaration SEMICOLON !)* ;
	public final CalcParser.declarations_return declarations() throws RecognitionException {
		CalcParser.declarations_return retval = new CalcParser.declarations_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON5=null;
		ParserRuleReturnScope declaration4 =null;

		Object SEMICOLON5_tree=null;

		try {
			// vb/week3/calc/Calc.g:47:5: ( ( declaration SEMICOLON !)* )
			// vb/week3/calc/Calc.g:47:9: ( declaration SEMICOLON !)*
			{
			root_0 = (Object)adaptor.nil();


			// vb/week3/calc/Calc.g:47:9: ( declaration SEMICOLON !)*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==VAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// vb/week3/calc/Calc.g:47:10: declaration SEMICOLON !
					{
					pushFollow(FOLLOW_declaration_in_declarations563);
					declaration4=declaration();
					state._fsp--;

					adaptor.addChild(root_0, declaration4.getTree());

					SEMICOLON5=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations565); 
					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declarations"


	public static class statements_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statements"
	// vb/week3/calc/Calc.g:50:1: statements : ( statement SEMICOLON !)+ ;
	public final CalcParser.statements_return statements() throws RecognitionException {
		CalcParser.statements_return retval = new CalcParser.statements_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON7=null;
		ParserRuleReturnScope statement6 =null;

		Object SEMICOLON7_tree=null;

		try {
			// vb/week3/calc/Calc.g:51:5: ( ( statement SEMICOLON !)+ )
			// vb/week3/calc/Calc.g:51:9: ( statement SEMICOLON !)+
			{
			root_0 = (Object)adaptor.nil();


			// vb/week3/calc/Calc.g:51:9: ( statement SEMICOLON !)+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==IDENTIFIER||LA2_0==PRINT||LA2_0==SWAP) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// vb/week3/calc/Calc.g:51:10: statement SEMICOLON !
					{
					pushFollow(FOLLOW_statement_in_statements588);
					statement6=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement6.getTree());

					SEMICOLON7=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statements590); 
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

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statements"


	public static class declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// vb/week3/calc/Calc.g:54:1: declaration : VAR ^ IDENTIFIER COLON ! type ;
	public final CalcParser.declaration_return declaration() throws RecognitionException {
		CalcParser.declaration_return retval = new CalcParser.declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VAR8=null;
		Token IDENTIFIER9=null;
		Token COLON10=null;
		ParserRuleReturnScope type11 =null;

		Object VAR8_tree=null;
		Object IDENTIFIER9_tree=null;
		Object COLON10_tree=null;

		try {
			// vb/week3/calc/Calc.g:55:5: ( VAR ^ IDENTIFIER COLON ! type )
			// vb/week3/calc/Calc.g:55:9: VAR ^ IDENTIFIER COLON ! type
			{
			root_0 = (Object)adaptor.nil();


			VAR8=(Token)match(input,VAR,FOLLOW_VAR_in_declaration612); 
			VAR8_tree = (Object)adaptor.create(VAR8);
			root_0 = (Object)adaptor.becomeRoot(VAR8_tree, root_0);

			IDENTIFIER9=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration615); 
			IDENTIFIER9_tree = (Object)adaptor.create(IDENTIFIER9);
			adaptor.addChild(root_0, IDENTIFIER9_tree);

			COLON10=(Token)match(input,COLON,FOLLOW_COLON_in_declaration617); 
			pushFollow(FOLLOW_type_in_declaration620);
			type11=type();
			state._fsp--;

			adaptor.addChild(root_0, type11.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// vb/week3/calc/Calc.g:58:1: statement : ( assignment | print_stat | swap_stat );
	public final CalcParser.statement_return statement() throws RecognitionException {
		CalcParser.statement_return retval = new CalcParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assignment12 =null;
		ParserRuleReturnScope print_stat13 =null;
		ParserRuleReturnScope swap_stat14 =null;


		try {
			// vb/week3/calc/Calc.g:59:5: ( assignment | print_stat | swap_stat )
			int alt3=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt3=1;
				}
				break;
			case PRINT:
				{
				alt3=2;
				}
				break;
			case SWAP:
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
					// vb/week3/calc/Calc.g:59:9: assignment
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignment_in_statement639);
					assignment12=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment12.getTree());

					}
					break;
				case 2 :
					// vb/week3/calc/Calc.g:60:9: print_stat
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_print_stat_in_statement649);
					print_stat13=print_stat();
					state._fsp--;

					adaptor.addChild(root_0, print_stat13.getTree());

					}
					break;
				case 3 :
					// vb/week3/calc/Calc.g:61:9: swap_stat
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_swap_stat_in_statement659);
					swap_stat14=swap_stat();
					state._fsp--;

					adaptor.addChild(root_0, swap_stat14.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// vb/week3/calc/Calc.g:64:1: assignment : lvalue BECOMES ^ expr ;
	public final CalcParser.assignment_return assignment() throws RecognitionException {
		CalcParser.assignment_return retval = new CalcParser.assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BECOMES16=null;
		ParserRuleReturnScope lvalue15 =null;
		ParserRuleReturnScope expr17 =null;

		Object BECOMES16_tree=null;

		try {
			// vb/week3/calc/Calc.g:65:5: ( lvalue BECOMES ^ expr )
			// vb/week3/calc/Calc.g:65:9: lvalue BECOMES ^ expr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_lvalue_in_assignment678);
			lvalue15=lvalue();
			state._fsp--;

			adaptor.addChild(root_0, lvalue15.getTree());

			BECOMES16=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_assignment680); 
			BECOMES16_tree = (Object)adaptor.create(BECOMES16);
			root_0 = (Object)adaptor.becomeRoot(BECOMES16_tree, root_0);

			pushFollow(FOLLOW_expr_in_assignment683);
			expr17=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr17.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class print_stat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "print_stat"
	// vb/week3/calc/Calc.g:68:1: print_stat : PRINT ^ LPAREN ! expr RPAREN !;
	public final CalcParser.print_stat_return print_stat() throws RecognitionException {
		CalcParser.print_stat_return retval = new CalcParser.print_stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PRINT18=null;
		Token LPAREN19=null;
		Token RPAREN21=null;
		ParserRuleReturnScope expr20 =null;

		Object PRINT18_tree=null;
		Object LPAREN19_tree=null;
		Object RPAREN21_tree=null;

		try {
			// vb/week3/calc/Calc.g:69:5: ( PRINT ^ LPAREN ! expr RPAREN !)
			// vb/week3/calc/Calc.g:69:9: PRINT ^ LPAREN ! expr RPAREN !
			{
			root_0 = (Object)adaptor.nil();


			PRINT18=(Token)match(input,PRINT,FOLLOW_PRINT_in_print_stat702); 
			PRINT18_tree = (Object)adaptor.create(PRINT18);
			root_0 = (Object)adaptor.becomeRoot(PRINT18_tree, root_0);

			LPAREN19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_print_stat705); 
			pushFollow(FOLLOW_expr_in_print_stat708);
			expr20=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr20.getTree());

			RPAREN21=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_print_stat710); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "print_stat"


	public static class swap_stat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "swap_stat"
	// vb/week3/calc/Calc.g:72:1: swap_stat : SWAP ^ LPAREN ! IDENTIFIER COMMA ! IDENTIFIER RPAREN !;
	public final CalcParser.swap_stat_return swap_stat() throws RecognitionException {
		CalcParser.swap_stat_return retval = new CalcParser.swap_stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SWAP22=null;
		Token LPAREN23=null;
		Token IDENTIFIER24=null;
		Token COMMA25=null;
		Token IDENTIFIER26=null;
		Token RPAREN27=null;

		Object SWAP22_tree=null;
		Object LPAREN23_tree=null;
		Object IDENTIFIER24_tree=null;
		Object COMMA25_tree=null;
		Object IDENTIFIER26_tree=null;
		Object RPAREN27_tree=null;

		try {
			// vb/week3/calc/Calc.g:73:5: ( SWAP ^ LPAREN ! IDENTIFIER COMMA ! IDENTIFIER RPAREN !)
			// vb/week3/calc/Calc.g:73:8: SWAP ^ LPAREN ! IDENTIFIER COMMA ! IDENTIFIER RPAREN !
			{
			root_0 = (Object)adaptor.nil();


			SWAP22=(Token)match(input,SWAP,FOLLOW_SWAP_in_swap_stat729); 
			SWAP22_tree = (Object)adaptor.create(SWAP22);
			root_0 = (Object)adaptor.becomeRoot(SWAP22_tree, root_0);

			LPAREN23=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_swap_stat732); 
			IDENTIFIER24=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_swap_stat735); 
			IDENTIFIER24_tree = (Object)adaptor.create(IDENTIFIER24);
			adaptor.addChild(root_0, IDENTIFIER24_tree);

			COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_swap_stat737); 
			IDENTIFIER26=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_swap_stat740); 
			IDENTIFIER26_tree = (Object)adaptor.create(IDENTIFIER26);
			adaptor.addChild(root_0, IDENTIFIER26_tree);

			RPAREN27=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_swap_stat742); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "swap_stat"


	public static class lvalue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lvalue"
	// vb/week3/calc/Calc.g:76:1: lvalue : IDENTIFIER ;
	public final CalcParser.lvalue_return lvalue() throws RecognitionException {
		CalcParser.lvalue_return retval = new CalcParser.lvalue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER28=null;

		Object IDENTIFIER28_tree=null;

		try {
			// vb/week3/calc/Calc.g:77:5: ( IDENTIFIER )
			// vb/week3/calc/Calc.g:77:9: IDENTIFIER
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER28=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_lvalue762); 
			IDENTIFIER28_tree = (Object)adaptor.create(IDENTIFIER28);
			adaptor.addChild(root_0, IDENTIFIER28_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lvalue"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// vb/week3/calc/Calc.g:80:1: expr : expr2 ( ( PLUS ^| MINUS ^) expr2 )* ;
	public final CalcParser.expr_return expr() throws RecognitionException {
		CalcParser.expr_return retval = new CalcParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PLUS30=null;
		Token MINUS31=null;
		ParserRuleReturnScope expr229 =null;
		ParserRuleReturnScope expr232 =null;

		Object PLUS30_tree=null;
		Object MINUS31_tree=null;

		try {
			// vb/week3/calc/Calc.g:81:5: ( expr2 ( ( PLUS ^| MINUS ^) expr2 )* )
			// vb/week3/calc/Calc.g:81:9: expr2 ( ( PLUS ^| MINUS ^) expr2 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr2_in_expr781);
			expr229=expr2();
			state._fsp--;

			adaptor.addChild(root_0, expr229.getTree());

			// vb/week3/calc/Calc.g:81:15: ( ( PLUS ^| MINUS ^) expr2 )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==MINUS||LA5_0==PLUS) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// vb/week3/calc/Calc.g:81:16: ( PLUS ^| MINUS ^) expr2
					{
					// vb/week3/calc/Calc.g:81:16: ( PLUS ^| MINUS ^)
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==PLUS) ) {
						alt4=1;
					}
					else if ( (LA4_0==MINUS) ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// vb/week3/calc/Calc.g:81:17: PLUS ^
							{
							PLUS30=(Token)match(input,PLUS,FOLLOW_PLUS_in_expr785); 
							PLUS30_tree = (Object)adaptor.create(PLUS30);
							root_0 = (Object)adaptor.becomeRoot(PLUS30_tree, root_0);

							}
							break;
						case 2 :
							// vb/week3/calc/Calc.g:81:25: MINUS ^
							{
							MINUS31=(Token)match(input,MINUS,FOLLOW_MINUS_in_expr790); 
							MINUS31_tree = (Object)adaptor.create(MINUS31);
							root_0 = (Object)adaptor.becomeRoot(MINUS31_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_expr2_in_expr794);
					expr232=expr2();
					state._fsp--;

					adaptor.addChild(root_0, expr232.getTree());

					}
					break;

				default :
					break loop5;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class expr2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr2"
	// vb/week3/calc/Calc.g:84:1: expr2 : operand ( ( MUL ^| DIV ^) operand )* ;
	public final CalcParser.expr2_return expr2() throws RecognitionException {
		CalcParser.expr2_return retval = new CalcParser.expr2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MUL34=null;
		Token DIV35=null;
		ParserRuleReturnScope operand33 =null;
		ParserRuleReturnScope operand36 =null;

		Object MUL34_tree=null;
		Object DIV35_tree=null;

		try {
			// vb/week3/calc/Calc.g:85:5: ( operand ( ( MUL ^| DIV ^) operand )* )
			// vb/week3/calc/Calc.g:85:9: operand ( ( MUL ^| DIV ^) operand )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_operand_in_expr2815);
			operand33=operand();
			state._fsp--;

			adaptor.addChild(root_0, operand33.getTree());

			// vb/week3/calc/Calc.g:85:17: ( ( MUL ^| DIV ^) operand )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==DIV||LA7_0==MUL) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// vb/week3/calc/Calc.g:85:18: ( MUL ^| DIV ^) operand
					{
					// vb/week3/calc/Calc.g:85:18: ( MUL ^| DIV ^)
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==MUL) ) {
						alt6=1;
					}
					else if ( (LA6_0==DIV) ) {
						alt6=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						throw nvae;
					}

					switch (alt6) {
						case 1 :
							// vb/week3/calc/Calc.g:85:19: MUL ^
							{
							MUL34=(Token)match(input,MUL,FOLLOW_MUL_in_expr2819); 
							MUL34_tree = (Object)adaptor.create(MUL34);
							root_0 = (Object)adaptor.becomeRoot(MUL34_tree, root_0);

							}
							break;
						case 2 :
							// vb/week3/calc/Calc.g:85:26: DIV ^
							{
							DIV35=(Token)match(input,DIV,FOLLOW_DIV_in_expr2824); 
							DIV35_tree = (Object)adaptor.create(DIV35);
							root_0 = (Object)adaptor.becomeRoot(DIV35_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_operand_in_expr2828);
					operand36=operand();
					state._fsp--;

					adaptor.addChild(root_0, operand36.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr2"


	public static class operand_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operand"
	// vb/week3/calc/Calc.g:88:1: operand : ( IDENTIFIER | NUMBER | LPAREN ! expr RPAREN !);
	public final CalcParser.operand_return operand() throws RecognitionException {
		CalcParser.operand_return retval = new CalcParser.operand_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER37=null;
		Token NUMBER38=null;
		Token LPAREN39=null;
		Token RPAREN41=null;
		ParserRuleReturnScope expr40 =null;

		Object IDENTIFIER37_tree=null;
		Object NUMBER38_tree=null;
		Object LPAREN39_tree=null;
		Object RPAREN41_tree=null;

		try {
			// vb/week3/calc/Calc.g:89:5: ( IDENTIFIER | NUMBER | LPAREN ! expr RPAREN !)
			int alt8=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt8=1;
				}
				break;
			case NUMBER:
				{
				alt8=2;
				}
				break;
			case LPAREN:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// vb/week3/calc/Calc.g:89:9: IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER37=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand849); 
					IDENTIFIER37_tree = (Object)adaptor.create(IDENTIFIER37);
					adaptor.addChild(root_0, IDENTIFIER37_tree);

					}
					break;
				case 2 :
					// vb/week3/calc/Calc.g:90:9: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER38=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_operand859); 
					NUMBER38_tree = (Object)adaptor.create(NUMBER38);
					adaptor.addChild(root_0, NUMBER38_tree);

					}
					break;
				case 3 :
					// vb/week3/calc/Calc.g:91:9: LPAREN ! expr RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN39=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_operand869); 
					pushFollow(FOLLOW_expr_in_operand872);
					expr40=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr40.getTree());

					RPAREN41=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_operand874); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operand"


	public static class type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// vb/week3/calc/Calc.g:94:1: type : INTEGER ;
	public final CalcParser.type_return type() throws RecognitionException {
		CalcParser.type_return retval = new CalcParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTEGER42=null;

		Object INTEGER42_tree=null;

		try {
			// vb/week3/calc/Calc.g:95:5: ( INTEGER )
			// vb/week3/calc/Calc.g:95:9: INTEGER
			{
			root_0 = (Object)adaptor.nil();


			INTEGER42=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_type894); 
			INTEGER42_tree = (Object)adaptor.create(INTEGER42);
			adaptor.addChild(root_0, INTEGER42_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"

	// Delegated rules



	public static final BitSet FOLLOW_declarations_in_program515 = new BitSet(new long[]{0x0000000000880400L});
	public static final BitSet FOLLOW_statements_in_program517 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_program519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_declarations563 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations565 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_statement_in_statements588 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_SEMICOLON_in_statements590 = new BitSet(new long[]{0x0000000000880402L});
	public static final BitSet FOLLOW_VAR_in_declaration612 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration615 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_declaration617 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_type_in_declaration620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_stat_in_statement649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_swap_stat_in_statement659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lvalue_in_assignment678 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BECOMES_in_assignment680 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_expr_in_assignment683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_print_stat702 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LPAREN_in_print_stat705 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_expr_in_print_stat708 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_RPAREN_in_print_stat710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SWAP_in_swap_stat729 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LPAREN_in_swap_stat732 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_IDENTIFIER_in_swap_stat735 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COMMA_in_swap_stat737 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_IDENTIFIER_in_swap_stat740 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_RPAREN_in_swap_stat742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_lvalue762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr2_in_expr781 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_PLUS_in_expr785 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_MINUS_in_expr790 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_expr2_in_expr794 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_operand_in_expr2815 = new BitSet(new long[]{0x0000000000010202L});
	public static final BitSet FOLLOW_MUL_in_expr2819 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_DIV_in_expr2824 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_operand_in_expr2828 = new BitSet(new long[]{0x0000000000010202L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_operand869 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_expr_in_operand872 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_RPAREN_in_operand874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type894 = new BitSet(new long[]{0x0000000000000002L});
}
