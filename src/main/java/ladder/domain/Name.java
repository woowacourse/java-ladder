package ladder.domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        String name = value.trim();
        validate(name);
        this.value = name;
    }

    private void validate(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "글자를 넘을 수 없습니다.\n" + "Name : " + name);
        }
        if (!name.replace(" ", "").equals(name)) {
            throw new IllegalArgumentException("이름에는 공백이 들어갈 수 없습니다.\n" + "Name : " + name);
        }
    }

    public String getValue() {
        return value;
    }
}
