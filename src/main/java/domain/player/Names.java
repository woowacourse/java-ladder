package domain.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 100;
    private static final String SPLIT_STANDARD = ",";

    private final List<Name> names;

    public Names(String names) {
        List<Name> formattedNames = formatNames(names);
        validateSize(formattedNames.size());
        validateDuplicatedNames(formattedNames);
        this.names = formattedNames;
    }

    private static List<Name> formatNames(String names) {
        return Arrays.stream(names.split(SPLIT_STANDARD))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateSize(int personNumber) {
        if (personNumber < MIN_RANGE || personNumber > MAX_RANGE) {
            throw new IllegalArgumentException(Message.EXCEPTION_NAMES_SIZE.message);
        }
    }

    private static void validateDuplicatedNames(List<Name> formattedNames) {
        if (formattedNames.stream().distinct().count() != formattedNames.size()) {
            throw new IllegalArgumentException(Message.EXCEPTION_DUPLICATE_NAMES.message);
        }
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    public int getPersonNumber() {
        return names.size();
    }


    protected enum Message {
        EXCEPTION_DUPLICATE_NAMES("입력한 사용자 이름은 중복될 수 없습니다."),
        EXCEPTION_NAMES_SIZE("%d명 이상 %d명 이하의 사람 수를 입력해 주세요.", MIN_RANGE, MAX_RANGE);

        public static final String BASE_MESSAGE_FORMAT = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE_FORMAT, String.format(message, replaces));
        }
    }
}
