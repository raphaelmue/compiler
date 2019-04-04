package de.raphaelmuesseler.compiler.filereader;

import java.io.InputStream;

public class FileReaderMain extends TestBase {

	public FileReaderMain(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		while(fileReader.lookAheadChar() != 0) {
			output += fileReader.lookAheadChar();
			fileReader.advance();
		}
		return output;
	}
}
