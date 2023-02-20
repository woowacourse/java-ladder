package ladder.domain;

/**
 * name의 null check의 경우 Name생성자를 호출하는 Names 클래스에 구현되어 있기 때문에 생략하였습니다.
 */
class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isOverLength(name)) {
            throw new IllegalArgumentException(String.format("글자수가 %d글자를 초과했습니다", MAX_NAME_LENGTH));
        }
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름이 빈 문자열이 될 수 없습니다");
        }
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isOverLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    String toDto() {
        return name;
    }
}
