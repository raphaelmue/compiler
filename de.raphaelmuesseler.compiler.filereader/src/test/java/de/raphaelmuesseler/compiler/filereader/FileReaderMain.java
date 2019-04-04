package de.raphaelmuesseler.compiler.filereader;

import org.junit.jupiter.api.Test;

public class FileReaderMain {

    @Test
    public void testFileReader() throws Exception {
        System.err.println("BEGIN");
        FileReaderTest test = new FileReaderTest("./src/test/resources/de/raphaelmuesseler/compiler/filereader/fileReader.txt");
        test.testRun();
        System.err.println("END");
    }

}
