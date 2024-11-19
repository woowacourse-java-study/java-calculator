package calculator.view;

import static calculator.common.constant.message.ViewMessages.CALCULATOR_RESULT_MESSAGE;
import static calculator.common.constant.message.ViewMessages.INPUT_PROMPT_MESSAGE;

public class OutputView {

    public void printInputPrompt() {
        System.out.println(INPUT_PROMPT_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(CALCULATOR_RESULT_MESSAGE.formatted(result));
    }
}
