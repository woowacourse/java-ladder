package utils;

public enum ErrorMessage {

    DIGIT_ERROR("자연수만 입력 가능합니다."),
    HEIGHT_ERROR("사다리 높이는 1이상 100이하의 자연수만 가능합니다."),
    NAME_LENGTH_ERROR("참가자 이름의 길이는 1이상 5이하만 가능합니다."),
    NAME_FORMAT_ERROR("참가자 이름에는 공백이 들어갈 수 없습니다."),
    PLAYER_SIZE_ERROR("게임 참여자 수는 최소 2명 최대 50명까지 가능합니다."),
    PLAYER_DUPLICATE_ERROR("게임 참여자의 이름은 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
