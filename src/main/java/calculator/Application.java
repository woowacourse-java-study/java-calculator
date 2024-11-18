package calculator;

import calculator.controller.DefaultCalculatorController;
import calculator.io.input.InputHandler;
import calculator.io.input.InputParser;
import calculator.io.input.InputValidator;
import calculator.io.output.OutputHandler;
import calculator.io.reader.MissionUtilsReader;
import calculator.io.writer.SystemWriter;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new MissionUtilsReader(), new InputValidator(), new InputParser());
        OutputHandler outputHandler = new OutputHandler(new SystemWriter());
        DefaultCalculatorController defaultCalculatorController = new DefaultCalculatorController(inputHandler, outputHandler);
        defaultCalculatorController.run();
    }
}
