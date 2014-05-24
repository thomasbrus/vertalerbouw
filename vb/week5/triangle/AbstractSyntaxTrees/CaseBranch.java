package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseBranch extends AST {
  public IntegerLiteral IL;
  public Command C;

  public CaseBranch(IntegerLiteral ilAST, Command cAST, SourcePosition thePosition) {
    super(thePosition);
    IL = ilAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCaseBranch(this, o);
  }
}
