package calculator.util.validator;

import static calculator.common.constant.Constants.CUSTOM_DELIMITER_PATTERN;
import static calculator.common.constant.Constants.DEFAULT_DELIMITER_PATTERN;
import static calculator.common.constant.message.ErrorMessages.INVALID_INPUT_FORMAT;

import java.util.regex.Pattern;

public class InputValidator implements ValidatorStrategy<String> {

    @Override
    public void validate(String input) {
        if (input == null) {
            return;
        }
        if (!isValidInput(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private boolean isValidInput(String input) {
        return isDefaultDelimiter(input) || isCustomDelimiter(input);
    }

    private boolean isDefaultDelimiter(String input) {
        return Pattern.matches(DEFAULT_DELIMITER_PATTERN, input);
    }

    private boolean isCustomDelimiter(String input) {
        return Pattern.matches(CUSTOM_DELIMITER_PATTERN, input);
    }
}
