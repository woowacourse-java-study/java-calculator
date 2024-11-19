package calculator.util.parser;

import static calculator.common.constant.Constants.CUSTOM_DELIMITER_PATTERN;
import static calculator.common.constant.Constants.DEFAULT_DELIMITERS;
import static calculator.common.constant.Constants.EMPTY;
import static calculator.common.constant.Constants.PIPE;

import calculator.util.validator.DelimiterValidator;
import calculator.util.validator.NumberValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final DelimiterValidator delimiterValidator;
    private final NumberValidator numberValidator;

    private static String delimiters = DEFAULT_DELIMITERS;

    public NumberParser(DelimiterValidator delimiterValidator, NumberValidator numberValidator) {
        this.delimiterValidator = delimiterValidator;
        this.numberValidator = numberValidator;
    }

    public List<Integer> parse(String input) {
        List<String> tokens = splitTokens(input);
        return toNumbers(tokens);
    }

    private List<String> splitTokens(String input) {
        if (hasCustomDelimiter(input)) {
            return customTokens(input);
        }
        return defaultTokens(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private List<String> customTokens(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        addDelimiter(matcher.group(1));
        return splitByDelimiter(matcher.group(2));
    }

    private void addDelimiter(String customDelimiter) {
        for (String delimiter : customDelimiter.split(EMPTY)) {
            delimiterValidator.validate(delimiter);
            delimiters = String.join(PIPE, delimiters, delimiter);
        }
    }

    private List<String> defaultTokens(String input) {
        return splitByDelimiter(input);
    }

    private List<String> splitByDelimiter(String input) {
        List<String> tokens = new ArrayList<>();
        for (String token : input.split(delimiters)) {
            tokens.add(token);
        }
        return tokens;
    }

    private List<Integer> toNumbers(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numberValidator.validate(token);
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }
}

