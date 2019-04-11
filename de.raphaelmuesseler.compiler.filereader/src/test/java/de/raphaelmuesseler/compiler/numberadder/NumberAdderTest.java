package de.raphaelmuesseler.compiler.numberadder;

import org.junit.jupiter.api.Test;

public class NumberAdderTest {

	@Test
	public void testNumberAdder() throws Exception {
		System.err.println("BEGIN");
		NumberAdderMain test = new NumberAdderMain("./src/test/resources/de/raphaelmuesseler/compiler/numberadder/numberAdder.txt");
		test.testRun();
		System.err.println("END");
	}

}

