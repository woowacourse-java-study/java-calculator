package calculator.exception;

public enum CustomExceptions {
	
	ILLEGAL_ARGUMENT(
			"잘못된 입력입니다.",
			IllegalArgumentException.class
	),
	UNDEFIENDED_SEPARATOR(
			"지정되지 않은 구분자가 존재합니다.",
			IllegalArgumentException.class
	),
	SEPARATOR_CONTINUE(
			"구분자는 연속될 수 없습니다.",
			IllegalArgumentException.class
	),
	DIGIT_CUSTOM_SEPARATOR(
			"숫자는 커스텀 구분자가 될 수 없습니다.",
			IllegalArgumentException.class
	),
	NOT_START_WITH_NUMBER(
			"숫자로 시작되어야 합니다.",
			IllegalArgumentException.class
	),
	NOT_END_WITH_NUMBER(
			"숫자로 끝나야 합니다.",
			IllegalArgumentException.class
	),
	NEGATIVE_VALUE(
			"음수는 포함될 수 없습니다",
			IllegalArgumentException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get() {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message);
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
