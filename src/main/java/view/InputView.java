package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String REQUEST_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_LADDER_PRIZE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String REQUEST_SHOWING_NAME = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public List<String> requestNames() {
        System.out.println(REQUEST_NAME);
        String inputNames = scanner.nextLine();
        return Arrays.stream(inputNames.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public List<String> requestPrize() {
        System.out.println(System.lineSeparator() + REQUEST_LADDER_PRIZE);
        String inputPrizes = scanner.nextLine();
        return Arrays.stream(inputPrizes.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public String requestHeight() {
        System.out.println(System.lineSeparator() + REQUEST_LADDER_HEIGHT);
        return scanner.nextLine();
    }

    public String requestShowingName() {
        System.out.println(System.lineSeparator() + REQUEST_SHOWING_NAME);
        return scanner.nextLine();
    }
}
