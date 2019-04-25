package de.raphaelmuesseler.compiler.lexer;

import org.junit.jupiter.api.Test;

public class LexerMain {

	@Test
	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		LexerTest test = new LexerTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}
