package de.raphaelmuesseler.compiler.numberreader;

import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

public class NumberReader implements NumberReaderIntf {
    private final FileReaderIntf fileReader;

    public NumberReader(FileReaderIntf fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public int getNumber() throws Exception {
        StringBuilder result = new StringBuilder();
        while (this.fileReader.lookAheadChar() != 10) {
            if (this.isDigit(this.fileReader.lookAheadChar())) {
                result.append(this.fileReader.lookAheadChar());
                this.fileReader.advance();
            } else {
                throw new Exception("not a number");
            }
        }
        if (result.toString().isEmpty()) {
            throw new Exception("not a number");
        }
        return Integer.parseInt(result.toString());
    }

    @Override
    public boolean isDigit(char c) {
        return ((int) c) >= 48 && ((int) c) <= 57;
    }
}
