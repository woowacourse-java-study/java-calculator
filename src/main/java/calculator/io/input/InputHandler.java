package calculator.io.input;

import calculator.io.reader.Reader;

public class InputHandler {
	
	private final Reader reader;
	private final InputValidator inputValidator;
	private final InputParser inputParser;
	
	public InputHandler(Reader reader, InputValidator inputValidator, InputParser inputParser) {
		this.reader = reader;
		this.inputValidator = inputValidator;
		this.inputParser = inputParser;
	}
	
	public String getStringToAdd() {
		String input = inputParser.parseStringToAdd(reader.readLine());
		inputValidator.validateStringToAdd(input);
		return input;
	}
}
