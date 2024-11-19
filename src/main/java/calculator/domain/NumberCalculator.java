package calculator.domain;

import calculator.exception.CustomExceptions;

import java.math.BigDecimal;
import java.util.List;

public class NumberCalculator {
	
	private final List<BigDecimal> numbers;
	
	private NumberCalculator(List<BigDecimal> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}
	
	public static NumberCalculator from(List<String> values) {
		List<BigDecimal> numbers = values.stream()
				.map(BigDecimal::new)
				.toList();
		return new NumberCalculator(numbers);
	}
	
	private void validate(List<BigDecimal> numbers) {
		for (BigDecimal number : numbers) {
			if (!number.abs().equals(number)) {
				throw CustomExceptions.NEGATIVE_VALUE.get();
			}
		}
	}
	
	public String caculate() {
		return numbers.stream()
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO)
				.toString();
	}
}
