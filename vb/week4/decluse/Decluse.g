grammar Decluse;

options {
  k=1; // LL(1) - do not use LL(*)
  language=Java; // target language is Java (= default)
  output=AST; // build an AST
}

tokens {
  LPAREN = '(' ;
  RPAREN = ')' ;

  D = 'D:' ;
  U = 'U:' ;
}

@lexer::header {
  package vb.week4.decluse;
}

@header {
  package vb.week4.decluse;
}

// Parser rules

program
  : LPAREN! serie RPAREN!
  ;

serie
  : unit*
  ;

unit: decl
   | use
   | LPAREN! serie RPAREN!
   ;

decl: D id;

use : U id;

id : (LETTER)+;

WS : (' ' | '\t' | '\f' | '\r' | '\n')+ { $channel=HIDDEN; };

fragment LOWER : ('a'..'z') ;
fragment UPPER : ('A'..'Z') ;
fragment LETTER : LOWER | UPPER ;
