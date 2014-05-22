package vb.week5.triangle.AbstractSyntaxTrees;

import vb.week5.triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatUntilCommand extends Command {

  public RepeatUntilCommand (Command cAST, Expression eAST, SourcePosition thePosition) {
    super (thePosition);
    C = cAST;
    E = eAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitRepeatUntilCommand(this, o);
  }

  public Command C;
  public Expression E;
}
