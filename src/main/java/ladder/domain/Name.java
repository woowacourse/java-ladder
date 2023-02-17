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
        validateNull(name);
        validateOverLength(name);
        validateIsBlank(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 null이 되면 안됩니다");
        }
    }

    private void validateOverLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("글자수가 5글자를 초과했습니다");
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름이 빈 문자열이 될 수 없습니다");
        }
    }


    String toDto() {
        return name;
    }
}
