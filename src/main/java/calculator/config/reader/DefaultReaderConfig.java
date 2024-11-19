package calculator.config.reader;

import calculator.io.reader.MissionUtilsReader;
import calculator.io.reader.Reader;

public class DefaultReaderConfig implements ReaderConfig {
	
	private final Reader reader;
	
	public DefaultReaderConfig() {
		this.reader = new MissionUtilsReader();
	}
	
	@Override
	public Reader getReader() {
		return reader;
	}
}
