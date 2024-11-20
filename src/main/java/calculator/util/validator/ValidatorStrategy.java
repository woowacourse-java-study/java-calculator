package calculator.util.validator;

public interface ValidatorStrategy <T>{
    void validate(T value);
}
