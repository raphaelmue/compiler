package de.raphaelmuesseler.compiler.filereader;

import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader implements FileReaderIntf {
    private final InputStreamReader inputStream;
    private char lookAheadChar;
    private String currentLine = "";
    private boolean eofAfterCurrentLine = false;
    private int currentLineNextPosition = 0;

    public FileReader(InputStream inputStream) throws Exception {
        this.inputStream = new InputStreamReader(inputStream);
        this.advance();
    }

    @Override
    public char lookAheadChar() {
        return this.lookAheadChar;
    }

    @Override
    public void advance() throws Exception {
        while (this.currentLineNextPosition == currentLine.length()) {
            if (this.eofAfterCurrentLine) {
                lookAheadChar = 0;
                return;
            } else {
                readNextLine();
                currentLineNextPosition = 0;
            }
        }
        lookAheadChar = currentLine.charAt(currentLineNextPosition);
        currentLineNextPosition++;
    }

    @Override
    public void expect(char c) throws Exception {
        if (this.lookAheadChar != c) {
            throw new Exception("Unexpected character: '" + this.lookAheadChar + "'\nExpected: '" + c + "'\n" + this.getCurrentLocationMsg());
        }
        this.advance();
    }

    @Override
    public void expect(String s) throws Exception {
        for (int i = 0; i < s.length(); i++) {
            if (this.lookAheadChar != s.charAt(i)) {
                throw new Exception("Unexpected character: '" + this.lookAheadChar + "'\nExpected: '" + s + "'\n" + this.getCurrentLocationMsg());
            }
        }
        this.advance();
    }

    @Override
    public String getCurrentLocationMsg() {
        return this.currentLine + " ".repeat(Math.max(0, this.currentLineNextPosition - 1)) +
                "^\n";
    }

    private void readNextLine() throws Exception{
        this.currentLine = "";
        while (true) {
            int nextChar = this.inputStream.read();
            if (nextChar == -1) {
                this.currentLine += '\n';
                this.eofAfterCurrentLine = true;
                return;
            } else if (nextChar == '\r') {
                continue;
            } else if (nextChar == '\n') {
                this.currentLine += '\n';
                return;
            } else {
                this.currentLine += (char) nextChar;
            }
        }
    }
}
