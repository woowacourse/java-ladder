package ladder.domain.player;

import java.util.Objects;

public class Name {

    public static final int NAME_MAXIMUM_LENGTH = 5;
    private static final char START_KOREAN = '가';
    private static final char END_KOREAN = '힣';

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateNameLength(String name) {
        int length = calculateLength(name);
        if (name.isBlank() || length > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("플레이어의 이름 길이는 1 이상 5 이하여야 합니다. 영어, 숫자, 공백 = 길이 1 / 한글 = 길이 2");
        }
    }

    private int calculateLength(String content) {
        int countKorean = 0;
        for (int index = 0; index < content.length(); index++) {
            char charAt = content.charAt(index);
            countKorean += countKorean(charAt);
        }
        return content.length() + countKorean;
    }

    private int countKorean(char letter) {
        if (letter >= START_KOREAN && letter <= END_KOREAN) {
            return 1;
        }
        return 0;
    }

}
