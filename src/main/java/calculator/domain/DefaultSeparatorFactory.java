package calculator.domain;

import java.util.List;

public class DefaultSeparatorFactory implements SeparatorFactory {
	
	private static final List<Character> defaultValues = List.of(':', ',');
	
	@Override
	public List<Separator> create() {
		return defaultValues.stream()
				.map(Separator::new)
				.toList();
	}
}
