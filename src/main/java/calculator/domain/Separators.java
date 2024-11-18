package calculator.domain;

import calculator.exception.CustomExceptions;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Separators {
	
	private final List<Separator> separators;
	
	private Separators(List<Separator> separators) {
		this.separators = separators;
	}
	
	public static Separators from(List<SeparatorFactory> separatorFactories) {
		List<Separator> separators = mapToSeparators(separatorFactories);
		return new Separators(separators);
	}
	
	private static List<Separator> mapToSeparators(List<SeparatorFactory> separatorFactories) {
		return separatorFactories.stream()
				.map(SeparatorFactory::create)
				.flatMap(Collection::stream)
				.toList();
	}
	
	public List<BigDecimal> separate(StringCalculatorValue value) {
		String numberPart = value.getNumberPart();
		String separatorRegex = createSeparatorRegex();
		String[] results = numberPart.split(separatorRegex);
		validate(results);
		return Arrays.stream(results)
				.map(BigDecimal::new)
				.toList();
	}
	
	private static void validate(String[] results) {
		for (String result : results) {
			validateIsDigit(result);
			validateIsPositive(result);
		}
	}
	
	private static void validateIsDigit(String result) {
		for (char ch : result.toCharArray()) {
			if (!Character.isDigit(ch)) {
				throw CustomExceptions.UNDEFIENDED_SEPARATOR.get();
			}
		}
	}
	
	private static void validateIsPositive(String result) {
		if (result.charAt(0) == '-') {
			throw CustomExceptions.NEGATIVE_VALUE.get();
		}
	}
	
	private String createSeparatorRegex() {
		List<String> separatorValues = separators.stream()
				.map(Separator::getStringValue)
				.toList();
		return "[" + String.join("|", separatorValues) + "]";
	}
}
