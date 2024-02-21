package domain;

public class UserName {

    private String userName;

    public UserName(String userName) {
        validate(userName);
        this.userName = userName;
    }

    private void validate(String userName) {
        validateLength(userName);
        validateEmpty(userName);

    }

    private static void validateEmpty(String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 비어 있을 수 없습니다.", userName));
        }
    }

    private static void validateLength(String userName) {
        if (userName.length() > 5) {
            throw new IllegalArgumentException(String.format("입력 된 값: %s, 사용자 이름은 5글자 이하로 입력해 주세요.", userName));
        }
    }
}
