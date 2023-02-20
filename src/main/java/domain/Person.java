package domain;

import exception.InvalidPersonNameException;
import util.StringUtil;

public class Person {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isValidLength(name)) {
            throw new InvalidPersonNameException();
        }
    }

    private boolean isValidLength(String name) {
        return StringUtil.isNullOrBlank(name) || name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }
}
