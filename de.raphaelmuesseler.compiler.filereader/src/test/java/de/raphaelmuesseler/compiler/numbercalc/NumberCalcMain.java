package de.raphaelmuesseler.compiler.numbercalc;

import de.raphaelmuesseler.compiler.filereader.FileReader;
import de.raphaelmuesseler.compiler.filereader.FileReaderIntf;

import java.io.InputStream;

public class NumberCalcMain extends TestBase {

	public NumberCalcMain(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberCalcIntf numberCalc = new NumberCalc(fileReader);
		double number = numberCalc.getSum();
		output += Double.toString(number);
		output += '\n';
		return output;
	}
}
