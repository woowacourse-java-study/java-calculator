package calculator.domain;

public class StringCalculatorValue {
	
	private static final String CUSTOM_SEPARATOR_START = "//";
	private static final String CUSTOM_SEPARATOR_END = "\\n";
	
	private final String value;
	private final InputType inputType;
	
	private StringCalculatorValue(String value, InputType inputType) {
		this.value = value;
		this.inputType = inputType;
	}
	
	public static StringCalculatorValue from(String value) {
		if (hasCustomSeparatorPart(value)) {
			return new StringCalculatorValue(value, InputType.WITH_CUSTOM_SEPARATOR);
		}
		return new StringCalculatorValue(value, InputType.NO_CUSTOM_SEPARATOR);
	}
	
	private static boolean hasCustomSeparatorPart(String value) {
		return value.startsWith(CUSTOM_SEPARATOR_START) && value.contains(CUSTOM_SEPARATOR_END);
	}
	
	public String getCustomSeparatorPart() {
		if (!isCustomSeparatorValue()) {
			return "";
		}
		int startIndex = value.indexOf(CUSTOM_SEPARATOR_START) + 2;
		int endIndex = value.indexOf(CUSTOM_SEPARATOR_END);
		return value.substring(startIndex, endIndex);
	}
	
	public String getNumberPart() {
		if (!isCustomSeparatorValue()) {
			return value;
		}
		int startIndex = value.indexOf(CUSTOM_SEPARATOR_END) + 2;
		return value.substring(startIndex);
	}
	
	public boolean isCustomSeparatorValue() {
		return inputType == InputType.WITH_CUSTOM_SEPARATOR;
	}
}
