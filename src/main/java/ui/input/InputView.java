package ui.input;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_PEOPLES_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static List<String> getPeoplesName() {
        System.out.println(INPUT_PEOPLES_NAME);
        return InputVerifier.validateName(sc.next());
    }

    public static int getLadderHeight(){
        System.out.println("\n" + INPUT_LADDER_HEIGHT);
        int ladderHeight = sc.nextInt();
        InputVerifier.validateLadderHeight(ladderHeight);
        return ladderHeight;
    }
}
