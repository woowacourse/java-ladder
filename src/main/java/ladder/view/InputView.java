package ladder.view;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Pattern NOT_NUMERIC_FORMAT = Pattern.compile("\\D");
    private static final Pattern INPUT_NAMES_FORMAT = Pattern.compile("([a-zA-Z]*)(,[a-zA-Z]*)*");
    
    private InputView() {
        throw new IllegalStateException("인스턴스를 생성할 수 없는 유틸클래스입니다.");
    }
    
    public static String inputPeopleNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPeopleNames = SCANNER.nextLine();
        validatePeopleNames(inputPeopleNames);
        return inputPeopleNames;
    }
    
    private static void validatePeopleNames(String inputPeopleNames) {
        validateBlank(inputPeopleNames);
        validatePeopleNamesInputFormat(inputPeopleNames);
    }
    
    public static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
    
    private static void validatePeopleNamesInputFormat(String names) {
        Matcher matcher = INPUT_NAMES_FORMAT.matcher(names);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
        }
    }
    
    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = SCANNER.nextLine();
        validateLadderHeight(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }
    
    private static void validateLadderHeight(String ladderHeight) {
        validateBlank(ladderHeight);
        validateNonNumber(ladderHeight);
    }

    private static void validateNonNumber(String ladderHeight) {
        Matcher matcher = NOT_NUMERIC_FORMAT.matcher(ladderHeight);
        if (matcher.find()) {
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }
    
    public static String inputExecutionResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
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
