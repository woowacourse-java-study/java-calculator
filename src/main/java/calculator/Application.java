package calculator;

import calculator.controller.DefaultCalculatorController;
import calculator.io.input.InputHandler;
import calculator.io.output.OutputHandler;
import calculator.io.reader.MissionUtilsReader;
import calculator.io.writer.SystemWriter;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new MissionUtilsReader());
        OutputHandler outputHandler = new OutputHandler(new SystemWriter());
        DefaultCalculatorController defaultCalculatorController = new DefaultCalculatorController(inputHandler, outputHandler);
        defaultCalculatorController.run();
    }
}
