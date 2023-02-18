package ladder.view;

import ladder.validator.CommonValidator;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static final Pattern NOT_NUMERIC_FORMAT = Pattern.compile("\\D");
    
    public static String inputPeopleNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPeopleNames = sc.nextLine();
        CommonValidator.validateBlank(inputPeopleNames);
        return inputPeopleNames;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = sc.nextLine();
        validateLadderHeight(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private static void validateLadderHeight(String ladderHeight) {
        CommonValidator.validateBlank(ladderHeight);
        validateNonNumber(ladderHeight);
    }

    private static void validateNonNumber(String ladderHeight) {
        Matcher matcher = NOT_NUMERIC_FORMAT.matcher(ladderHeight);
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
