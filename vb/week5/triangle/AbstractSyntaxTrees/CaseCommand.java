package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class CaseCommand extends Command {

  public CaseCommand(Expression eAST, CaseBranch cbAST, SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    CB = cbAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCaseCommand(this, o);
  }

  public Expression E;
  public CaseBranch CB;
}
