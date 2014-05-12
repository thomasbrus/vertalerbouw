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

@rulecatch {
    catch (CalcException e) {
        throw e;
    }
}

@members {
    private Map<String,Integer> store = new HashMap<String,Integer>();
}

program
    :   ^(PROGRAM (declaration | statement)+)
    ;

declaration
    :   ^(VAR id=IDENTIFIER type)
            { store.put($id.text, 0); }
    ;

statement
    :   ^(BECOMES id=IDENTIFIER v=expr)
            { store.put($id.text, v);       }
    |   ^(PRINT v=expr)
            { System.out.println("" + v);   }
    |   ^(SWAP id1=IDENTIFIER id2=IDENTIFIER)
            { Integer tmp = store.get($id1.text);
            store.put($id1.text, store.get($id2.text));
            store.put($id2.text, tmp); }
    ;

expr returns [int val = 0;]
    : z=expr2                   { val = z; }
    | ^(IF c=operand THEN e1=expr ELSE e2=expr) { val = e1; }
    ;

expr2 returns [int val = 0;]
    :   z=expr3                 { val = z;      }
    |   ^(PLUS x=expr y=expr)   { val = x + y;  }
    |   ^(MINUS x=expr y=expr)  { val = x - y;  }
    ;

expr3 returns [int val = 0;]
    :   z=operand               { val = z;      }
    |   ^(MUL x=expr y=expr)   { val = x * y;  }
    |   ^(DIV x=expr y=expr)  {
          if (y == 0) throw new CalcException("Cannot divide by zero!");
          val = x / y;
        }
    ;

operand returns [int val = 0]
    :   id=IDENTIFIER   { val = store.get($id.text);       }
    |   n=NUMBER        { val = Integer.parseInt($n.text); }
    ;

type
    :   INTEGER
    ;
