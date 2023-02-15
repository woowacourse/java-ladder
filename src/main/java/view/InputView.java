package view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import utils.ScannerUtil;

public class InputView {

    public static List<String> inputName() {
        return handleExceptionByRepeating(() -> {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String input = ScannerUtil.nextLine();

            List<String> names = splitNames(input);
            validateNoDuplicated(names);
            return names;
        });
    }

    public static int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtil.nextInt();
    }

    private static List<String> splitNames(String input) {
        return List.of(input.split(","));
    }

    private static void validateNoDuplicated(List<?> names) {
        if (hasDuplicated(names)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static boolean hasDuplicated(List<?> target) {
        Set<?> duplicateRemoval = new HashSet<>(target);
        return target.size() != duplicateRemoval.size();
    }

    private static <T> T handleExceptionByRepeating(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return handleExceptionByRepeating(supplier);
        }
    }
}
