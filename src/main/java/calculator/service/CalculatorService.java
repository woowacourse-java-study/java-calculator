package calculator.service;

import java.util.List;

public class CalculatorService {
    public static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
