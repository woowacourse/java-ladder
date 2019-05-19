package laddergame.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void checkEndsWithComma(String names) {
        if (names.endsWith(",")) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
    }

    public static void checkMemberNames(List<String> names) {
        checkEmptyTag(names);
        checkDuplicateNames(names);
        names.forEach(InputValidator::checkNameIsAll);
    }

    public static void checkPrizesName(List<String> names, int size) {
        checkEmptyTag(names);
        checkEqualSize(names.size(), size);
    }

    public static void checkHeightIsPositive(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다!");
        }
    }

    private static void checkEmptyTag(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다!");
        }
    }

    private static void checkDuplicateNames(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
    }

    private static void checkNameIsAll(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException("이름은 all이 될 수 없습니다");
        }
    }

    private static void checkEqualSize(int memberSize, int prizeSize) {
        if (memberSize != prizeSize) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 개수는 같아야 합니다.");
        }
    }
}
