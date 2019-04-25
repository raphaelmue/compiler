package de.raphaelmuesseler.compiler.filereader;

import java.io.InputStream;

public class FileReaderMain extends TestBase {

	FileReaderMain(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		StringBuilder output = new StringBuilder();
		while(fileReader.lookAheadChar() != 0) {
			output.append(fileReader.lookAheadChar());
			fileReader.advance();
		}
		return output.toString();
	}
}
