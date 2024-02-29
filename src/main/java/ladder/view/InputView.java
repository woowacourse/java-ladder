package ladder.view;

import ladder.view.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String input = SCANNER.nextLine();

        inputValidator.validatePlayerNames(input);
        return input;
    }

    public String readPrizes() {
        System.out.println(OutputView.NEWLINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String input = SCANNER.nextLine();

        inputValidator.validateInputBlank(input);
        return input;
    }

    public int readLadderHeight() {
        System.out.println(OutputView.NEWLINE + "최대 사다리 높이는 몇 개인가요?");
        final String input = SCANNER.nextLine();

        inputValidator.validateLadderHeight(input);
        return Integer.parseInt(input);
    }

    public String readNameToSeeResult() {
        System.out.println(OutputView.NEWLINE + "결과를 보고 싶은 사람은?");
        final String input = SCANNER.nextLine();

        inputValidator.validateInputBlank(input);
        return input;
    }
}
