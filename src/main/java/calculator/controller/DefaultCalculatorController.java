package calculator.controller;

import calculator.domain.*;
import calculator.io.input.InputHandler;
import calculator.io.output.OutputHandler;

import java.util.List;

public class DefaultCalculatorController implements CalculatorController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	
	public DefaultCalculatorController(InputHandler inputHandler, OutputHandler outputHandler) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
	}
	
	@Override
	public void run() {
		outputHandler.handleStart();
		String stringToAdd = inputHandler.getStringToAdd();
		StringCalculatorValue value = StringCalculatorValue.from(stringToAdd);
		DefaultSeparatorFactory defaultSeparatorFactory = new DefaultSeparatorFactory();
		CustomSeparatorFactory customSeparatorFactory = CustomSeparatorFactory.from(value);
		Separators separators = Separators.from(List.of(defaultSeparatorFactory, customSeparatorFactory));
		List<Integer> numbers = separators.separate(value);
		NumberCalculator numberCalculator = new NumberCalculator(numbers);
		long result = numberCalculator.caculate();
		outputHandler.handleResult(result);
	}
}
