package ladder.domain;

/**
 * 결과의 이름을 검증하는 역할을 가진 클래스
 * <p>
 * 1. null 체크 2. 길이 체크 3. 공백 체크 이런 경우에는 IllegalArgumentException 을 발생시킴
 */
class ItemName {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NULL_MESSAGE =
            "이름은 " + MIN_NAME_LENGTH + "이상 " + MAX_NAME_LENGTH + "이하로 입력해주세요. " + "현재 이름이 null 입니다.";
    private static final String OVER_RANGE_MESSAGE =
            "이름은 " + MIN_NAME_LENGTH + "이상 " + MAX_NAME_LENGTH + "이하로 입력해주세요. 현재 이름의 길이는 %s 입니다.";

    private final String name;

    ItemName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNull(name);
        validateLength(name);
        validateIsBlank(name);
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로 입력할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(OVER_RANGE_MESSAGE, name.length()));
        }
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
