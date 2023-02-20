package laddergame.view.message;

public enum Message {
    INPUT_PARTICIPANT_NAMES_GUIDE("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 분하세요)", "%s"),
    INPUT_LADDER_MAX_HEIGHT_GUIDE("최대 사다리 높이는 몇 개인가요?", "%n%s"),
    RESULT_GUIDE("실행결과", "%n%s%n");

    private final String message;
    private final String format;

    Message(final String message, final String format) {
        this.message = message;
        this.format = format;
    }

    public String getFormattedMessage() {
        return String.format(format, message);
    }
}
