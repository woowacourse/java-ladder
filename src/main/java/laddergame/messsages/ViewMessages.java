package laddergame.messsages;

public enum ViewMessages {
    ANNOUNCE_READ_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    ANNOUNCE_READ_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
    ANNOUNCE_RESULT("실행결과");
    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
