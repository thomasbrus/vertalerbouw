package vb.week1.symtab;

public class SymbolTableTest {

  public static void main(String[] args) {
    SymbolTable symbolTable = new SymbolTable();

    try {
      symbolTable.openScope();
      symbolTable.enter("x", new IdEntry());
      symbolTable.closeScope();

      System.out.println(symbolTable.retrieve("y"));
      System.out.println(symbolTable.retrieve("x"));

    } catch (SymbolTableException e) {
      System.out.println(e.getMessage());
    }
  }

}
