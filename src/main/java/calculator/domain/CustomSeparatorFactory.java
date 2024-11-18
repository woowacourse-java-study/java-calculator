package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;

public class CustomSeparatorFactory implements SeparatorFactory {
	
	private static final Pattern CUSTOM_SEPARATOR_FORMAT = Pattern.compile("^//(\\D*)\\\\n");
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
		return CUSTOM_SEPARATOR_FORMAT.matcher(input).matches();
	}
	
	private static List<Character> extractCustomSeparatorValues(String input) {
		String customSeparatorPart = CUSTOM_SEPARATOR_FORMAT.matcher(input).group(1);
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
