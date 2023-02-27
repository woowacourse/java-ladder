package ladder.view;

import ladder.validator.CommonValidator;
import ladder.view.util.InputValidator;
import ladder.view.util.OutputViewHelper;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_PRINT_WANT_RESULT = "\n결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static String inputPeopleNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPeopleNames = sc.nextLine();

        CommonValidator.validateBlank(inputPeopleNames);

        return inputPeopleNames;
    }

    public static String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputResults = sc.nextLine();

        CommonValidator.validateBlank(inputResults);

        return inputResults;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = sc.nextLine();

        CommonValidator.validateBlank(ladderHeight);
        InputValidator.validateNonNumber(ladderHeight);

        return InputValidator.validateLadderHeightRange(Integer.parseInt(ladderHeight));
    }

    public static String inputWantGameResults(List<String> namesList) {
        System.out.println(INPUT_PRINT_WANT_RESULT);
        String inputWantGameResults = sc.nextLine();

        CommonValidator.validateBlank(inputWantGameResults);
        InputValidator.validateContainName(namesList, inputWantGameResults);

        return inputWantGameResults;
    }

    public static <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputViewHelper.printExceptionMessage(illegalArgumentException);
            return repeat(supplier);
        }
    }
}
