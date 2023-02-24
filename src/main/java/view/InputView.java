package view;

import common.exception.handler.IllegalArgumentExceptionHandler;
import utils.ScannerUtil;

import java.util.List;

public class InputView {

    private static final String INPUT_DELIM = ",";

    public static List<String> inputName() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String input = ScannerUtil.nextLine();

            return split(input);
        });
    }

    public static List<String> inputResultCandidates() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String input = ScannerUtil.nextLine();

            return split(input);
        });
    }

    public static int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(ScannerUtil.nextLine());
    }

    public static String inputShowResultPerson() {
        System.out.println("결과를 보고 싶은 사람은?");
        return ScannerUtil.nextLine();
    }

    private static List<String> split(final String input) {
        return List.of(input.split(INPUT_DELIM));
    }
}
