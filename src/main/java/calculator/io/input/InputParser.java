package calculator.io.input;

public class InputParser {
	
	public String parseStringToAdd(String input) {
		String noBlankInput = input.replaceAll("\\s", "");
		if (noBlankInput.isEmpty()) return "0";
		return noBlankInput;
	}
}
