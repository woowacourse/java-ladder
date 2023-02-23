package ladder.view;

import ladder.validator.CommonValidator;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final Pattern notNumberPattern = Pattern.compile("\\D");

    private InputView() {
    }

    public static String inputPeopleNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPeopleNames = sc.nextLine();
        validateBlank(inputPeopleNames);
        return inputPeopleNames;
    }

    public static String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputResults = sc.nextLine();
        validateBlank(inputResults);
        return inputResults;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = sc.nextLine();
        validateLadderHeight(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    public static String inputWantGameResults(List<String> namesList) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String inputWantGameResults = sc.nextLine();
        validateBlank(inputWantGameResults);
        validateContainName(namesList, inputWantGameResults);
        return inputWantGameResults;
    }

    private static void validateContainName(List<String> namesList, String inputWantGameResults) {
        if (!namesList.contains(inputWantGameResults) && !inputWantGameResults.equals("all")) {
            throw new IllegalArgumentException("해당하는 이름이 존재하지 않습니다.");
        }
    }

    private static void validateLadderHeight(String ladderHeight) {
        validateBlank(ladderHeight);
        validateNonNumber(ladderHeight);
    }

    private static void validateBlank(String input) {
        CommonValidator.validate(input);
    }

    private static void validateNonNumber(String ladderHeight) {
        Matcher matcher = notNumberPattern.matcher(ladderHeight);
        if (matcher.find()) {
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }

    public static <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printExceptionMessage(illegalArgumentException);
            return repeat(supplier);
        }
    }
}
