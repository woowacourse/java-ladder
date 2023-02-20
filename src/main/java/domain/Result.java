package domain;

public class Result {
    public static final int MAX_LENGTH_OF_RESULT = 5;
    private final String value;

    public Result(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        if (value.isEmpty() || value.length() > MAX_LENGTH_OF_RESULT) {
            throw new IllegalArgumentException("결과의 길이는 1자 이상, 5자 이하 입니다.");
        }
    }
 }
