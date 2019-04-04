package de.raphaelmuesseler.compiler.filereader;

import org.junit.jupiter.api.Test;

public class FileReaderTest {

    @Test
    public void testFileReader() throws Exception {
        System.err.println("BEGIN");
        FileReaderMain test = new FileReaderMain("./src/test/resources/de/raphaelmuesseler/compiler/filereader/fileReader.txt");
        test.testRun();
        System.err.println("END");
    }

}
