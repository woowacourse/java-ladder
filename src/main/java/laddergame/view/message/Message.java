package laddergame.view.message;

public enum Message {
    INPUT_PARTICIPANT_NAMES_GUIDE("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_LADDER_MAX_HEIGHT_GUIDE("\n최대 사다리 높이는 몇 개인가요?"),
    RESULT_GUIDE("\n실행결과\n");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
