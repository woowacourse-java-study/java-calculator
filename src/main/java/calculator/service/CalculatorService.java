package calculator.service;

import calculator.util.parser.NumberParser;
import calculator.util.validator.InputValidator;
import java.util.List;

public class CalculatorService {
    private final InputValidator inputValidator;
    private final NumberParser numberParser;

    public CalculatorService(InputValidator inputValidator, NumberParser numberParser) {
        this.inputValidator = inputValidator;
        this.numberParser = numberParser;
    }

    public int calculator(String input) {
        validate(input);
        List<Integer> numbers = parse(input);
        return sum(numbers);
    }

    private void validate(String input) {
        inputValidator.validate(input);
    }

    private List<Integer> parse(String input) {
        return numberParser.parse(input);
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
