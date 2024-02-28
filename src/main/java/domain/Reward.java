package domain;

public class Reward {

    private static final int MIN_REWARD = 1;
    private static final int MAX_REWARD = 99999;

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
        if (!name.equals("꽝")) {
            validateNumeric(name);
            validateRange(name);
        }
    }

    private void validateNumeric(String name) {
        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 혹은 '꽝'만 입력 가능합니다.");
        }
    }

    private void validateRange(String name) {
        int reward = Integer.parseInt(name);
        if (reward < MIN_REWARD || reward > MAX_REWARD) {
            throw new IllegalArgumentException(
                MIN_REWARD + " 이상 " + MAX_REWARD + " 이하의 숫자만 입력 가능합니다.");
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
