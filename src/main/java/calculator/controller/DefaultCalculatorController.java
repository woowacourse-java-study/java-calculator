package calculator.controller;

import calculator.domain.StringCalculatorValue;
import calculator.io.input.InputHandler;
import calculator.io.output.OutputHandler;
import calculator.service.CalculatorService;
import calculator.service.SeparatorService;

import java.util.List;

public class DefaultCalculatorController implements CalculatorController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final SeparatorService separatorService;
	private final CalculatorService calculatorService;
	
	public DefaultCalculatorController(InputHandler inputHandler, OutputHandler outputHandler, SeparatorService separatorService, CalculatorService calculatorService) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.separatorService = separatorService;
		this.calculatorService = calculatorService;
	}
	
	@Override
	public void run() {
		outputHandler.handleStart();
		String input = inputHandler.getStringToAdd();
		StringCalculatorValue value = StringCalculatorValue.from(input);
		List<String> numbers = separatorService.separate(value);
		String result = calculatorService.calculate(numbers);
		outputHandler.handleResult(result);
	}
}
