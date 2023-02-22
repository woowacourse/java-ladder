package domain;

import java.util.regex.Pattern;

public class Player {

    private static final int PLAYER_NAME_MIN_SIZE_INCLUSIVE = 1;
    private static final int PLAYER_NAME_MAX_SIZE_INCLUSIVE = 5;
    private static final String PLAYER_NAME_SIZE_ERROR_MESSAGE = "이름은 1 ~ 5 글자여야 합니다.";
    private static final String VALUE_ERROR_MESSAGE = "이름은 영어나 숫자로만 가능합니다.";
    private static final String VALID_WORD_REGEX = "(\\w)+";
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private final String name;
    private int standingLine;

    public Player(final String name, int standingLine) {
        validate(name);
        this.name = name;
        this.standingLine = standingLine;
    }

    public void validate(String playerName) {
        validatePlayerName(playerName);
        validateWord(playerName);
    }

    private void validatePlayerName(String playerName) {
        if (isOutOfRange(playerName)) {
            throw new IllegalArgumentException(PLAYER_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateWord(String playerName) {
        if (isNotMatches(playerName)) {
            throw new IllegalArgumentException(VALUE_ERROR_MESSAGE);
        }
    }

    private boolean isNotMatches(String playerName) {
        return !PLAYER_NAME_PATTERN.matcher(playerName).matches();
    }

    private boolean isOutOfRange(String playerName) {
        return !(PLAYER_NAME_MIN_SIZE_INCLUSIVE <= playerName.length()
                && playerName.length() <= PLAYER_NAME_MAX_SIZE_INCLUSIVE);
    }

    public void moveLeft() {
        this.standingLine--;
    }

    public void moveRight() {
        this.standingLine++;
    }

    public int getStandingLine() {
        return this.standingLine;
    }

    public String getName() {
        return this.name;
    }

}
