package domain;

import java.util.Arrays;
import java.util.List;

public class Names {
    private final List<Name> names;

    public Names(String names) {
        validateSeparator(names);
        List<String> splitNames = splitName(names);
        validateDuplicateName(splitNames);
        validateNameCount(splitNames);
        this.names = splitNames.stream().map(Name::new).toList();
    }

    private static List<String> splitName(String names) {
        return Arrays.stream(names.split(",")).toList();
    }

    private static void validateNameCount(List<String> splitNames) {
        if (splitNames.size() > 10) {
            throw new RuntimeException("사람은 최대 10명까지 받을 수 있습니다.");
        }
    }

    private void validateDuplicateName(List<String> splitNames) {
        long distinctCount = splitNames.stream().distinct().count();
        if (distinctCount != splitNames.size()) {
            throw new RuntimeException("이름은 중복될 수 없습니다.");
        }
    }

    private void validateSeparator(String names) {
        boolean startsWith = names.startsWith(",");
        boolean endsWith = names.endsWith(",");
        if (startsWith || endsWith) {
            throw new RuntimeException("구분자가 맨 앞이나 맨 뒤에 있으면 안됩니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
