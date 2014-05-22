package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class MultipleCaseBranch extends CaseBranch {
  public CaseBranch CB;

  public MultipleCaseBranch(IntegerLiteral ilAST, Command cAST, CaseBranch cbAST,
                          SourcePosition thePosition) {
    super (ilAST, cAST, thePosition);
    CB = cbAST;
  }

  public boolean equals(Object obj) {
    if (obj != null && obj instanceof MultipleCaseBranch) {
      MultipleCaseBranch mcb = (MultipleCaseBranch)obj;
      return (this.IL.spelling.compareTo(mcb.IL.spelling) == 0) &&
              this.C.equals(mcb.C) &&
              this.CB.equals(mcb.CB);
    } else
      return false;
  }
}
