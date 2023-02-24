package ladder.domain.player;

class PlayerName {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String LENGTH_ERROR_MESSAGE =
            "이름은 " + MIN_NAME_LENGTH + "이상 " + MAX_NAME_LENGTH + "이하로 입력해주세요. ";
    private static final String RESERVED_WORD = "all";

    private final String name;

    PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNull(name);
        validateLength(name);
        validateIsBlank(name);
        validateReservedWord(name);
    }

    private void validateReservedWord(String name) {
        if (name.equals(RESERVED_WORD)) {
            throw new IllegalArgumentException(RESERVED_WORD + "은 이름으로 사용하실 수 없습니다.");
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로 입력할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE + "현재 이름의 길이는 " + name.length() + " 입니다.");
        }
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE + "현재 이름이 null 입니다.");
        }
    }
}
