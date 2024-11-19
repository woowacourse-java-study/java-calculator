package calculator.common.constant;

public class Constants {

    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String PIPE = "|";
    public static final String DEFAULT_DELIMITERS = String.join(PIPE, COMMA, COLON);
    public static final String DELIMITER_PATTERN = "^(//.*\\n)?[0-9,:]*$";

    public static final String CUSTOM_DELIMITER_PATTERN = "^//(.+)\n(.*)";
}
