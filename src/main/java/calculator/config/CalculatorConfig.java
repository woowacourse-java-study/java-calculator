package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.util.parser.NumberParser;
import calculator.util.validator.DelimiterValidator;
import calculator.util.validator.InputValidator;
import calculator.util.validator.NumberValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorConfig {

    private final CalculatorController calculatorController;

    public CalculatorConfig() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        DelimiterValidator delimiterValidator = new DelimiterValidator();
        NumberValidator numberValidator = new NumberValidator();
        NumberParser numberParser = new NumberParser(delimiterValidator, numberValidator);
        CalculatorService calculatorService = new CalculatorService(inputValidator, numberParser);
        this.calculatorController = new CalculatorController(inputView, outputView, calculatorService);
    }

    public void run() {
        calculatorController.run();
    }
}
