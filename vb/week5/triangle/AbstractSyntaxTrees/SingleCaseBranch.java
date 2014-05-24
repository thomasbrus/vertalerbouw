package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class SingleCaseBranch extends CaseBranch {

  public SingleCaseBranch(IntegerLiteral ilAST, Command cAST,
                          SourcePosition thePosition) {
    super(ilAST, cAST, thePosition);
  }
}
