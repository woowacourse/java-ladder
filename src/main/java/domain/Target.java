package domain;

public class Target {
    private static final int MAX_NAME_LENGTH = 5;
    private final String target;

    public Target(String target) {
        validate(target);
        this.target = target;
    }

    private void validate(String result) {
        if ((result.isBlank() || result.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("실행 결과는 1~%d자 이내로 입력해야합니다.".formatted(MAX_NAME_LENGTH));
        }
    }

    public String getTarget() {
        return target;
    }
}
