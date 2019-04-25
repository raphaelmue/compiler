package de.raphaelmuesseler.compiler.lexer;

abstract class TokenIntf {
	public enum Type {
		EOF,
		IDENT,
		INTEGER,
		PLUS,
		MINUS,
		MUL,
		DIV,
		LPAREN,
		RPAREN,
		ASSIGN,
	}

	public Type type;
	public int intValue;
	public String stringValue;

	// returns a string representation of the current token
	public abstract String toString();
	
	// returns a string representation of the given token type
	// static String type2String(Type type);		
}
