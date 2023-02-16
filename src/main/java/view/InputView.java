package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    static Scanner sc = new Scanner(System.in);

    public List<String> inputUserName() {
        System.out.println(INPUT_USER_NAME);
        return splitNameInput(sc.next());
    }

    private List<String> splitNameInput(String nameInput) {
        return List.of(nameInput.split(","));
    }

    public String inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return sc.next();
    }
}
