package laddergame.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkBlankName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("빈 이름이 입력되었습니다.");
        }
    }

    public static void checkNameLength(String name, int length) {
        if (name.length() > length) {
            throw new IllegalArgumentException("길이 제한을 벗어났습니다.");
        }
    }

    public static void checkEqualSize(int size, int anotherSize) {
        if (size != anotherSize) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수가 다릅니다.");
        }
    }

    public static void checkNumberOfNames(List<String> names, int min) {
        if (names.size() < min) {
            throw new IllegalArgumentException("두 사람이상이여야 게임이 가능합니다.");
        }
    }

    public static void checkDuplicateNames(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
    }

    public static void checkNameIsAll(String name) {
        if ("all".equals(name)) {
            throw new IllegalArgumentException("이름은 all이 될 수 없습니다");
        }
    }

    public static void checkEndsWithComma(String names) {
        if (names.endsWith(",")) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
    }

    public static void checkLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("1이상의 높이를 입력해 주세요!");
        }
    }
}
