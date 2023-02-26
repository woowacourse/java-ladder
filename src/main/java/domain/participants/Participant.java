package domain.participants;

import controller.LadderGameController;
import exception.NotEnglishAndNumberException;
import exception.ladder.GameEndReservedWordException;
import exception.participants.EmptyNameException;
import exception.participants.InvalidPersonNameException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Participant {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String ONLY_ENGLISH_AND_NUMBER = "^[^0-9a-zA-Z]*$";
    private final String name;
    private final Pattern compile = Pattern.compile(ONLY_ENGLISH_AND_NUMBER);

    public Participant(String name) {
        validateName(name);
        this.name = name.strip();
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (isEmpty(name)) {
            throw new EmptyNameException();
        }
        isInvalidName(name.strip());
    }

    private void isInvalidName(String name) {
        if (isGameEndReservedWord(name)) {
            throw new GameEndReservedWordException();
        }
        if (isInvalidLength(name)) {
            throw new InvalidPersonNameException();
        }
        if (isNotEnglishOrNumber(name)) {
            throw new NotEnglishAndNumberException();
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    private boolean isInvalidLength(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    private boolean isNotEnglishOrNumber(String name) {
        return compile.matcher(name).matches();
    }

    private boolean isGameEndReservedWord(String name) {
        return name.equals(LadderGameController.EXIT_RESERVED_WORD);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
