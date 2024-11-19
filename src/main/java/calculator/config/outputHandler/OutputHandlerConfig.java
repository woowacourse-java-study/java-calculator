package calculator.config.outputHandler;

import calculator.config.writer.WriterConfig;
import calculator.io.output.OutputHandler;

public class OutputHandlerConfig {
	
	private final OutputHandler outputHandler;
	
	public OutputHandlerConfig(WriterConfig writerConfig) {
		this.outputHandler = new OutputHandler(
				writerConfig.getWriter()
		);
	}
	
	public OutputHandler getOutputHandler() {
		return outputHandler;
	}
}
