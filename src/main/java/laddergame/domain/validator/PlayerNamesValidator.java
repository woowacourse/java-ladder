package laddergame.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PlayerNamesValidator {
    public static void checkDuplicatedName(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    public static void checkNullName(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("입력하신 이름이 null입니다.\n다시 입력해주세요.");
        }
    }
}
