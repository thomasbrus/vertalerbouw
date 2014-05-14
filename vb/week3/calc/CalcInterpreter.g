// [file: CalcInterpreter.g, started: 22-Apr-2008]
//
// Calc - Simple calculator with memory variables.
// CalcInterpreter.g: interpreter
//
// @author   Theo Ruys
// @version  2008.04.22

tree grammar CalcInterpreter;

options {
    tokenVocab=Calc;                    // import tokens from Calc.tokens
    ASTLabelType=CommonTree;            // AST nodes are of type CommonTree
}

@header {
package vb.week3.calc;
import java.util.Map;
import java.util.HashMap;
}

@members { 
    private Map<String,Integer> store = new HashMap<String,Integer>();   
}

program
    :   ^(PROGRAM (declaration | statement)+)
    ;

program2 
    : (declaration | statement)+
    ;
    
declaration
    :   ^(VAR id=IDENTIFIER type)
            { store.put($id.text, 0); } 
    ;

statement 
@init{ int ix = input.index(); }
    :   ^(BECOMES id=IDENTIFIER v=expr)
            { store.put($id.text, v);       }
    |   ^(PRINT v=expr)
            { System.out.println("" + v);   }
    |   ^(SWAP x=IDENTIFIER y=IDENTIFIER)
            { 
                Integer val_x = store.get($x.text);
                store.put($x.text, store.get($y.text));
                store.put($y.text, val_x);
            }     
    |   DO statement+ WHILE q=expr {            if(q != 0) {input.rewind(ix);} }      
    ;
    
expr returns [int val = 0;] 
    :   z=operand               { val = z;      }
    |   ^(PLUS x=expr y=expr)   { val = x + y;  }
    |   ^(MINUS x=expr y=expr)  { val = x - y;  }
    |   ^(TIMES x=expr y=expr)  { val = x * y;  }
    |   ^(DIV x=expr y=expr)    {             
        if (y==0){ System.out.println("Cannot divide by zero"); System.exit(1); }   val = x / y;  }   

    |   ^(GT    x=expr y=expr)  { val = x > y ? 1:0; }
    |   ^(GTE   x=expr y=expr)  { val = x >= y? 1:0; }
    |   ^(EQ    x=expr y=expr)  { val = x == y? 1:0; }
    |   ^(NEQ   x=expr y=expr)  { val = x != y? 1:0; }
    |   ^(LTE   x=expr y=expr)  { val = x <= y? 1:0; }
    |   ^(LT    x=expr y=expr)  { val = x < y ? 1:0; }

    |   ^(BECOMES id=IDENTIFIER v=expr)       { store.put($id.text, v); val=v; }


    |   ^(IF c=expr e1=expr e2=expr)   {             
        val  = c!=0 ? e1 : e2; }
    ;
    
operand returns [int val = 0]
    :   id=IDENTIFIER   { val = store.get($id.text);       } 
    |   n=NUMBER        { val = Integer.parseInt($n.text); }
    ;
    
type
    :   INTEGER
    ;
