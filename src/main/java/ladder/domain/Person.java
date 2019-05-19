package ladder.domain;

import ladder.util.InputHelper;

import java.util.HashSet;
import java.util.List;

public class Person {
    private static final String EXCEPTION_MESSAGE = "양식에 맞게 입력해 주세요.";
    private static final String DUPLICATED_MESSAGE = "중복된 이름은 허용하지 않습니다.";
    private static final String NOT_ALLOW_ALL_MESSAGE = "이름 all은 허용하지 않습니다.";
    private static final int NAME_MAX_LENGTH = 6;
    private final List<String> names;

    public Person(String names) {
        this.names = checkValidName(names);
    }

    private List<String> checkValidName(String inputs) {
        isEmpty(inputs);
        hasSpace(inputs);
        checkLastIndex(inputs);
        List<String> names = InputHelper.splitNames(inputs);
        for (String name : names) {
            isOverMaxInputLimit(name);
            nameEqualAll(name);
        }
        isDuplicate(names);
        return names;
    }

    private static void isEmpty(String inputs) {
        if (inputs == null || inputs.length() == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private static void checkLastIndex(String inputs) {
        if (inputs.lastIndexOf(",") == inputs.length() - 1) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private static void hasSpace(String inputs) {
        if (inputs.contains(" ")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private static void isOverMaxInputLimit(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private static void nameEqualAll(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException(NOT_ALLOW_ALL_MESSAGE);
        }
    }

    private static void isDuplicate(List<String> name) {
        HashSet<String> names = new HashSet<>(name);
        if (names.size() != name.size()) {
            throw new IllegalArgumentException(DUPLICATED_MESSAGE);
        }
    }

    String getName(int index) {
        return names.get(index);
    }

    public int getCountOfPerson() {
        return names.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(makeBlank(name));
            sb.append(name);
        }
        return sb.toString();
    }

    private String makeBlank(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NAME_MAX_LENGTH - name.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public boolean findName(String requestedName) {
        return names.contains(requestedName);
    }
}