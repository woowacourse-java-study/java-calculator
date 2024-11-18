package calculator.domain;

import calculator.exception.CustomExceptions;

import java.util.List;

public class NumberCalculator {
	
	private final List<Integer> numbers;
	
	public NumberCalculator(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}
	
	private void validate(List<Integer> numbers) {
		if (containsNegativeValue(numbers)) {
			throw CustomExceptions.NEGATIVE_VALUE.get();
		}
	}
	
	private boolean containsNegativeValue(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (number < 0) return true;
		}
		return false;
	}
	
	public long caculate() {
		return numbers.stream()
				.mapToLong(Integer::intValue)
				.sum();
	}
}
