package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractName {
    public static final int BOUND_OF_NAME_LENGTH = 5;

    protected void validate(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("공백을 입력하였습니다");
        }
        if (name.length() > BOUND_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리 이하 결과만 입력 가능합니다.");
        }
    }

    public abstract String getName();
}
