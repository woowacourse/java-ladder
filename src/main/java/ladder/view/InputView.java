package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GAME_USER_NAME_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GAME_LADDER_HEIGHT_INPUT_MGS = "최대 사다리 높이는 몇 개인가요?";
    private static final String GAME_PRIZE_INPUT_MGS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NAME_FOR_RESULT_INPUT_MSG = "결과를 보고 싶은 사람은?";


    public static String inputNames() {
        System.out.println(GAME_USER_NAME_INPUT_MSG);
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            return inputNames();
        }
    }

    public static String inputPrize(){
        System.out.println(GAME_PRIZE_INPUT_MGS);
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            return inputPrize();
        }
    }

    public static int inputHeight() {
        System.out.println(GAME_LADDER_HEIGHT_INPUT_MGS);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            return inputHeight();
        }
    }

    public static String inputNameForResult() {
        System.out.println(NAME_FOR_RESULT_INPUT_MSG);
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            return inputNameForResult();
        }
    }
}
