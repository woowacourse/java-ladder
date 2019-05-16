package laddergame.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다!";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputMembers() {
        try {
            System.out.println(INPUT_MEMBERS);
            return Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println(ERROR_MESSAGE);
            return inputMembers();
        }
    }

    public static int inputHeight() {
        try {
            System.out.println(INPUT_HEIGHT);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.err.println(ERROR_MESSAGE);
            return inputHeight();
        }

    }

}
