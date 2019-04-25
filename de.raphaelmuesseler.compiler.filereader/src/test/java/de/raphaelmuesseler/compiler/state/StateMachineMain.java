package de.raphaelmuesseler.compiler.state;

import de.raphaelmuesseler.compiler.filereader.FileReader;
import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

import java.io.InputStream;

public class StateMachineMain extends TestBase {

    StateMachineMain(String fileName) throws Exception {
        super(fileName);
    }

    public String executeTest(String input) throws Exception {
        InputStream inputStream = stringToInputStream(input);
        FileReaderIntf fileReader = new FileReader(inputStream);
        StateReaderIntf stateReader = new StateReader(fileReader);
        while (fileReader.lookAheadChar() != '#') {
            stateReader.readState();
        }
        fileReader.advance();
        fileReader.advance();
        StringBuilder output = new StringBuilder();
        while (fileReader.lookAheadChar() != '$' && fileReader.lookAheadChar() != 10) {
            StringBuilder word = new StringBuilder();
            while (fileReader.lookAheadChar() != '\n' && fileReader.lookAheadChar() != 0) {
                word.append(fileReader.lookAheadChar());
                fileReader.advance();
            }
            fileReader.advance();
            output.append(testWord(stateReader.getStateMap(), word.toString(), false));
            output.append('\n');
        }
        return output.toString();
    }

    static String testWord(StateMap stateMachine, String word, Boolean verbose) {
        State currentState = stateMachine.getStartState();
        int curCharIdx = 0;
        int wordLen = word.length();
        while (curCharIdx != wordLen) {
            char nextChar = word.charAt(curCharIdx);
            State nextState = currentState.getTransition(nextChar);
            if (nextState == null) {
                String result = "missing transition in state: ";
                result += currentState.getName();
                result += " ";
                result += nextChar;
                return result;
            }
            if (verbose) {
                System.err.print(nextChar);
                System.err.print("->");
                System.err.println(nextState.getName());
            }
            currentState = nextState;
            curCharIdx++;
        }
        if (currentState.isFinal()) {
            return "ok";
        } else {
            String result = "unexpected end in state: ";
            result += currentState.getName();
            return result;
        }
    }
}
