package domain;

import view.InputView;

final class PlayerName {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 1이상 5글자 이하입니다.";
    private static final String NAME_BLANK_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 빈칸이면 안됩니다.";

    private InputView inputView;
    private final String name;

    public PlayerName(String name) {
        this.name = validateName(name);
    }

    /*TODO: busy-waiting 기법으로 짜자니 코드가 더러워지는 것 같고,
       recursion을 적용하자니 사용자가 무한히 잘못된 값을 입력했을 때 stackOverFlow 발생이 걱정됩니다.
       리뷰어님의 생각이 궁금해요! (일단은 recursion으로 구현했습니다)
    */
    private String validateName(String name) {
        validateNameIsBlank(name);
        validateNameLength(name);

        return name;
    }

    private void validateNameIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (isLengthError(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isLengthError(String name) {
        return name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH;
    }

    public String getName() {
        return name;
    }
}
