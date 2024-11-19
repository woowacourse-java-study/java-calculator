package calculator.io.input;

import calculator.exception.CustomExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
	
	private static final Pattern CUSTOM_SEPARATOR_INPUT_PATTERN = Pattern.compile("^//(.*)\\\\n(.*)$");
	
	public void validateStringToAdd(String input) {
		Matcher matcher = CUSTOM_SEPARATOR_INPUT_PATTERN.matcher(input);
		if (!matcher.matches()) {
			validateNumberPart(input);
		} else {
			validateNumberPart(matcher.group(2));
		}
	}
	
	private static void validateNumberPart(String input) {
		if (input.isBlank()) return;
		validateStartAndEndIsNumber(input);
		boolean isNumber = true;
		for (char ch : input.toCharArray()) {
			if (!Character.isDigit(ch) && !isNumber) {
				throw CustomExceptions.SEPARATOR_CONTINUE.get();
			}
			isNumber = Character.isDigit(ch);
		}
	}
	
	private static void validateStartAndEndIsNumber(String input) {
		if (!Character.isDigit(input.charAt(0))) {
			throw CustomExceptions.NOT_START_WITH_NUMBER.get();
		}
		if (!Character.isDigit(input.charAt(input.length() - 1))) {
			throw CustomExceptions.NOT_END_WITH_NUMBER.get();
		}
	}
}
