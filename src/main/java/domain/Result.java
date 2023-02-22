package domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final static String RESULT_LENGTH_ERROR_MSG = "실행 결과는 1자 이상 5자 이하여야합니다.";
    private final String value;

    private static final Map<String,Result> cachedResult = new HashMap<>();

    private Result(String value){
        this.value = value;
    }

    public static Result from(String value){
        validateValueLength(value);
        if(!cachedResult.containsKey(value)) {
            cachedResult.put(value, new Result(value));
        }
        return cachedResult.get(value);
    }

    private static void validateValueLength(String value){
        if(1 > value.length() || value.length() > 5){
            throw new IllegalArgumentException(RESULT_LENGTH_ERROR_MSG);
        }
    }

    public String getValue() {
        return value;
    }
}
