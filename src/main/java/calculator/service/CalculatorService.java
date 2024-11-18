package calculator.service;

import calculator.domain.NumberCalculator;

import java.math.BigDecimal;
import java.util.List;

public class CalculatorService {
	
	public String calculate(List<BigDecimal> numbers) {
		NumberCalculator numberCalculator = new NumberCalculator(numbers);
		return numberCalculator.caculate();
	}
}
