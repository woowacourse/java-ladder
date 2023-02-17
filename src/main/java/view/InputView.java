package view;

import common.exception.handler.IllegalArgumentExceptionHandler;
import utils.ScannerUtil;

import java.util.List;

public class InputView {

    public static List<String> inputName() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String input = ScannerUtil.nextLine();

            return splitNames(input);
        });
    }

    public static int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtil.nextInt();
    }

    private static List<String> splitNames(final String input) {
        return List.of(input.split(","));
    }
}
