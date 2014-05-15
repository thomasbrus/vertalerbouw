// $ANTLR 3.5.2 vb/week4/decluse/Decluse.g 2014-05-15 14:14:10

package vb.week4.decluse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class DecluseParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "D", "LETTER", "LOWER", "LPAREN", 
		"RPAREN", "U", "UPPER", "WS"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public DecluseParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public DecluseParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return DecluseParser.tokenNames; }
	@Override public String getGrammarFileName() { return "vb/week4/decluse/Decluse.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// vb/week4/decluse/Decluse.g:27:1: program : LPAREN ! serie RPAREN !;
	public final DecluseParser.program_return program() throws RecognitionException {
		DecluseParser.program_return retval = new DecluseParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN1=null;
		Token RPAREN3=null;
		ParserRuleReturnScope serie2 =null;

		Object LPAREN1_tree=null;
		Object RPAREN3_tree=null;

		try {
			// vb/week4/decluse/Decluse.g:28:3: ( LPAREN ! serie RPAREN !)
			// vb/week4/decluse/Decluse.g:28:5: LPAREN ! serie RPAREN !
			{
			root_0 = (Object)adaptor.nil();


			LPAREN1=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_program97); 
			pushFollow(FOLLOW_serie_in_program100);
			serie2=serie();
			state._fsp--;

			adaptor.addChild(root_0, serie2.getTree());

			RPAREN3=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_program102); 
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


	public static class serie_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "serie"
	// vb/week4/decluse/Decluse.g:31:1: serie : ( unit )* ;
	public final DecluseParser.serie_return serie() throws RecognitionException {
		DecluseParser.serie_return retval = new DecluseParser.serie_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope unit4 =null;


		try {
			// vb/week4/decluse/Decluse.g:32:3: ( ( unit )* )
			// vb/week4/decluse/Decluse.g:32:5: ( unit )*
			{
			root_0 = (Object)adaptor.nil();


			// vb/week4/decluse/Decluse.g:32:5: ( unit )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==D||LA1_0==LPAREN||LA1_0==U) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// vb/week4/decluse/Decluse.g:32:5: unit
					{
					pushFollow(FOLLOW_unit_in_serie116);
					unit4=unit();
					state._fsp--;

					adaptor.addChild(root_0, unit4.getTree());

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
	// $ANTLR end "serie"


	public static class unit_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unit"
	// vb/week4/decluse/Decluse.g:35:1: unit : ( decl | use | LPAREN ! serie RPAREN !);
	public final DecluseParser.unit_return unit() throws RecognitionException {
		DecluseParser.unit_return retval = new DecluseParser.unit_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN7=null;
		Token RPAREN9=null;
		ParserRuleReturnScope decl5 =null;
		ParserRuleReturnScope use6 =null;
		ParserRuleReturnScope serie8 =null;

		Object LPAREN7_tree=null;
		Object RPAREN9_tree=null;

		try {
			// vb/week4/decluse/Decluse.g:35:5: ( decl | use | LPAREN ! serie RPAREN !)
			int alt2=3;
			switch ( input.LA(1) ) {
			case D:
				{
				alt2=1;
				}
				break;
			case U:
				{
				alt2=2;
				}
				break;
			case LPAREN:
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
					// vb/week4/decluse/Decluse.g:35:7: decl
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_decl_in_unit127);
					decl5=decl();
					state._fsp--;

					adaptor.addChild(root_0, decl5.getTree());

					}
					break;
				case 2 :
					// vb/week4/decluse/Decluse.g:36:6: use
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_use_in_unit134);
					use6=use();
					state._fsp--;

					adaptor.addChild(root_0, use6.getTree());

					}
					break;
				case 3 :
					// vb/week4/decluse/Decluse.g:37:6: LPAREN ! serie RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unit141); 
					pushFollow(FOLLOW_serie_in_unit144);
					serie8=serie();
					state._fsp--;

					adaptor.addChild(root_0, serie8.getTree());

					RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unit146); 
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
	// $ANTLR end "unit"


	public static class decl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "decl"
	// vb/week4/decluse/Decluse.g:40:1: decl : D id ;
	public final DecluseParser.decl_return decl() throws RecognitionException {
		DecluseParser.decl_return retval = new DecluseParser.decl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token D10=null;
		ParserRuleReturnScope id11 =null;

		Object D10_tree=null;

		try {
			// vb/week4/decluse/Decluse.g:40:5: ( D id )
			// vb/week4/decluse/Decluse.g:40:7: D id
			{
			root_0 = (Object)adaptor.nil();


			D10=(Token)match(input,D,FOLLOW_D_in_decl158); 
			D10_tree = (Object)adaptor.create(D10);
			adaptor.addChild(root_0, D10_tree);

			pushFollow(FOLLOW_id_in_decl160);
			id11=id();
			state._fsp--;

			adaptor.addChild(root_0, id11.getTree());

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
	// $ANTLR end "decl"


	public static class use_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "use"
	// vb/week4/decluse/Decluse.g:42:1: use : U id ;
	public final DecluseParser.use_return use() throws RecognitionException {
		DecluseParser.use_return retval = new DecluseParser.use_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token U12=null;
		ParserRuleReturnScope id13 =null;

		Object U12_tree=null;

		try {
			// vb/week4/decluse/Decluse.g:42:5: ( U id )
			// vb/week4/decluse/Decluse.g:42:7: U id
			{
			root_0 = (Object)adaptor.nil();


			U12=(Token)match(input,U,FOLLOW_U_in_use168); 
			U12_tree = (Object)adaptor.create(U12);
			adaptor.addChild(root_0, U12_tree);

			pushFollow(FOLLOW_id_in_use170);
			id13=id();
			state._fsp--;

			adaptor.addChild(root_0, id13.getTree());

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
	// $ANTLR end "use"


	public static class id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "id"
	// vb/week4/decluse/Decluse.g:44:1: id : ( LETTER )+ ;
	public final DecluseParser.id_return id() throws RecognitionException {
		DecluseParser.id_return retval = new DecluseParser.id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LETTER14=null;

		Object LETTER14_tree=null;

		try {
			// vb/week4/decluse/Decluse.g:44:4: ( ( LETTER )+ )
			// vb/week4/decluse/Decluse.g:44:6: ( LETTER )+
			{
			root_0 = (Object)adaptor.nil();


			// vb/week4/decluse/Decluse.g:44:6: ( LETTER )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==LETTER) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// vb/week4/decluse/Decluse.g:44:7: LETTER
					{
					LETTER14=(Token)match(input,LETTER,FOLLOW_LETTER_in_id179); 
					LETTER14_tree = (Object)adaptor.create(LETTER14);
					adaptor.addChild(root_0, LETTER14_tree);

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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
	// $ANTLR end "id"

	// Delegated rules



	public static final BitSet FOLLOW_LPAREN_in_program97 = new BitSet(new long[]{0x0000000000000390L});
	public static final BitSet FOLLOW_serie_in_program100 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_RPAREN_in_program102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unit_in_serie116 = new BitSet(new long[]{0x0000000000000292L});
	public static final BitSet FOLLOW_decl_in_unit127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_use_in_unit134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_unit141 = new BitSet(new long[]{0x0000000000000390L});
	public static final BitSet FOLLOW_serie_in_unit144 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_RPAREN_in_unit146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_D_in_decl158 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_id_in_decl160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_U_in_use168 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_id_in_use170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LETTER_in_id179 = new BitSet(new long[]{0x0000000000000022L});
}
