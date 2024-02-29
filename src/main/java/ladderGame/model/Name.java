package ladderGame.model;

import java.util.regex.Pattern;

public class Name {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final String EXCEPTION_MESSAGE_OVER_THAN_MAXIMUM = "이름은 최대 5글자까지 가능합니다.";
    private static final String EXCEPTION_MESSAGE_UNDEFINED_NAME = "이름은 영문과 숫자로만 입력해야 합니다.";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OVER_THAN_MAXIMUM);
        }
        if(!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_UNDEFINED_NAME);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Name otherName = (Name) object;
        return name.equals(otherName.name);
    }

    public String getName() {
        return name;
    }
}
