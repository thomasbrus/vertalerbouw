package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class MultipleCaseBranch extends CaseBranch {
  public CaseBranch CB;

  public MultipleCaseBranch(IntegerLiteral ilAST, Command cAST, CaseBranch cbAST,
                          SourcePosition thePosition) {
    super (ilAST, cAST, thePosition);
    CB = cbAST;
  }
}
