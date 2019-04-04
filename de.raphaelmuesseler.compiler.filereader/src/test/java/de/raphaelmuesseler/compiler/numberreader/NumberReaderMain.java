package de.raphaelmuesseler.compiler.numberreader;

import de.raphaelmuesseler.compiler.filereader.FileReader;
import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

import java.io.InputStream;

public class NumberReaderMain extends TestBase {

	public NumberReaderMain(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberReaderIntf numberReader = new NumberReader(fileReader);
		int number = numberReader.getNumber();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}
