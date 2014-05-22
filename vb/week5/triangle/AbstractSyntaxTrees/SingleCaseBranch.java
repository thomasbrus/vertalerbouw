package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class SingleCaseBranch extends CaseBranch {

  public SingleCaseBranch(IntegerLiteral ilAST, Command cAST,
                          SourcePosition thePosition) {
    super (thePosition);
    IL = ilAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitSingleCaseBranch(this, o);
  }

  public boolean equals(Object obj) {
    if (obj != null && obj instanceof SingleCaseBranch) {
      SingleCaseBranch scb = (SingleCaseBranch)obj;
      return (this.IL.spelling.compareTo(scb.IL.spelling) == 0) &&
              this.C.equals(scb.C);
    } else
      return false;
  }

  public IntegerLiteral IL;
  public Command C;
}
