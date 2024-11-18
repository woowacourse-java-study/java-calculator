package calculator.domain;

import java.util.List;

public class CustomSeparatorFactory implements SeparatorFactory {
	
	private static final String CUSTOM_SEPARATOR_START = "//";
	private static final String CUSTOM_SEPARATOR_END = "\\n";
	
	private final List<Character> customValues;
	
	private CustomSeparatorFactory(List<Character> customValues) {
		this.customValues = customValues;
	}
	
	public static CustomSeparatorFactory from(String input) {
		if (!hasCustomSeparator(input)) {
			return new CustomSeparatorFactory(List.of());
		}
		List<Character> customSeparatorValues = extractCustomSeparatorValues(input);
		return new CustomSeparatorFactory(customSeparatorValues);
	}
	
	private static boolean hasCustomSeparator(String input) {
		return input.startsWith(CUSTOM_SEPARATOR_START) && input.contains(CUSTOM_SEPARATOR_END);
	}
	
	private static List<Character> extractCustomSeparatorValues(String input) {
		int startIndex = input.indexOf(CUSTOM_SEPARATOR_START) + 2;
		int endIndex = input.indexOf(CUSTOM_SEPARATOR_END);
		String customSeparatorPart = input.substring(startIndex, endIndex);
		return customSeparatorPart.chars()
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
