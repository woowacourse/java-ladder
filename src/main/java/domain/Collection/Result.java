package domain.Collection;

import java.util.Objects;

public class Result {
    private static final String RESULT_LENGTH_ERROR_MSG = "실행 결과는 1자 이상 5자 이하여야합니다.";
    private final String value;
    
    private Result( String value ) {
        this.validateValueLength(value);
        this.value = value;
    }
    
    private void validateValueLength( String value ) {
        if ( 1 > value.length() || value.length() > 5 ) {
            throw new IllegalArgumentException(RESULT_LENGTH_ERROR_MSG);
        }
    }
    
    public static Result from( String value ) {
        return new Result(value);
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
    
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || this.getClass() != o.getClass() ) return false;
        Result result = (Result) o;
        return this.value.equals(result.value);
    }
}
