package domain.prize;

public record Prize(String name) {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    public Prize {
        validateLength(name);
    }

    private void validateLength(final String name) {
        final String errorMessage = String.format("이름의 길이는 %d ~ %d 자 이어야 합니다.", NAME_LENGTH_MIN, NAME_LENGTH_MAX);
        if (NAME_LENGTH_MIN > name.length() || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
