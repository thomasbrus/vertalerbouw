/*
 * @(#)IfExpression.java                        2.0 1999/08/11
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

public class IfExpression extends Expression {

  public IfExpression (Expression e1AST, Expression e2AST, Expression e3AST,
             SourcePosition thePosition) {
    super (thePosition);
    E1 = e1AST;
    E2 = e2AST;
    E3 = e3AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitIfExpression(this, o);
  }

  public Expression E1, E2, E3;
}
