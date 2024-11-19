package calculator.io.reader;

import calculator.exception.CustomExceptions;
import camp.nextstep.edu.missionutils.Console;

public class MissionUtilsReader implements Reader {
	
	@Override
	public String readLine() {
		try {
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			throw CustomExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
}
