package calculator.util.validator;

import static calculator.common.constant.message.ErrorMessages.INVALID_NUMBER;

public class NumberValidator implements ValidatorStrategy<String> {
    @Override
    public void validate(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                throw new NumberFormatException(INVALID_NUMBER);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }
}