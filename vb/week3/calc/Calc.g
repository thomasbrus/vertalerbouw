grammar Calc;

options {
    k=1;                                // LL(1) - do not use LL(*)
    language=Java;                      // target language is Java (= default)
    output=AST;                         // build an AST
}

tokens {
    COLON       =   ':'     ;
    SEMICOLON   =   ';'     ;
    COMMA       =   ','     ;
    LPAREN      =   '('     ;
    RPAREN      =   ')'     ;

    // operators
    BECOMES     =   ':='    ;
    PLUS        =   '+'     ;
    MINUS       =   '-'     ;
    MUL         =   '*'     ;
    DIV         =   '/'     ;

    // boolean comparison
    LT          =   '<'     ;
    LTE         =   '<='    ;
    GT          =   '>'     ;
    GTE         =   '>='    ;
    EQ          =   '=='    ;
    NEQ         =   '!='    ;

    // keywords
    PROGRAM     =   'program'   ;
    VAR         =   'var'       ;
    PRINT       =   'print'     ;
    SWAP        =   'swap'      ;
    INTEGER     =   'integer'   ;
    IF          =   'if'        ;
    THEN        =   'then'      ;
    ELSE        =   'else'      ;
}

@lexer::header {
package vb.week3.calc;
}

@header {
package vb.week3.calc;
}

// Parser rules

program
    :   units ->  ^(PROGRAM units)
    ;

units
    : unit (unit)* EOF!
    ;

unit
    : declarations statement SEMICOLON!
    ;

declarations
    :   (declaration SEMICOLON!)*
    ;

statements
    :   (statement SEMICOLON!)+
    ;

declaration
    :   VAR^ IDENTIFIER COLON! type
    ;

statement
    :   assignment
    |   print_stat
    |   swap_stat
    ;

assignment
    :   lvalue BECOMES^ expr
    ;

print_stat
    :   PRINT^ LPAREN! expr RPAREN!
    ;

swap_stat
    :  SWAP^ LPAREN! IDENTIFIER COMMA! IDENTIFIER RPAREN!
    ;

lvalue
    :   IDENTIFIER
    ;

expr
    :   IF^ expr2 THEN! expr2 ELSE! expr2
    |   expr2
    ;

expr2
    :   expr3 ((LT^ | LTE^ | GT^ | GTE^ | EQ^ | NEQ^) expr3)*
    ;

expr3
    :   expr4 ((PLUS^ | MINUS^) expr4)*
    ;

expr4
    :   operand ((MUL^ | DIV^) operand)*
    ;

operand
    :   IDENTIFIER
    |   NUMBER
    |   LPAREN! expr RPAREN!
    ;

type
    :   INTEGER
    ;


// Lexer rules

IDENTIFIER
    :   LETTER (LETTER | DIGIT)*
    ;

NUMBER
    :   DIGIT+
    ;


COMMENT
    :   '//' .* '\n'
            { $channel=HIDDEN; }
    ;

WS
    :   (' ' | '\t' | '\f' | '\r' | '\n')+
            { $channel=HIDDEN; }
    ;

fragment DIGIT  :   ('0'..'9') ;
fragment LOWER  :   ('a'..'z') ;
fragment UPPER  :   ('A'..'Z') ;
fragment LETTER :   LOWER | UPPER ;

// EOF
