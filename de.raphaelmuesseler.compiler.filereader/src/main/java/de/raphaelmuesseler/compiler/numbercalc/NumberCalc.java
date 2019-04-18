package de.raphaelmuesseler.compiler.numbercalc;

import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;
import de.raphaelmuesseler.compiler.numberreader.NumberReader;
import de.raphaelmuesseler.compiler.numberreader.NumberReaderIntf;

public class NumberCalc implements NumberCalcIntf {
    private final NumberReaderIntf numberReader;

    NumberCalc(FileReaderIntf fileReader) {
        this.numberReader = new NumberReader(fileReader);
    }

    @Override
    public int getSum() throws Exception {
        return this.getProduct() + this.getSumExpression();
    }

    @Override
    public int getProduct() throws Exception {
        return this.getFactor() * this.getMultiplicationExpression();
    }

    @Override
    public int getFactor() throws Exception {
        int factor;
        if (this.numberReader.getFileReader().lookAheadChar() == '(') {
            this.numberReader.getFileReader().advance();
            factor = getSum();
            this.numberReader.getFileReader().expect(')');
            this.numberReader.getFileReader().advance();
        } else {
            factor = this.numberReader.getNumber();
        }
        return factor;
    }

    private int getMultiplicationExpression() throws Exception {
        int product = 1;
        while (this.numberReader.getFileReader().lookAheadChar() == '*') {
            this.numberReader.getFileReader().advance();
            product *= this.getFactor();
        }
        return product;
    }

    private int getSumExpression() throws Exception {
        int sum = 0;
        while (this.numberReader.getFileReader().lookAheadChar() == '+') {
            this.numberReader.getFileReader().advance();
            sum += this.getSum();
        }
        return sum;
    }
}
