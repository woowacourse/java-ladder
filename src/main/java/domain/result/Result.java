package domain.result;

public class Result {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Result(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateEmptiness(name);
//        validateLength(name);
    }

    private void validateEmptiness(final String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("결과는 비어있을 수 없습니다");
        }
    }

//    private void validateLength(final String name) {
//        if (name.length() > MAX_LENGTH)
//    }

    @Override
    public String toString() {
        return name;
    }
}
