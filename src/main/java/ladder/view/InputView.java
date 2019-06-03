package ladder.view;

import ladder.model.validator.InputValidator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String GET_MEMBER_RESULT_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String COMMA = ",";

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputNames() {
        String inputText = "";
        do {
            System.out.println(NAME_INPUT_MESSAGE);
            inputText = scanner.nextLine().trim();
        } while (!InputValidator.validSeparator(inputText) ||
                !InputValidator.validDuplicateName(inputText));
        return refineNames(inputText);
    }

    public static String[] inputResults(int countOfMember) {
        String inputText = "";
        String[] inputs = new String[0];
        do {
            System.out.println(RESULT_INPUT_MESSAGE);
            inputText = scanner.nextLine().trim();
            inputs = inputText.split(COMMA);
        } while (!InputValidator.validSeparator(inputText) || InputValidator.validMemberCount(inputs.length, countOfMember));
        return inputs;
    }

    private static String[] refineNames(final String inputText) {
        return inputText.split(COMMA);
    }

    public static int inputLadderHeight() {
        int height = 0;
        do {
            System.out.println(HEIGHT_INPUT_MESSAGE);
            height = Integer.parseInt(scanner.nextLine());
        } while (InputValidator.validHeight(height));
        return height;
    }

    public static String inputGetMemberResult(List<String> memberNames) {
        String name = "";
        do {
            System.out.println(GET_MEMBER_RESULT_INPUT_MESSAGE);
            name = scanner.nextLine();
        } while (!InputValidator.validResultsName(memberNames, name));
        return name;
    }
}
