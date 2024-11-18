package calculator.domain;

import java.util.List;

public class CustomSeparatorFactory implements SeparatorFactory {
	
	private final List<Character> customValues;
	
	private CustomSeparatorFactory(List<Character> customValues) {
		this.customValues = customValues;
	}
	
	public static CustomSeparatorFactory from(StringCalculatorValue value) {
		if (!value.isCustomSeparatorValue()) {
			return new CustomSeparatorFactory(List.of());
		}
		List<Character> customSeparatorValues = extractCustomSeparatorValues(value);
		return new CustomSeparatorFactory(customSeparatorValues);
	}
	
	private static List<Character> extractCustomSeparatorValues(StringCalculatorValue value) {
		return value.getCustomSeparatorPart().chars()
				.mapToObj(c -> (char) c)
				.toList();
	}
	
	@Override
	public List<Separator> create() {
		return customValues.stream()
				.map(Separator::new)
				.toList();
	}
}
