package domain;

import java.util.Arrays;
import java.util.List;

public class Names {
    public Names(String names) {
        boolean startsWith = names.startsWith(",");
        boolean endsWith = names.endsWith(",");
        if (startsWith || endsWith) {
            throw new RuntimeException("구분자가 맨 앞이나 맨 뒤에 있으면 안됩니다.");
        }
        List<String> splitNames = Arrays.stream(names.split(",")).toList();
        long distinctCount = splitNames.stream().distinct().count();
        if (distinctCount != splitNames.size()) {
            throw new RuntimeException("이름은 중복될 수 없습니다.");
        }

        if (splitNames.size() > 10) {
            throw new RuntimeException("사람은 최대 10명까지 받을 수 있습니다.");
        }
    }
}
