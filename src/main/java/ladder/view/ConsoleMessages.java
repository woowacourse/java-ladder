package ladder.view;

public enum ConsoleMessages {
    INPUT_NAME("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
    OUTPUT_LADDER("사다리 결과");

    private String message;

    private ConsoleMessages(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
