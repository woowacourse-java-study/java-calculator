package calculator.domain;

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
	
	public List<Integer> separate(StringCalculatorValue value) {
		String numberPart = value.getNumberPart();
		String separatorRegex = createSeparatorRegex();
		System.out.println(separatorRegex);
		String[] result = numberPart.split(separatorRegex);
		for (String s : result) {
			System.out.println(s);
		}
		return Arrays.stream(result)
				.map(Integer::valueOf)
				.toList();
	}
	
	private String createSeparatorRegex() {
		List<String> separatorValues = separators.stream()
				.map(Separator::getStringValue)
				.toList();
		return "[" + String.join("|", separatorValues) + "]";
	}
}
