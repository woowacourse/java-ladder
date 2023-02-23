package ui.input;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PEOPLES_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static List<String> inputPersonName() {
        System.out.println(INPUT_PEOPLES_NAME);
        while (true) {
            try {
                return InputVerifier.validateName(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputLadderHeight() {
        System.out.println("\n" + INPUT_LADDER_HEIGHT);
        while (true) {
            try {
                return InputVerifier.validateLadderHeight(scanner.nextLine());
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("사다리 높이는 자연수로 입력해 주세요");
            }
        }
    }

}
