package calculator.config.inputHandler;

import calculator.config.reader.ReaderConfig;
import calculator.io.input.InputHandler;
import calculator.io.input.InputParser;
import calculator.io.input.InputValidator;

public class InputHandlerConfig {
	
	private final InputHandler inputHandler;
	
	public InputHandlerConfig(ReaderConfig readerConfig) {
		this.inputHandler = new InputHandler(
				readerConfig.getReader(),
				new InputValidator(),
				new InputParser()
		);
	}
	
	public InputHandler getInputHandler() {
		return inputHandler;
	}
}
