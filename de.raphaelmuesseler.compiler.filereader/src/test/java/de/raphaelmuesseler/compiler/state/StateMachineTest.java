package de.raphaelmuesseler.compiler.state;

import org.junit.jupiter.api.Test;

public class StateMachineTest {

	@Test
	public void testStateReader() throws Exception {
		System.err.println("BEGIN");
		StateMachineMain test = new StateMachineMain("./src/test/resources/de/raphaelmuesseler/compiler/state/StateMachine.txt");
		test.testRun();
		System.err.println("END");
	}

}
