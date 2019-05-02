package de.raphaelmuesseler.compiler.lexer;

import org.junit.jupiter.api.Test;

public class LexerTest {

	@Test
	public void testLexer() throws Exception {
		System.err.println("BEGIN");
		LexerMain test = new LexerMain("./src/test/resources/de/raphaelmuesseler/compiler/lexer/Lexer.txt");
		test.testRun();
		System.err.println("END");
	}

}
