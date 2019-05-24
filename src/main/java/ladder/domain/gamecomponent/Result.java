package ladder.domain.gamecomponent;

import org.apache.commons.lang3.StringUtils;

public class Result {
    private static final String VIOLATE_BLANK = "공백인 실행결과가 있습니다. 다시 입력해주세요.";

    private final String result;

    public Result(String result) {
        checkIsBlank(result);
        this.result = result;
    }

    private void checkIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(VIOLATE_BLANK);
        }
    }

    @Override
    public String toString() {
        return result;
    }
}
