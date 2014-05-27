package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class MultipleCaseBranch extends CaseBranch {

  public MultipleCaseBranch (IntegerLiteral ilAST, Command cAST, CaseBranch cbAST, SourcePosition thePosition) {
    super (thePosition);
    IL = ilAST;
    C = cAST;
    CB = cbAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitMultipleCaseBranch(this, o);
  }

  public boolean equals (Object obj) {
    if (obj != null && obj instanceof MultipleCaseBranch) {
      MultipleCaseBranch mcb = (MultipleCaseBranch) obj;
      return (this.IL.spelling.compareTo(mcb.IL.spelling) == 0) &&
              this.C.equals(mcb.C) &&
              this.CB.equals(mcb.CB);
    } else
      return false;
  }

  public IntegerLiteral IL;
  public Command C;
  public CaseBranch CB;
}
