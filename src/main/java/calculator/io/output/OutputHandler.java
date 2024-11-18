package calculator.io.output;

import calculator.io.writer.Writer;

public class OutputHandler {
	
	private final Writer writer;
	
	public OutputHandler(Writer writer) {
		this.writer = writer;
	}
	
	public void handleStart() {
		writer.write("덧셈할 문자열을 입력해 주세요.\n");
	}
	
	public void handleResult(long result) {
		writer.write("결과 : %d".formatted(result));
	}
}
