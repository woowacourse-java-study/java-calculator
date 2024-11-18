package calculator.domain;

import calculator.exception.CustomExceptions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class Separators {
	
	private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
	
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
	
	public List<String> separate(StringCalculatorValue value) {
		String numberPart = value.getNumberPart();
		String separatorRegex = createSeparatorRegex();
		String[] numbers = numberPart.split(separatorRegex);
		validateOnlyNumberStrings(numbers);
		return Arrays.asList(numbers);
	}
	
	private void validateOnlyNumberStrings(String[] numbers) {
		for (String number : numbers) {
			validateIsNumberString(number);
		}
	}
	
	private static void validateIsNumberString(String number) {
		if (!NUMBER_PATTERN.matcher(number).matches()) {
			throw CustomExceptions.UNDEFIENDED_SEPARATOR.get();
		}
	}
	
	private String createSeparatorRegex() {
		List<String> separatorValues = separators.stream()
				.map(Separator::getStringValue)
				.toList();
		return "[" + String.join("|", separatorValues) + "]";
	}
}
