package laddergame.domain;

import java.util.*;

public class PlayerNames {
    public static List<String> makeNames(String input) {
        checkNullName(input);

        input = input.replaceAll(" ", "");
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));

        checkConditions(input, names);

        return names;
    }

    private static void checkConditions(String input, List<String> names) {
        checkEmptyName(input);
        checkNameLength(names);
        checkDuplicatedName(names);
    }

    private static void checkDuplicatedName(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    private static void checkNameLength(List<String> names) {
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5)
                throw new IllegalArgumentException("이름의 길이는 1이상이어야 합니다.\n다시 입력해주세요.");
        }
    }

    private static void checkNullName(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력하신 이름이 null입니다.\n다시 입력해주세요.");
        }
    }

    private static void checkEmptyName(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력하신 이름이 없습니다.\n다시 입력해주세요.");
        }
    }
}
