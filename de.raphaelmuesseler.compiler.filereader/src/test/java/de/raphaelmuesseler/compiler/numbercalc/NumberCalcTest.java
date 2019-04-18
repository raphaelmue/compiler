package de.raphaelmuesseler.compiler.numbercalc;

import org.junit.jupiter.api.Test;

public class NumberCalcTest {

	@Test
	public void testNumberCalc() throws Exception {
		System.err.println("BEGIN");
		NumberCalcMain test = new NumberCalcMain("./src/test/resources/de/raphaelmuesseler/compiler/numbercalc/numberCalc.txt");
		test.testRun();
		System.err.println("END");
	}

}

