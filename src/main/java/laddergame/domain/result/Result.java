package laddergame.domain.result;

import laddergame.domain.Constant;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Result {
    private final String result;

    public Result(String result) {
        if (StringUtils.isBlank(result)) {
            throw new IllegalArgumentException("공백을 입력하였습니다");
        }
        if(result.length() > Constant.BOUND_OF_NAME_LENGTH){
            throw new IllegalArgumentException("5자리 이하 결과만 입력 가능합니다.");
        }
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return this.result;
    }
}
