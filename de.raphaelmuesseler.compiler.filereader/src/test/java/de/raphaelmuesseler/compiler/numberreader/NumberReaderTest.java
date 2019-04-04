package de.raphaelmuesseler.compiler.numberreader;

import org.junit.jupiter.api.Test;

public class NumberReaderTest {

	@Test
	public void testNumberReader() throws Exception {
		System.err.println("BEGIN");
		NumberReaderMain test = new NumberReaderMain("./src/test/resources/de/raphaelmuesseler/compiler/numberreader/numberReader.txt");
		test.testRun();
		System.err.println("END");
	}

}

