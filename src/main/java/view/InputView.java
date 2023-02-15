package view;

import utils.ScannerUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static List<String> inputName() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String input = ScannerUtil.nextLine();

            List<String> names = List.of(input.split(","));

            if (hasDuplicated(names)) {
                throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
            }

            return names;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputName();
        }
    }

    public static int inputMaxLadderHeight() {

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtil.nextInt();
    }

    private static boolean hasDuplicated(List<?> target) {
        Set<?> duplicateRemoval = new HashSet<>(target);
        return target.size() != duplicateRemoval.size();
    }
}
