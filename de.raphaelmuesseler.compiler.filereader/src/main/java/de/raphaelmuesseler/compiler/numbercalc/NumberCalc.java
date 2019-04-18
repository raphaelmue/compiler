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
    public double getSum() throws Exception {
        return this.getProduct() + this.getSumExpression();
    }

    @Override
    public double getProduct() throws Exception {
        return this.getFactor() * this.getMultiplicationExpression();
    }

    @Override
    public double getFactor() throws Exception {
        double factor;
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

    private double getMultiplicationExpression() throws Exception {
        double product = 1;
        while (this.numberReader.getFileReader().lookAheadChar() == '*' ||
                this.numberReader.getFileReader().lookAheadChar() == '/') {
            if (this.numberReader.getFileReader().lookAheadChar() == '*') {
                this.numberReader.getFileReader().advance();
                product *= this.getFactor();
            } else if (this.numberReader.getFileReader().lookAheadChar() == '/') {
                this.numberReader.getFileReader().advance();
                product *= 1 / this.getFactor();
            }
        }
        return product;
    }

    private double getSumExpression() throws Exception {
        double sum = 0;
        while (this.numberReader.getFileReader().lookAheadChar() == '+' ||
                this.numberReader.getFileReader().lookAheadChar() == '-') {
            if (this.numberReader.getFileReader().lookAheadChar() == '+') {
                this.numberReader.getFileReader().advance();
                sum += this.getSum();
            } else if (this.numberReader.getFileReader().lookAheadChar() == '-') {
                this.numberReader.getFileReader().advance();
                sum -= this.getSum();
            }
        }
        return sum;
    }
}
