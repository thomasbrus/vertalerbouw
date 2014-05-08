// $ANTLR 3.5.2 vb/week3/calc/Calc.g 2014-05-08 16:09:48

package vb.week3.calc;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class CalcParser extends Parser {
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
	// vb/week3/calc/Calc.g:39:1: program : declarations statements EOF -> ^( PROGRAM ( declarations )? statements ) ;
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
			// vb/week3/calc/Calc.g:40:5: ( declarations statements EOF -> ^( PROGRAM ( declarations )? statements ) )
			// vb/week3/calc/Calc.g:40:9: declarations statements EOF
			{
			pushFollow(FOLLOW_declarations_in_program465);
			declarations1=declarations();
			state._fsp--;

			stream_declarations.add(declarations1.getTree());
			pushFollow(FOLLOW_statements_in_program467);
			statements2=statements();
			state._fsp--;

			stream_statements.add(statements2.getTree());
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_program469);  
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
			// 41:13: -> ^( PROGRAM ( declarations )? statements )
			{
				// vb/week3/calc/Calc.g:41:17: ^( PROGRAM ( declarations )? statements )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				// vb/week3/calc/Calc.g:41:27: ( declarations )?
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
	// vb/week3/calc/Calc.g:44:1: declarations : ( declaration SEMICOLON !)* ;
	public final CalcParser.declarations_return declarations() throws RecognitionException {
		CalcParser.declarations_return retval = new CalcParser.declarations_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON5=null;
		ParserRuleReturnScope declaration4 =null;

		Object SEMICOLON5_tree=null;

		try {
			// vb/week3/calc/Calc.g:45:5: ( ( declaration SEMICOLON !)* )
			// vb/week3/calc/Calc.g:45:9: ( declaration SEMICOLON !)*
			{
			root_0 = (Object)adaptor.nil();


			// vb/week3/calc/Calc.g:45:9: ( declaration SEMICOLON !)*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==VAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// vb/week3/calc/Calc.g:45:10: declaration SEMICOLON !
					{
					pushFollow(FOLLOW_declaration_in_declarations513);
					declaration4=declaration();
					state._fsp--;

					adaptor.addChild(root_0, declaration4.getTree());

					SEMICOLON5=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations515); 
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
	// vb/week3/calc/Calc.g:48:1: statements : ( statement SEMICOLON !)+ ;
	public final CalcParser.statements_return statements() throws RecognitionException {
		CalcParser.statements_return retval = new CalcParser.statements_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON7=null;
		ParserRuleReturnScope statement6 =null;

		Object SEMICOLON7_tree=null;

		try {
			// vb/week3/calc/Calc.g:49:5: ( ( statement SEMICOLON !)+ )
			// vb/week3/calc/Calc.g:49:9: ( statement SEMICOLON !)+
			{
			root_0 = (Object)adaptor.nil();


			// vb/week3/calc/Calc.g:49:9: ( statement SEMICOLON !)+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==IDENTIFIER||LA2_0==PRINT) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// vb/week3/calc/Calc.g:49:10: statement SEMICOLON !
					{
					pushFollow(FOLLOW_statement_in_statements538);
					statement6=statement();
					state._fsp--;

					adaptor.addChild(root_0, statement6.getTree());

					SEMICOLON7=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statements540); 
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
	// vb/week3/calc/Calc.g:52:1: declaration : VAR ^ IDENTIFIER COLON ! type ;
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
			// vb/week3/calc/Calc.g:53:5: ( VAR ^ IDENTIFIER COLON ! type )
			// vb/week3/calc/Calc.g:53:9: VAR ^ IDENTIFIER COLON ! type
			{
			root_0 = (Object)adaptor.nil();


			VAR8=(Token)match(input,VAR,FOLLOW_VAR_in_declaration562); 
			VAR8_tree = (Object)adaptor.create(VAR8);
			root_0 = (Object)adaptor.becomeRoot(VAR8_tree, root_0);

			IDENTIFIER9=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration565); 
			IDENTIFIER9_tree = (Object)adaptor.create(IDENTIFIER9);
			adaptor.addChild(root_0, IDENTIFIER9_tree);

			COLON10=(Token)match(input,COLON,FOLLOW_COLON_in_declaration567); 
			pushFollow(FOLLOW_type_in_declaration570);
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
	// vb/week3/calc/Calc.g:56:1: statement : ( assignment | print_stat );
	public final CalcParser.statement_return statement() throws RecognitionException {
		CalcParser.statement_return retval = new CalcParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assignment12 =null;
		ParserRuleReturnScope print_stat13 =null;


		try {
			// vb/week3/calc/Calc.g:57:5: ( assignment | print_stat )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENTIFIER) ) {
				alt3=1;
			}
			else if ( (LA3_0==PRINT) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// vb/week3/calc/Calc.g:57:9: assignment
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignment_in_statement589);
					assignment12=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment12.getTree());

					}
					break;
				case 2 :
					// vb/week3/calc/Calc.g:58:9: print_stat
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_print_stat_in_statement599);
					print_stat13=print_stat();
					state._fsp--;

					adaptor.addChild(root_0, print_stat13.getTree());

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
	// vb/week3/calc/Calc.g:61:1: assignment : lvalue BECOMES ^ expr ;
	public final CalcParser.assignment_return assignment() throws RecognitionException {
		CalcParser.assignment_return retval = new CalcParser.assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BECOMES15=null;
		ParserRuleReturnScope lvalue14 =null;
		ParserRuleReturnScope expr16 =null;

		Object BECOMES15_tree=null;

		try {
			// vb/week3/calc/Calc.g:62:5: ( lvalue BECOMES ^ expr )
			// vb/week3/calc/Calc.g:62:9: lvalue BECOMES ^ expr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_lvalue_in_assignment618);
			lvalue14=lvalue();
			state._fsp--;

			adaptor.addChild(root_0, lvalue14.getTree());

			BECOMES15=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_assignment620); 
			BECOMES15_tree = (Object)adaptor.create(BECOMES15);
			root_0 = (Object)adaptor.becomeRoot(BECOMES15_tree, root_0);

			pushFollow(FOLLOW_expr_in_assignment623);
			expr16=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr16.getTree());

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
	// vb/week3/calc/Calc.g:65:1: print_stat : PRINT ^ LPAREN ! expr RPAREN !;
	public final CalcParser.print_stat_return print_stat() throws RecognitionException {
		CalcParser.print_stat_return retval = new CalcParser.print_stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PRINT17=null;
		Token LPAREN18=null;
		Token RPAREN20=null;
		ParserRuleReturnScope expr19 =null;

		Object PRINT17_tree=null;
		Object LPAREN18_tree=null;
		Object RPAREN20_tree=null;

		try {
			// vb/week3/calc/Calc.g:66:5: ( PRINT ^ LPAREN ! expr RPAREN !)
			// vb/week3/calc/Calc.g:66:9: PRINT ^ LPAREN ! expr RPAREN !
			{
			root_0 = (Object)adaptor.nil();


			PRINT17=(Token)match(input,PRINT,FOLLOW_PRINT_in_print_stat642); 
			PRINT17_tree = (Object)adaptor.create(PRINT17);
			root_0 = (Object)adaptor.becomeRoot(PRINT17_tree, root_0);

			LPAREN18=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_print_stat645); 
			pushFollow(FOLLOW_expr_in_print_stat648);
			expr19=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr19.getTree());

			RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_print_stat650); 
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


	public static class lvalue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lvalue"
	// vb/week3/calc/Calc.g:69:1: lvalue : IDENTIFIER ;
	public final CalcParser.lvalue_return lvalue() throws RecognitionException {
		CalcParser.lvalue_return retval = new CalcParser.lvalue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER21=null;

		Object IDENTIFIER21_tree=null;

		try {
			// vb/week3/calc/Calc.g:70:5: ( IDENTIFIER )
			// vb/week3/calc/Calc.g:70:9: IDENTIFIER
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER21=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_lvalue670); 
			IDENTIFIER21_tree = (Object)adaptor.create(IDENTIFIER21);
			adaptor.addChild(root_0, IDENTIFIER21_tree);

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
	// vb/week3/calc/Calc.g:73:1: expr : expr2 ( ( PLUS ^| MINUS ^) expr2 )* ;
	public final CalcParser.expr_return expr() throws RecognitionException {
		CalcParser.expr_return retval = new CalcParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PLUS23=null;
		Token MINUS24=null;
		ParserRuleReturnScope expr222 =null;
		ParserRuleReturnScope expr225 =null;

		Object PLUS23_tree=null;
		Object MINUS24_tree=null;

		try {
			// vb/week3/calc/Calc.g:74:5: ( expr2 ( ( PLUS ^| MINUS ^) expr2 )* )
			// vb/week3/calc/Calc.g:74:9: expr2 ( ( PLUS ^| MINUS ^) expr2 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr2_in_expr689);
			expr222=expr2();
			state._fsp--;

			adaptor.addChild(root_0, expr222.getTree());

			// vb/week3/calc/Calc.g:74:15: ( ( PLUS ^| MINUS ^) expr2 )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==MINUS||LA5_0==PLUS) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// vb/week3/calc/Calc.g:74:16: ( PLUS ^| MINUS ^) expr2
					{
					// vb/week3/calc/Calc.g:74:16: ( PLUS ^| MINUS ^)
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
							// vb/week3/calc/Calc.g:74:17: PLUS ^
							{
							PLUS23=(Token)match(input,PLUS,FOLLOW_PLUS_in_expr693); 
							PLUS23_tree = (Object)adaptor.create(PLUS23);
							root_0 = (Object)adaptor.becomeRoot(PLUS23_tree, root_0);

							}
							break;
						case 2 :
							// vb/week3/calc/Calc.g:74:25: MINUS ^
							{
							MINUS24=(Token)match(input,MINUS,FOLLOW_MINUS_in_expr698); 
							MINUS24_tree = (Object)adaptor.create(MINUS24);
							root_0 = (Object)adaptor.becomeRoot(MINUS24_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_expr2_in_expr702);
					expr225=expr2();
					state._fsp--;

					adaptor.addChild(root_0, expr225.getTree());

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
	// vb/week3/calc/Calc.g:77:1: expr2 : operand ( ( MUL ^| DIV ^) operand )* ;
	public final CalcParser.expr2_return expr2() throws RecognitionException {
		CalcParser.expr2_return retval = new CalcParser.expr2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MUL27=null;
		Token DIV28=null;
		ParserRuleReturnScope operand26 =null;
		ParserRuleReturnScope operand29 =null;

		Object MUL27_tree=null;
		Object DIV28_tree=null;

		try {
			// vb/week3/calc/Calc.g:78:5: ( operand ( ( MUL ^| DIV ^) operand )* )
			// vb/week3/calc/Calc.g:78:9: operand ( ( MUL ^| DIV ^) operand )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_operand_in_expr2723);
			operand26=operand();
			state._fsp--;

			adaptor.addChild(root_0, operand26.getTree());

			// vb/week3/calc/Calc.g:78:17: ( ( MUL ^| DIV ^) operand )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==DIV||LA7_0==MUL) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// vb/week3/calc/Calc.g:78:18: ( MUL ^| DIV ^) operand
					{
					// vb/week3/calc/Calc.g:78:18: ( MUL ^| DIV ^)
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
							// vb/week3/calc/Calc.g:78:19: MUL ^
							{
							MUL27=(Token)match(input,MUL,FOLLOW_MUL_in_expr2727); 
							MUL27_tree = (Object)adaptor.create(MUL27);
							root_0 = (Object)adaptor.becomeRoot(MUL27_tree, root_0);

							}
							break;
						case 2 :
							// vb/week3/calc/Calc.g:78:26: DIV ^
							{
							DIV28=(Token)match(input,DIV,FOLLOW_DIV_in_expr2732); 
							DIV28_tree = (Object)adaptor.create(DIV28);
							root_0 = (Object)adaptor.becomeRoot(DIV28_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_operand_in_expr2736);
					operand29=operand();
					state._fsp--;

					adaptor.addChild(root_0, operand29.getTree());

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
	// vb/week3/calc/Calc.g:81:1: operand : ( IDENTIFIER | NUMBER | LPAREN ! expr RPAREN !);
	public final CalcParser.operand_return operand() throws RecognitionException {
		CalcParser.operand_return retval = new CalcParser.operand_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER30=null;
		Token NUMBER31=null;
		Token LPAREN32=null;
		Token RPAREN34=null;
		ParserRuleReturnScope expr33 =null;

		Object IDENTIFIER30_tree=null;
		Object NUMBER31_tree=null;
		Object LPAREN32_tree=null;
		Object RPAREN34_tree=null;

		try {
			// vb/week3/calc/Calc.g:82:5: ( IDENTIFIER | NUMBER | LPAREN ! expr RPAREN !)
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
					// vb/week3/calc/Calc.g:82:9: IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER30=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand757); 
					IDENTIFIER30_tree = (Object)adaptor.create(IDENTIFIER30);
					adaptor.addChild(root_0, IDENTIFIER30_tree);

					}
					break;
				case 2 :
					// vb/week3/calc/Calc.g:83:9: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER31=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_operand767); 
					NUMBER31_tree = (Object)adaptor.create(NUMBER31);
					adaptor.addChild(root_0, NUMBER31_tree);

					}
					break;
				case 3 :
					// vb/week3/calc/Calc.g:84:9: LPAREN ! expr RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN32=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_operand777); 
					pushFollow(FOLLOW_expr_in_operand780);
					expr33=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr33.getTree());

					RPAREN34=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_operand782); 
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
	// vb/week3/calc/Calc.g:87:1: type : INTEGER ;
	public final CalcParser.type_return type() throws RecognitionException {
		CalcParser.type_return retval = new CalcParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTEGER35=null;

		Object INTEGER35_tree=null;

		try {
			// vb/week3/calc/Calc.g:88:5: ( INTEGER )
			// vb/week3/calc/Calc.g:88:9: INTEGER
			{
			root_0 = (Object)adaptor.nil();


			INTEGER35=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_type802); 
			INTEGER35_tree = (Object)adaptor.create(INTEGER35);
			adaptor.addChild(root_0, INTEGER35_tree);

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



	public static final BitSet FOLLOW_declarations_in_program465 = new BitSet(new long[]{0x0000000000040200L});
	public static final BitSet FOLLOW_statements_in_program467 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_program469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_declarations513 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations515 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_statement_in_statements538 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_SEMICOLON_in_statements540 = new BitSet(new long[]{0x0000000000040202L});
	public static final BitSet FOLLOW_VAR_in_declaration562 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration565 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_declaration567 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_type_in_declaration570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_stat_in_statement599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lvalue_in_assignment618 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BECOMES_in_assignment620 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_expr_in_assignment623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_print_stat642 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_LPAREN_in_print_stat645 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_expr_in_print_stat648 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_RPAREN_in_print_stat650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_lvalue670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr2_in_expr689 = new BitSet(new long[]{0x0000000000024002L});
	public static final BitSet FOLLOW_PLUS_in_expr693 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_MINUS_in_expr698 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_expr2_in_expr702 = new BitSet(new long[]{0x0000000000024002L});
	public static final BitSet FOLLOW_operand_in_expr2723 = new BitSet(new long[]{0x0000000000008102L});
	public static final BitSet FOLLOW_MUL_in_expr2727 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_DIV_in_expr2732 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_operand_in_expr2736 = new BitSet(new long[]{0x0000000000008102L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_operand777 = new BitSet(new long[]{0x0000000000012200L});
	public static final BitSet FOLLOW_expr_in_operand780 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_RPAREN_in_operand782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type802 = new BitSet(new long[]{0x0000000000000002L});
}
