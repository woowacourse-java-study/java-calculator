package calculator.controller;

import calculator.exception.ExceptionHandler;

public class CalculatorControllerExceptionHandleProxy implements CalculatorController {
	
	private final CalculatorController targetCalculatorController;
	private final ExceptionHandler exceptionHandler;
	
	public CalculatorControllerExceptionHandleProxy(CalculatorController targetCalculatorController, ExceptionHandler exceptionHandler) {
		this.targetCalculatorController = targetCalculatorController;
		this.exceptionHandler = exceptionHandler;
	}
	
	@Override
	public void run() {
		try {
			targetCalculatorController.run();
		} catch (RuntimeException e) {
			exceptionHandler.handleException(e);
		}
	}
}
