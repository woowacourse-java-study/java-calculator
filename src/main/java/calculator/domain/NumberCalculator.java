package calculator.domain;

import java.math.BigDecimal;
import java.util.List;

public class NumberCalculator {
	
	private final List<BigDecimal> numbers;
	
	public NumberCalculator(List<BigDecimal> numbers) {
		this.numbers = numbers;
	}
	
	public String caculate() {
		return numbers.stream()
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO)
				.toString();
	}
}
