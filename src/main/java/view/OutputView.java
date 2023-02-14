package view;

public class OutputView {

    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public void printPlayerNamesMessage() {
        System.out.println(PLAYER_NAME_MESSAGE);
    }
}
