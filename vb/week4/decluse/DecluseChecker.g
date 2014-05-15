tree grammar DecluseChecker;

options {
  tokenVocab=Decluse; // import tokens from Decluse.tokens
  ASTLabelType=CommonTree;  // AST nodes are of type CommonTree
}

@header {
  package vb.week4.decluse;
  import vb.week1.symtab.*;
}

// Alter code generation so catch-clauses get replaced with this action.
// This disables ANTLR error handling: DecluseExceptions are propagated upwards.
@rulecatch {
  catch (RecognitionException e) {
    throw e;
  }
}

@members {
  private SymbolTable symbolTable = new SymbolTable<IdEntry>();

  public boolean isDeclared(String s) { return symbolTable.retrieve(s) != null; }

  public void declare(String s) throws SymbolTableException {
    symbolTable.enter(s, new IdEntry());
  }
}

decluse throws SymbolTableException: serie;

serie throws SymbolTableException @init { symbolTable.openScope(); }
   : ^(SERIE unit*) { symbolTable.closeScope(); }
   ;

unit throws SymbolTableException: use | decl | serie;

decl throws SymbolTableException: ^(DECL id=IDENTIFIER) {
    declare($id.getText());
  };

use throws SymbolTableException: ^(USE id=IDENTIFIER) {
    if (!isDeclared($id.text)) throw new SymbolTableException($id + "is not declared");
  };
