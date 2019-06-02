package ladder.input;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(StringUtils.split(scanner.nextLine(), ","));
    }

    public static int inputLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("숫자를 입력해주세요.");
            return inputLadderHeight();
        }
    }

    public static List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.asList(StringUtils.split(scanner.nextLine(), ","));
    }

    public static String inputParticipant() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
