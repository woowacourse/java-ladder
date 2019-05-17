package laddergame.util;

import laddergame.domain.Tags;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_WANT_RESULT = "결과를 보고 싶은 사람은?";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다!";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputMembers() {
        OutputView.outputMessage(INPUT_MEMBERS);
        try {
            String inputNames = scanner.nextLine();
            Validator.checkEndsWithComma(inputNames);

            List<String> names = Splitter.splitByComma(inputNames);
            Validator.checkEmptyTag(names);
            Validator.checkDuplicateNames(names);
            names.forEach(Validator::checkNameIsAll);
            return names;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputMembers();
        }
    }

    public static List<String> inputPrizes(int size) {
        OutputView.outputMessage(INPUT_PRIZES);
        try {
            String inputNames = scanner.nextLine();
            Validator.checkEndsWithComma(inputNames);

            List<String> names = Splitter.splitByComma(inputNames);
            Validator.checkEmptyTag(names);
            Validator.checkEqualSize(size, names.size());
            return names;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputPrizes(size);
        }
    }

    public static int inputHeight() {
        try {
            System.out.println(INPUT_HEIGHT);
            return Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println(ERROR_MESSAGE);
            return inputHeight();
        }
    }

    public static String inputWantResult() {
        System.out.println(INPUT_WANT_RESULT);
        return scanner.nextLine();
    }
}