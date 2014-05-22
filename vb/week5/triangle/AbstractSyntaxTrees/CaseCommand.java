package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class CaseCommand extends Command {

  public CaseCommand(Expression eAST, CaseBranch cbAST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    CB = cbAST;
    C = aAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCaseCommand(this, o);
  }

  public Expression E;
  public CaseBranch CB;
  public CaseBranch C;
}
