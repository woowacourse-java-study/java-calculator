package calculator.config.controller;

import calculator.config.inputHandler.InputHandlerConfig;
import calculator.config.outputHandler.OutputHandlerConfig;
import calculator.config.writer.WriterConfig;
import calculator.controller.CalculatorController;
import calculator.controller.CalculatorControllerExceptionHandleProxy;
import calculator.controller.DefaultCalculatorController;
import calculator.exception.ExceptionHandler;
import calculator.service.CalculatorService;
import calculator.service.SeparatorService;

public class DefaultCalculatorControllerConfig implements CalculatorControllerConfig {
	
	private final CalculatorController calculatorController;
	
	public DefaultCalculatorControllerConfig(
			WriterConfig writerConfig,
			InputHandlerConfig inputHandlerConfig,
			OutputHandlerConfig outputHandlerConfig
	) {
		CalculatorController defaultCalculatorController = new DefaultCalculatorController(
				inputHandlerConfig.getInputHandler(),
				outputHandlerConfig.getOutputHandler(),
				new SeparatorService(),
				new CalculatorService()
		);
		this.calculatorController = new CalculatorControllerExceptionHandleProxy(
				defaultCalculatorController,
				new ExceptionHandler(writerConfig.getWriter())
		);
	}
	
	@Override
	public CalculatorController getCalculatorController() {
		return calculatorController;
	}
}
