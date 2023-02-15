package validate;

import java.util.ArrayList;
import java.util.List;

public class InputVerifier {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_HEIGHT = 0;
    public static final String NAME_LENGTH_ERROR_MESSAGE =
            "[ERROR] 사람 이름은 " + MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "글자로 입력해 주세요.";
    public static final String NAME_FORMAT_ERROR_MESSAGE = "[ERROR] 사람 이름은 영문자만 가능합니다.";
    public static final String HEIGHT_FORMAT_ERROR_MESSAGE = "[ERROR] 사다리 높이는 숫자만 가능합니다.";
    public static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 값을 입력하지 않았습니다.";
    public static final String HEIGHT_LIMIT_ERROR_MESSAGE = "[ERROR] 사다리 높이는 " + MIN_HEIGHT + " 이상만 가능합니다.";

    public List<String> validateNameInput(String nameInput) {
        validateNameLength(nameInput);
        validateNameFormat(nameInput);
        return convertNames(splitNameInput(nameInput));
    }

    private void validateNameLength(String name) {
        if (isValidLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isValidLength(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    private void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-z]*$")) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    public List<String> splitNameInput(String nameInput) {
        return List.of(nameInput.split(","));
    }

    public List<String> convertNames(List<String> names) {
        List<String> convertedNames = new ArrayList<>();
        for (String name : names) {
            convertedNames.add(compareNameLength(name));
        }
        return convertedNames;
    }

    private String compareNameLength(String name) {
        if (name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        return insertBlank(name);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        return nameBuilder.toString();
    }

    public int validateHeightInput(String heightInput) {
        validateHeightFormat(heightInput);
        int height = convertHeightInput(heightInput);
        validateHeightLimit(height);
        return height;
    }

    private void validateHeightFormat(String heightInput) {
        if (!heightInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(HEIGHT_FORMAT_ERROR_MESSAGE);
        }
    }

    private int convertHeightInput(String heightInput) {
        try {
            return Integer.parseInt(heightInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
        }
    }

    private void validateHeightLimit(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_LIMIT_ERROR_MESSAGE);
        }
    }
}
