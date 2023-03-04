package view;

import java.util.List;

import constant.Command;
import utils.ScannerUtil;

public class InputView {

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = ScannerUtil.nextLine();
        List<String> names = splitWithComma(input);
        validateNotCommand(names);
        return names;
    }

    public static int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtil.nextInt();
    }

    public static List<String> inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = ScannerUtil.nextLine();
        return splitWithComma(input);
    }

    public static SearchTarget inputSearchTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        return new SearchTarget(ScannerUtil.nextLine());
    }

    private static void validateNotCommand(List<String> names) {
        for (String name : names) {
            validateNotCommand(name);
        }
    }

    private static void validateNotCommand(String name) {
        if (Command.isCommand(name)) {
            throw new IllegalArgumentException("명령어는 이름으로 사용할 수 없습니다");
        }
    }

    private static List<String> splitWithComma(final String input) {
        return List.of(input.split(","));
    }
}
