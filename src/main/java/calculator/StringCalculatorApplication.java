package calculator;

import calculator.config.controller.CalculatorControllerConfig;
import calculator.config.controller.DefaultCalculatorControllerConfig;
import calculator.config.inputHandler.InputHandlerConfig;
import calculator.config.outputHandler.OutputHandlerConfig;
import calculator.config.reader.DefaultReaderConfig;
import calculator.config.writer.DefaultWriterConfig;
import calculator.config.writer.WriterConfig;
import calculator.controller.CalculatorController;

public class StringCalculatorApplication {
	
	private final CalculatorController calculatorController;
	
	public StringCalculatorApplication() {
		WriterConfig writerConfig = new DefaultWriterConfig();
		InputHandlerConfig inputHandlerConfig = new InputHandlerConfig(new DefaultReaderConfig());
		OutputHandlerConfig outputHandlerConfig = new OutputHandlerConfig(writerConfig);
		CalculatorControllerConfig calculatorControllerConfig = new DefaultCalculatorControllerConfig(
				writerConfig,
				inputHandlerConfig,
				outputHandlerConfig
		);
		this.calculatorController = calculatorControllerConfig.getCalculatorController();
	}
	
	public void run() {
		calculatorController.run();
	}
}
