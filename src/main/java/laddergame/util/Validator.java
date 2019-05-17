package laddergame.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkEmptyTag(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다!");
        }
    }

    public static void checkDuplicateNames(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
    }

    public static void checkEqualSize(int memberSize, int prizeSize) {
        if (memberSize != prizeSize) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 개수는 같아야 합니다.");
        }
    }
}
