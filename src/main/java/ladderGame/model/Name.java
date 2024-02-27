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

    public Name(String name, Players players) {
        if(!name.equals("all")) {
            validate(new Name(name), players);
        }

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

    private void validate(Name name, Players players) {
        if(!players.contains(name)) {
            throw new IllegalArgumentException("참여자 목록 중에서 골라야 합니다.");
        }
    }

    public boolean isAll() {
        return name.equals("all");
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
