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
    TIMES		=   '*'		;
    DIV			=   '/'		;
 
    GTE         =   '>='    ;
    GT          =   '>'     ;
    LTE         =   '<='    ;
    LT          =   '<'     ;
    EQ          =   '=='    ;
    NEQ         =   '!='    ;

    DO          =   'do';
    WHILE       =   'while';

    // keywords
    PROGRAM     =   'program'   ;
    VAR         =   'var'       ;
    PRINT       =   'print'     ;
    INTEGER     =   'integer'   ;
    SWAP        =   'swap'      ;
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
    :   program2 EOF
            ->  ^(PROGRAM program2)
    ;
    
program2
    :  ((declaration | statement) SEMICOLON!)*
    ;



declaration
    :   VAR^ IDENTIFIER COLON! type
    ;
    
statement
    :   assignment
    |   print_stat
    |   swap
    |   dowhileStatement
    ;

print_stat
    :   PRINT^ LPAREN! expr RPAREN!
    ;

swap
    :   SWAP^ LPAREN! IDENTIFIER COMMA! IDENTIFIER RPAREN!
    ;


dowhileStatement : DO statements WHILE expr;
statements       : (statement SEMICOLON!)+ ;


lvalue
    :   IDENTIFIER
    ;    

assignment
    :   lvalue BECOMES^ expr0
    ;

expr0
    :   expr (BECOMES^ expr)*
    ;

expr
    :   expr1
    |   IF^ expr1 THEN! expr1 ELSE! expr1
    ;    

expr1
    :   expr2 ((GT^ | GTE^ | LT^ | LTE^ | EQ^ | NEQ^) expr2 )*
    ;

expr2
    :   expr3 ((PLUS^ | MINUS^) expr3 )*
    ;

expr3
    :   operand ((TIMES^ | DIV^) operand )*
    ;     

operand
    :   NUMBER
    |   LPAREN! expr RPAREN!
    |   IDENTIFIER
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

