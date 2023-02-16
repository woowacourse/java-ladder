package ladder.domain;

class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        //todo 형식2
        if (name == null) {
            throw new IllegalArgumentException("이름이 null이 되면 안됩니다");
        }
        if (isOverLength(name)) {
            throw new IllegalArgumentException("글자수가 5글자를 초과했습니다");
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
