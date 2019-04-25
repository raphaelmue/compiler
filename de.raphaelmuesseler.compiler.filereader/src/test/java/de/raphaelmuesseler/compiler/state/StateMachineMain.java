package de.raphaelmuesseler.compiler.state;

import org.junit.jupiter.api.Test;

public class StateMachineMain {

	@Test
	public void testStateReader() throws Exception {
		System.err.println("BEGIN");
		StateMachineTest test = new StateMachineTest("./src/test/resources/de/raphaelmuesseler/compiler/state/StateMachine.txt");
		test.testRun();
		System.err.println("END");
	}

}
