package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
    private static final String EXCEPTION_NAME_PATTERN = "[ERROR] 이름은 알파벳 대소문자로만 구성 가능합니다.";

    private final String name;

    public Name(String name){
        validateNameLength(name);
        validateNameHasOnlyCharacters(name);
        this.name = name;
    }

    private void validateNameLength(String name){
        if(name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameHasOnlyCharacters(String name) {
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(EXCEPTION_NAME_PATTERN);
        }
    }

    public String getName(){
        return this.name;
    }

}
