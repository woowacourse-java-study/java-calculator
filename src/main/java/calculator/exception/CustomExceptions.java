package calculator.exception;

public enum CustomExceptions {
	
	ILLEGAL_ARGUMENT(
			"잘못된 입력입니다.",
			IllegalArgumentException.class
	),
	NEGATIVE_VALUE(
			"음수는_포함될_수_없습니다",
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
