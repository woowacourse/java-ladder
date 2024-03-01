package view;

import java.util.List;
import java.util.Scanner;
import util.StringConvertor;
import view.message.InputExceptionMessage;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요)", StringConvertor.DELIMITER));
        String playerNamesInput = scanner.nextLine();
        validatePlayerNamesInput(playerNamesInput);
        return StringConvertor.convertToTrimmedList(StringConvertor.splitByComma(playerNamesInput));
    }

    private void validatePlayerNamesInput(final String playerNamesInput) {
        if (!playerNamesInput.contains(StringConvertor.DELIMITER)) {
            throw new IllegalArgumentException(InputExceptionMessage.PLAYER_NAMES_INPUT_FORMAT);
        }
    }

    public int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = scanner.nextLine();
        validateIntegerFormat(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private void validateIntegerFormat(final String value) {
        try {
            StringConvertor.convertToInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(InputExceptionMessage.INTEGER_FORMAT);
        }
    }

    public List<String> readLadderResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String ladderResults = scanner.nextLine();
        validateLadderResultInput(ladderResults);
        return StringConvertor.convertToTrimmedList(StringConvertor.splitByComma(ladderResults));
    }

    private void validateLadderResultInput(final String ladderResult) {
        if (!ladderResult.contains(StringConvertor.DELIMITER)) {
            throw new IllegalArgumentException(InputExceptionMessage.LADDER_RESULT_INPUT_FORMAT);
        }
    }

    public String readPlayerToSeeResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
