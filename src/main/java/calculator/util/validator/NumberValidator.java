package calculator.util.validator;

import static calculator.common.constant.message.ErrorMessages.INVALID_NUMBER;

public class NumberValidator implements ValidatorStrategy<String> {
    @Override
    public void validate(String value) {
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }
}