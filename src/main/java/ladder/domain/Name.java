package ladder.domain;

class Name {

    private static final String OVER_LENGTH_MESSAGE = "글자수가 5글자를 초과했습니다";
    private static final String BLANK_MESSAGE = "이름이 빈 문자열이 될 수 없습니다";

    private final String name;

    Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        //todo 형식2
        if (isOverLength(name)) {
            throw new IllegalArgumentException(OVER_LENGTH_MESSAGE);
        }
        if (isBlank(name)) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isOverLength(String name) {
        return name.length() >= 6;
    }

    String toDto() {
        return name;
    }
}
