package calculator.service;

import calculator.domain.*;

import java.util.ArrayList;
import java.util.List;

public class SeparatorService {
	
	public List<String> separate(StringCalculatorValue value) {
		List<SeparatorFactory> separatorFactories = getSeparatorFactories(value);
		Separators separators = Separators.from(separatorFactories);
		return separators.separate(value);
	}
	
	private List<SeparatorFactory> getSeparatorFactories(StringCalculatorValue value) {
		List<SeparatorFactory> separatorFactories = new ArrayList<>();
		separatorFactories.add(new DefaultSeparatorFactory());
		separatorFactories.add(CustomSeparatorFactory.from(value));
		return separatorFactories;
	}
}
