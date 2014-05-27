/*
 * @(#)IfCommand.java                        2.0 1999/08/11
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

public class CaseCommand extends Command {

  public CaseCommand (Expression eAST, CaseBranch cbAST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    CB = cbAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCaseCommand(this, o);
  }

  public Expression E;
  public CaseBranch CB;
  public Command C;
}
