package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class SingleCaseBranch extends CaseBranch {
  public Command CE;

  public SingleCaseBranch(IntegerLiteral ilAST, Command cAST,
                          Command ceAST,
                          SourcePosition thePosition) {
    super(ilAST, cAST, thePosition);
    CE = ceAST;
  }
}
