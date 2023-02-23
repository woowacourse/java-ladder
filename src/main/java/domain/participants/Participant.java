package domain.participants;

import exception.NotEnglishAndNumberException;
import exception.participants.EmptyNameException;
import exception.participants.InvalidPersonNameException;
import java.util.regex.Pattern;

public class Participant {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String name;
    private final Pattern compile = Pattern.compile("^[^0-9a-zA-Z]*$");

    public Participant(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new EmptyNameException();
        }
        if (isInvalidLength(name)) {
            throw new InvalidPersonNameException();
        }
        if (isNotEnglishOrNumber(name)) {
            throw new NotEnglishAndNumberException();
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isInvalidLength(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    private boolean isNotEnglishOrNumber(String name) {
        return compile.matcher(name).matches();
    }

    public String getName() {
        return name;
    }
}
