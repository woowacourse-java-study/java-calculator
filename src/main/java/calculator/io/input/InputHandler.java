package calculator.io.input;

import calculator.io.reader.Reader;

public class InputHandler {
	
	private final Reader reader;
	
	public InputHandler(Reader reader) {
		this.reader = reader;
	}
	
	public String getStringToAdd() {
		// TODO : IO 영역 추가 예외처리 추가 필요
		return reader.readLine();
	}
}
