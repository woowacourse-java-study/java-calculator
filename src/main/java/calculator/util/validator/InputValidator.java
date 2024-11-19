package calculator.util.validator;

import static calculator.common.constant.Constants.DELIMITER_PATTERN;
import static calculator.common.constant.message.ErrorMessages.INVALID_INPUT_FORMAT;
import static calculator.common.constant.message.ErrorMessages.INVALID_INPUT_NULL;

import java.util.regex.Pattern;

public class InputValidator implements ValidatorStrategy<String> {

    @Override
    public void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_INPUT_NULL);
        }
        if (!isValidInput(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private boolean isValidInput(String input) {
        return Pattern.matches(DELIMITER_PATTERN, input);
    }
}
