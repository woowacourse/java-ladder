package domain;

import static message.ErrorMessage.*;

import java.util.regex.Pattern;
import message.ErrorMessage;

public class Player {

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameBlank(name);
        validateNameLanguage(name);
        validateNameSize(name);
    }

    private void validateNameBlank(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException(NO_PLAYER_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNameLanguage(String name) {
        if(!name.matches("^[A-Za-z]*$")){
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_LANGUAGE_EXCEPTION.getMessage());
        }
    }

    private void validateNameSize(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME_SIZE_EXCEPTION.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
