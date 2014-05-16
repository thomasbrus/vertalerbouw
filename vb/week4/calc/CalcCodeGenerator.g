// [file: CalcInterpreter.g, started: 22-Apr-2008]
//
// Calc - Simple calculator with memory variables.
// CalcInterpreter.g: interpreter
//
// @author   Theo Ruys
// @version  2008.04.22

tree grammar CalcCodeGenerator;

options {
    tokenVocab=Calc;                    // import tokens from Calc.tokens
    ASTLabelType=CommonTree;            // AST nodes are of type CommonTree
}

@header {
package vb.week4.calc;
import java.util.Map;
import java.util.HashMap;
}

@members { 
    private Map<String,Integer> stackStore = new HashMap<String,Integer>(); 
    private int contCounter = 0; 
    private int optCounter = 0;
    private int whileCounter = 0;
}

program
    :   ^(PROGRAM (declaration | statement)+) { System.out.println("POP(0)\t" + stackStore.size() + "\nHALT"); }
    ;
  
declaration
    :   ^(VAR id=IDENTIFIER type)
            {  stackStore.put($id.text, stackStore.size()); 
               System.out.println("PUSH\t1"); 
               System.out.println("LOADA\t" + stackStore.size() + "[SB]");  
               System.out.println("LOADL\t0");
            } 
    ;

statement 
    :   ^(BECOMES id=IDENTIFIER v=expr)     { System.out.println("STORE(1)\t" + stackStore.get($id.text)+"[SB]");  }
    |   ^(PRINT v=expr)                     { System.out.println("CALL\tputint");
                                              System.out.println("CALL\tputeol"); }
    |   ^(SWAP x=IDENTIFIER y=IDENTIFIER)   { System.out.println("LOAD(1)\t"  + stackStore.get($x.text) + "[SB]");
                                              System.out.println("LOAD(1)\t"  + stackStore.get($y.text) + "[SB]");
                                              System.out.println("STORE(1)\t" + stackStore.get($y.text) + "[SB]");
                                              System.out.println("STORE(1)\t" + stackStore.get($x.text) + "[SB]"); }     
    |   { System.out.print("WHILE" + whileCounter + ":\t"); } DO statement+ WHILE q=expr { System.out.println("JUMPIF(1)\tWHILE" + (whileCounter++) + "[CB]"); }      
    ;
    
expr returns [int val = 0;] 
    :   z=operand               { }
    |   ^(PLUS x=expr y=expr)   { System.out.println("CALL\tadd");  }
    |   ^(MINUS x=expr y=expr)  { System.out.println("CALL\tsub");  }
    |   ^(TIMES x=expr y=expr)  { System.out.println("CALL\tmult");  }
    |   ^(DIV x=expr y=expr)    { System.out.println("CALL\tdiv");  }   

    |   ^(GT    x=expr y=expr)  { System.out.println("CALL\tgt"); }
    |   ^(GTE   x=expr y=expr)  { System.out.println("CALL\tge"); }
    |   ^(EQ    x=expr y=expr)  { System.out.println("LOADL\t1\nCALL\teq"); }
    |   ^(NEQ   x=expr y=expr)  { System.out.println("LOADL\t1\nCALL\tne"); }
    |   ^(LTE   x=expr y=expr)  { System.out.println("CALL\tle"); }
    |   ^(LT    x=expr y=expr)  { System.out.println("CALL\tlt"); }

    |   ^(BECOMES id=IDENTIFIER v=expr)       { int pos = stackStore.get($id.text);
               System.out.println("STORE(1) " + pos + "[SB]");
               System.out.println("LOAD(1) "  + pos + "[SB]"); }

    |   ^(IF c=expr { System.out.println("JUMPIF(0)\tOPT" + optCounter+"[SB]"); } e1=expr { System.out.println("JUMP\tCONT" + contCounter + "[SB]\nOPT" + (optCounter++) + ":\t"); } e2=expr)   
                    { System.out.print("CONT" + (contCounter++) + ": "); }
    ;
    
operand returns [int val = 0]
    :   id=IDENTIFIER   { System.out.println("LOAD(1)\t" + stackStore.get($id.text) + "[SB]"); } 
    |   n=NUMBER        { System.out.println("LOADL\t" + n); }
    ;
    

type
    :   INTEGER
    ;