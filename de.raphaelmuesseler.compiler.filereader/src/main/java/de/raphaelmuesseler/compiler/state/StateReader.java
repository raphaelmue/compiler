package de.raphaelmuesseler.compiler.state;

import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

public class StateReader implements StateReaderIntf {
    private FileReaderIntf fileReader;
    private StateMap stateMap;

    StateReader(FileReaderIntf reader) {
        fileReader = reader;
        stateMap = new StateMap();
    }

    @Override
    public void readState() throws Exception {
        String stateName = getIdent();
        State state = stateMap.getState(stateName);
        fileReader.expect(':');
        while (fileReader.lookAheadChar() == '(') {
            fileReader.advance();
            char terminal = fileReader.lookAheadChar();
            fileReader.advance();
            fileReader.expect(',');
            String targetStateName = getIdent();
            State targetState = stateMap.getState(targetStateName);
            fileReader.expect(')');
            state.addTransition(terminal, targetState);
        }
        if (fileReader.lookAheadChar() == '!') {
            fileReader.advance();
            state.setFinal();
        }
        fileReader.expect('\n');
    }

    @Override
    public String getIdent() throws Exception {
        StringBuilder ident = new StringBuilder();
        char nextChar = fileReader.lookAheadChar();
        if (isIdentifierStart(nextChar)) {
            do {
                ident.append(nextChar);
                fileReader.advance();
                nextChar = fileReader.lookAheadChar();
            } while (isIdentifierPart(nextChar));
        } else {
            throw new Exception("Identifier expected");
        }
        return ident.toString();
    }

    @Override
    public boolean isIdentifierStart(char c) {
        return ('a' <= c && c <= 'z');
    }

    @Override
    public boolean isIdentifierPart(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    @Override
    public StateMap getStateMap() {
        return stateMap;
    }
}
