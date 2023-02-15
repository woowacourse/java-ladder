import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_LENGTH_ERROR_MESSAGE =
            "[ERROR] 사람 이름은 " + MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "글자로 입력해 주세요.";
    public static final String NAME_FORMAT_ERROR_MESSAGE = "[ERROR] 사람 이름은 영문자만 가능합니다.";

    private String name;

    public static void validateNameLength(String name) {
        if (isValidLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isValidLength(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    public static void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-z]*$")) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    public static List<String> splitNameInput(String nameInput) {
        return List.of(nameInput.split(","));
    }

    public static List<String> convertNames(List<String> names) {
        List<String> convertedNames = new ArrayList<>();
        for (String name : names) {
            convertedNames.add(convert(name));
        }
        return convertedNames;
    }

    private static String convert(String name) {
        if (name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        name = nameBuilder.toString();
        return name;
    }
}
