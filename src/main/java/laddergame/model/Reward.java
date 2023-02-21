package laddergame.model;

public class Reward {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_NAME_OUT_OF_LENGTH =
        "공백이 제거된 결과의 길이는 " + MIN_NAME_LENGTH + "보다 크고 " + MAX_NAME_LENGTH + "보다 작아야 합니다.";

    private final String name;

    public Reward(String name) {
        String noBlankName = name.replaceAll(" ", "");
        validateLength(noBlankName.length());
        this.name = noBlankName;
    }

    private static void validateLength(int nameLength) {
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_OUT_OF_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
