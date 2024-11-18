package calculator.domain;

import java.util.Objects;

public class Separator {
	
	private final char value;
	
	public Separator(char value) {
		this.value = value;
	}
	
	public String getStringValue() {
		return String.valueOf(value);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Separator separator)) return false;
		return value == separator.value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}
}
