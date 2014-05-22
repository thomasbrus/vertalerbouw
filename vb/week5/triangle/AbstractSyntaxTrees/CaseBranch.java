package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseBranch extends AST {

  public CaseBranch(SourcePosition thePosition) {
    super (thePosition);
  }

  public abstract boolean equals(Object obj);

}
