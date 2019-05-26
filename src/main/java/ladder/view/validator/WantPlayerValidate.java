package ladder.view.validator;

import org.apache.commons.lang3.StringUtils;

public class WantPlayerValidate {
    public static final String EX_WANT_NAME = "없는 이름입니다.";

    /**
     * 비어있는 이름이면 안됨
     *
     * @param inputWantName
     * @return
     */
    public static void wantName(String inputWantName) {
        if (StringUtils.isBlank(inputWantName)) {
            throw new IllegalArgumentException(EX_WANT_NAME);
        }
    }
}
