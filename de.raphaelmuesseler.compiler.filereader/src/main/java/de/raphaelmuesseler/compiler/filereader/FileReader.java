package de.raphaelmuesseler.compiler.filereader;

import java.io.IOException;
import java.io.InputStream;

public class FileReader implements FileReaderIntf {
    private final InputStream inputStream;
    private char lookAheadChar;

    public FileReader(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
        int nextChar = inputStream.read();
        if (nextChar == -1) {
            this.lookAheadChar = 0;
        } else {
            this.lookAheadChar = (char) nextChar;
        }
    }

    @Override
    public char lookAheadChar() {
        return this.lookAheadChar;
    }

    @Override
    public void advance() throws Exception {
        int nextChar = inputStream.read();
        if (nextChar == -1) {
            this.lookAheadChar = 0;
        } else {
            this.lookAheadChar = (char) nextChar;
        }
    }

    @Override
    public void expect(char c) throws Exception {
        if (this.lookAheadChar != c) {
            throw new Exception("Unexpected character: '" + this.lookAheadChar + "' expected: '" + c + "'");
        }
    }
}
