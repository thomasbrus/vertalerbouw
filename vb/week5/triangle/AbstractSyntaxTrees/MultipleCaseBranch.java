/*
 * @(#)MultipleFieldTypeDenoter.java                2.0 1999/08/11
 *
 * Copyright (C) 1999 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

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
