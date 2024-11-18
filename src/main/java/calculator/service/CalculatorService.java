package calculator.service;

import calculator.domain.NumberCalculator;

import java.util.List;

public class CalculatorService {
	
	public String calculate(List<String> numbers) {
		NumberCalculator numberCalculator = NumberCalculator.from(numbers);
		return numberCalculator.caculate();
	}
}
