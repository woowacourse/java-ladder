package ladder.domain;

class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = "";
    private static final String LENGTH_OVER_EXCEPTION_MASSAGE_FORMAT = "%s 의 길이가 너무 깁니다.";
    private static final String BLANK_PLAYER_EXCEPTION_MESSAGE = "플레이어의 이름으로 공백을 넣을 수 없습니다.";

    private final String name;

    Player(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        checkBlank(name);
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(LENGTH_OVER_EXCEPTION_MASSAGE_FORMAT, name));
        }
    }

    private void checkBlank(String name) {
        if (name.equals(BLANK)) {
            throw new IllegalArgumentException(BLANK_PLAYER_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
