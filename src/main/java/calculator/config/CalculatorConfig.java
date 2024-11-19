package calculator.config;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorController calculatorController;

    public CalculatorConfig() {
        this.calculatorController = calculatorController(inputView, outputView);
    }

    public CalculatorController getCalculatorController() {
        return calculatorController;
    }
}
