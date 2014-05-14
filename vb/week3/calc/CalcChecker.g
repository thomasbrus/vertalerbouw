tree grammar CalcChecker;

options {
    tokenVocab=Calc;                    // import tokens from Calc.tokens
    ASTLabelType=CommonTree;            // AST nodes are of type CommonTree
}

@header {
package vb.week3.calc;
import java.util.Set;
import java.util.HashSet;
}

// Alter code generation so catch-clauses get replaced with this action. 
// This disables ANTLR error handling: CalcExceptions are propagated upwards.
@rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@members {
    // idset - a set of declared identifiers.
    private Set<String> idset = new HashSet<String>();   
    
    public boolean  isDeclared(String s)     { return idset.contains(s); }
    public void     declare(String s)        { idset.add(s);             }
}

program
    :   ^(PROGRAM (declaration | statement)+)
    ;
    
declaration
    :   ^(VAR id=IDENTIFIER type)
        {   if (isDeclared($id.text))
                throw new CalcException($id, "is already declared");
            else 
                declare($id.getText()); 
        }
    ;
 
statement 
    :   ^(BECOMES id=IDENTIFIER statement2)
        {   if (!isDeclared($id.text))
                throw new CalcException($id, "is not declared");
        }
    |   ^(PRINT expr)
    |   ^(SWAP x=IDENTIFIER y=IDENTIFIER)
        {   if (!isDeclared($x.text))
                throw new CalcException($x, "is not declared");
            if (!isDeclared($y.text))
                throw new CalcException($y, "is not declared");
        }
    |   DO statement+ WHILE expr
    ;
    
statement2
    : ^(BECOMES id=IDENTIFIER statement2)    
        {   if (!isDeclared($id.text))
                throw new CalcException($id, "is not declared");
        }
    | expr;

expr 
    :   expr1
    |   ^(IF expr expr expr)      
    ;    

expr1 
    :   expr2
    |   ^(GT  expr expr)
    |   ^(GTE expr expr)      
    |   ^(EQ  expr expr)      
    |   ^(NEQ expr expr)      
    |   ^(LTE expr expr)      
    |   ^(LT  expr expr)      
    ;  

expr2
    :   expr3
    |   ^(PLUS expr expr)
    |   ^(MINUS expr expr)       
    ;
    
expr3
    :   operand
    |   ^(TIMES expr expr)
    |   ^(DIV expr y=expr)  
    ;  



    
    
operand
    :   id=IDENTIFIER 
        {   if (!isDeclared($id.text))
                throw new CalcException($id, "is not declared");
        }
    |   n=NUMBER 
    ;
    
type
    :   INTEGER
    ;
