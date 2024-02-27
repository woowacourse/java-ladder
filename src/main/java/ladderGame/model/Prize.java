package ladderGame.model;

import java.util.regex.Pattern;

public class Prize {

    private static final Pattern PRIZE_PATTERN = Pattern.compile("^(꽝|\\d{1,5})$");
    private static final String EXCEPTION_MESSAGE_UNDEFINED_MESSAGE = "실행 결과는 꽝 또는 0 이상 99999 이하의 숫자만 입력 가능합니다.";

    private String prize;

    public Prize(String prize) {
        validate(prize);
        this.prize = prize;
    }

    private void validate(String prize) {
        if(!PRIZE_PATTERN.matcher(prize).matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_UNDEFINED_MESSAGE);
        }
    }

    public String getPrize() {
        return prize;
    }
}
