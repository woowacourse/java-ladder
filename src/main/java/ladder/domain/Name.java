package ladder.domain;

public class Name extends Target {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(String value) {
        super(value);
        validateLength();
        if (ALL.equals(value)) {
            throw new IllegalArgumentException("이름은 all일 수 없습니다");
        }
    }

    private void validateLength() {
        int nameLength = value.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 공백을 제외한 최소 1글자 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    public int getLength() {
        return value.length();
    }
}
