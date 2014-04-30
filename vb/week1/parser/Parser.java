package vb.week1.symtab;

import java.io.*;

public class Parser {
  private SymbolTable table;
  public Parser(){
    table = new SymbolTable();
  }
	
  public Boolean isValid(String input) {
    String rest = parseDecluse(input);
    return (rest != null && rest.trim().isEmpty());
  }

  public String parseDecluse(String input) {
    String openRest = parseOpen(parseWhitespace(input));
    if (openRest == null) return null;

    String serieRest = parseSerie(parseWhitespace(openRest));
    if (serieRest == null) return null;

    return parseClose(parseWhitespace(serieRest));
  }

  public String parseOpen(String input) {
    if (input.charAt(0) == '('){
    	table.openScope();
    	return input.substring(1);
    }
    return null;
  }

  public String parseClose(String input) {
    if (input.charAt(0) == ')'){
    	table.closeScope();
    	return input.substring(1);
    }
    return null;
  }

  public String parseSerie(String input) {
    String unitRest = parseUnit(input);
    if (unitRest == null) return input;
    return parseSerie(parseWhitespace(unitRest));
  }

  public String parseUnit(String input) {
    String declRest = parseDecl(input);
    if (declRest != null) return declRest;

    String useRest = parseUse(input);
    if (useRest != null) return useRest;

    return parseDecluse(input);
  }

  public String parseDecl(String input) {
    if (input.startsWith("D:")){
    	String rest = parseId(input.substring(2));
    	String id = input.substring(2, input.length() - rest.length());
    	try {
			table.enter(id, new IdEntry());
		} catch (SymbolTableException e) {
			System.err.println(e);
		}
    	System.out.println("D:"+id + " on level "+table.currentLevel());
    	return parseId(rest);
    }
    return null;
  }

  public String parseUse(String input) {
    if (input.startsWith("U:")){
    	String rest = parseId(input.substring(2));
    	String id = input.substring(2, input.length() - rest.length());
    	IdEntry currentEntry = table.retrieve(id);    	
		System.out.print("D:"+id + " on level "+table.currentLevel()+", ");
		if(currentEntry != null){ System.out.println("declared on level "+currentEntry.getLevel()); } else {
			System.out.println("*undeclared*");
		}    	
    	return parseId(rest);
    }
    return null;
  }

  public String parseId(String input) {
    String letterRest = parseLetter(input);
    if (letterRest == null) return input;
    return parseId(letterRest);
  }

  public String parseLetter(String input) {
    char character = input.charAt(0);
    if (Character.getType(character) == Character.LOWERCASE_LETTER) return input.substring(1);
    return null;
  }

  public String parseWhitespace(String input) {
    char character = input.charAt(0);
    if (Character.isWhitespace(character)) return parseWhitespace(input.substring(1));
    return input;
  }

  public static void main(String[] args) throws IOException {
    String input = "", line;
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    while ((line = stdin.readLine()) != null && line.length() != 0) {
      input += line;
    }

    Boolean isValidSyntax = (new Parser()).isValid(input);
    System.out.println(isValidSyntax);
  }
}