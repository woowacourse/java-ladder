package domain;

public class Reward {

    private static final int MIN_REWARD = 1;
    private static final int MAX_REWARD = 99999;
    private static final String NO_REWARD = "꽝";

    private final String name;

    private Reward(String name) {
        validate(name);
        this.name = name;
    }

    public static Reward from(String rawName) {
        validateNull(rawName);
        return new Reward(rawName);
    }

    private void validate(String name) {
        validateBlank(name);
        if (!name.equals(NO_REWARD)) {
            validateNumeric(name);
            validateRange(name);
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
        }
    }

    private void validateNumeric(String name) {
        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("숫자 혹은 '%s'만 입력 가능합니다.", NO_REWARD));
        }
    }

    private void validateRange(String name) {
        int reward = Integer.parseInt(name);
        if (reward < MIN_REWARD || reward > MAX_REWARD) {
            throw new IllegalArgumentException(
                String.format("%d 이상 %d 이하의 숫자만 입력 가능합니다.", MIN_REWARD, MAX_REWARD));
        }
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
