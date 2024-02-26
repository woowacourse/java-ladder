package domain;

public class Result {

    private static final int MIN_RESULT = 1;
    private static final int MAX_RESULT = 99999;

    private final String name;

    private Result(String name) {
        validate(name);
        this.name = name;
    }

    public static Result from(String rawName) {
        validateNull(rawName);
        return new Result(rawName);
    }

    private void validate(String name) {
        if (!name.equals("꽝")) {
            validateNumeric(name);
            validateRange(name);
        }
    }

    private void validateNumeric(String name) {
        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 혹은 '꽝'만 입력 가능합니다.");
        }
    }

    private void validateRange(String name) {
        int result = Integer.parseInt(name);
        if (result < MIN_RESULT || result > MAX_RESULT) {
            throw new IllegalArgumentException(
                MIN_RESULT + " 이상 " + MAX_RESULT + " 이하의 숫자만 입력 가능합니다.");
        }
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
