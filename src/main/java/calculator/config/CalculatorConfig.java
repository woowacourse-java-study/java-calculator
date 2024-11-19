package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorService calculatorService = new CalculatorService();
    private final CalculatorController calculatorController;

    public CalculatorConfig() {
        this.calculatorController = new CalculatorController(inputView, outputView, calculatorService);
    }

    public CalculatorController getCalculatorController() {
        return calculatorController;
    }
}
