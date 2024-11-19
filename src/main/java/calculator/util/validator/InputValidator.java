package calculator.util.validator;

import static calculator.common.constant.Constants.DELIMITER_PATTERN;
import static calculator.common.constant.message.ErrorMessages.INVALID_EMPTY;
import static calculator.common.constant.message.ErrorMessages.INVALID_INPUT_FORMAT;

import java.util.regex.Pattern;

public class InputValidator implements ValidatorStrategy<String> {

    @Override
    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY);
        }
        if (!isValidInput(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private boolean isValidInput(String input) {
        return Pattern.matches(DELIMITER_PATTERN, input);
    }
}
