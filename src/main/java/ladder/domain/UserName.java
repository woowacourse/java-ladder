package ladder.domain;

public class UserName {
    public UserName(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5 이하여야 합니다.");
        }
    }
}
