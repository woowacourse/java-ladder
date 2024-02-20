package domain;

import java.util.regex.Pattern;

public class Player {

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameSize(name);
        validateNameLanguage(name);
    }

    private void validateNameLanguage(String name) {
        if(!name.matches("^[A-Za-z]*$")){
            throw new IllegalArgumentException("[Error] 플레이어 이름은 영어여야 합니다.");
        }
    }

    private void validateNameSize(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("[Error] 플레이어 이름은 5자 이하여야 합니다.");
        }
    }
}
