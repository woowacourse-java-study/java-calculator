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
        int result = calculate(input);
        result(result);
    }

    public String input() {
        outputView.printInputPrompt();
        return inputView.getInput();
    }

    private int calculate(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        return calculatorService.calculator(input);
    }

    private void result(int result) {
        outputView.printResult(result);
    }
}
