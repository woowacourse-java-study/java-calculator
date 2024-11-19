package calculator.util.validator;

import static calculator.common.constant.message.ErrorMessages.INVALID_CONTAIN_NUMBER;

public class DelimiterValidator implements ValidatorStrategy<String> {
    @Override
    public void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY);
        }
        if (value.matches(".*\\d.*")) {
            throw new IllegalArgumentException(INVALID_CONTAIN_NUMBER);
        }
    }




}
