package de.raphaelmuesseler.compiler;

public class TestBase extends TestBaseIntf {

    TestBase(String fileName) throws Exception {
        super(fileName);
    }

    @Override
    void readAndExecuteTestSequence() throws Exception {

    }

    @Override
    void readAndExecuteTestCase() throws Exception {

    }

    @Override
    String readTestContent() throws Exception {
        String testContent = "";
        while (this.fileReader.lookAheadChar() != '$') {
            testContent += this.fileReader.lookAheadChar();
            this.fileReader.advance();
        }
        return testContent;
    }

    @Override
    void readDollarIn() throws Exception {
        this.fileReader.expect("$IN\n");
    }

    @Override
    void readDollarOut() throws Exception {
        this.fileReader.expect("$OUT\n");
    }

    @Override
    protected String executeTest(String input) throws Exception {
        return null;
    }
}
