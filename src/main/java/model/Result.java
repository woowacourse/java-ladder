package model;

import java.util.Objects;

public record Result(String value) {

    public Result {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("실행 결과가 빈 문자열이나 공백이 될 수 없습니다.");
        }
    }
}
