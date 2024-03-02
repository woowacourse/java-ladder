package model.result;

public record Result(String name) {
    public Result(String name) {
        validateResultNullAndBlank(name);
        this.name = name;
    }

    static final String NOT_ALLOWED_NULL_EMPTY_RESULT = "결과의 이름이 없거나 공백으로만 이루어져 있는 경우 결과 생성이 불가합니다.";

    private void validateResultNullAndBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NOT_ALLOWED_NULL_EMPTY_RESULT);
        }
    }
}
