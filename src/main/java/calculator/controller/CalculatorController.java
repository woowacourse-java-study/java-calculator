package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        String input = input();
        List<Integer> numbers = parse(input);
        int result = calculate(numbers);
        result(result);
    }

    private void result(int result) {
        outputView.printResult(result);
    }

    private int calculate(List<Integer> numbers) {
        return calculatorService.sum(numbers);
    }

    private List<Integer> parse(String input) {
        return null;
    }

    public String input() {
        outputView.printInputPrompt();
        return inputView.getInput();
    }
}
