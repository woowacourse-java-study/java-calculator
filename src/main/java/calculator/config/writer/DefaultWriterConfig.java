package calculator.config.writer;

import calculator.io.writer.SystemWriter;
import calculator.io.writer.Writer;

public class DefaultWriterConfig implements WriterConfig {
	
	private final Writer writer;
	
	public DefaultWriterConfig() {
		this.writer = new SystemWriter();
	}
	
	@Override
	public Writer getWriter() {
		return writer;
	}
}
