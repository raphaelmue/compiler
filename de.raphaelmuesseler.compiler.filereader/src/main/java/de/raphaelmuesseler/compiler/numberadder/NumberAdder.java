package de.raphaelmuesseler.compiler.numberadder;

import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;
import de.raphaelmuesseler.compiler.numberreader.NumberReader;
import de.raphaelmuesseler.compiler.numberreader.NumberReaderIntf;

public class NumberAdder implements NumberAdderIntf {
    private final NumberReaderIntf numberReader;

    public NumberAdder(FileReaderIntf fileReader) {
        this.numberReader = new NumberReader(fileReader);
    }

    @Override
    public int getSum() throws Exception {
        return this.getExpression();
    }

    private int getExpressionBegin() throws Exception {
        return this.numberReader.getNumber();
    }

    private int getExpressionAdd() throws Exception {
        if (this.numberReader.getFileReader().lookAheadChar() == '+') {
            this.numberReader.getFileReader().advance();
            return this.getExpression();
        } else {
            this.numberReader.getFileReader().expect((char) 10);
        }
        return 0;
    }

    private int getExpression() throws Exception {
        return this.getExpressionBegin() + this.getExpressionAdd();
    }
}
