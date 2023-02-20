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

    public static List<String> getPersonName() {
        System.out.println(INPUT_PEOPLES_NAME);
        return InputVerifier.validateName(scanner.next());
    }

    public static int getLadderHeight() {
        System.out.println("\n" + INPUT_LADDER_HEIGHT);
        while (true) {
            try {
                int ladderHeight = inputNaturalNumber();
                validateNaturalNumber(ladderHeight);
                return ladderHeight;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("사다리 높이는 자연수로 입력해 주세요");
            }
        }
    }

    private static void validateNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("사다리 높이는 자연수로 입력해 주세요");
        }
    }

    private static int inputNaturalNumber() {
        scanner.nextLine();
        return Integer.parseInt(scanner.nextLine());
    }
}
