package calculator;

import calculator.controller.CalculatorControllerExceptionHandleProxy;
import calculator.controller.DefaultCalculatorController;
import calculator.exception.ExceptionHandler;
import calculator.io.input.InputHandler;
import calculator.io.input.InputParser;
import calculator.io.input.InputValidator;
import calculator.io.output.OutputHandler;
import calculator.io.reader.MissionUtilsReader;
import calculator.io.writer.SystemWriter;
import calculator.io.writer.Writer;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new MissionUtilsReader(), new InputValidator(), new InputParser());
        Writer writer = new SystemWriter();
        OutputHandler outputHandler = new OutputHandler(writer);
        DefaultCalculatorController defaultCalculatorController = new DefaultCalculatorController(inputHandler, outputHandler);
        CalculatorControllerExceptionHandleProxy calculatorControllerExceptionHandleProxy = new CalculatorControllerExceptionHandleProxy(
                defaultCalculatorController,
                new ExceptionHandler(writer)
        );
        calculatorControllerExceptionHandleProxy.run();
    }
}
