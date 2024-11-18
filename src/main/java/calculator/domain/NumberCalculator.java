package calculator.domain;

import java.util.List;

public class NumberCalculator {
	
	public long caculate(List<Integer> numbers) {
		return numbers.stream()
				.mapToLong(Integer::intValue)
				.sum();
	}
}
