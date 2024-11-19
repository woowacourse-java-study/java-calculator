package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = input();
        List<Integer> numbers = parser(input);
        int result = calculate(numbers);
        result(result);
    }

    private void result(int result) {
        outputView.printResult(result);
    }

    private int calculate(List<Integer> numbers) {
        return 0;
    }

    private List<Integer> parser(String input) {
    }

    public String input() {
        outputView.printInputPrompt();
        return inputView.getInput();
    }
}
