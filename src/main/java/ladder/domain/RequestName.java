package ladder.domain;

import java.util.Objects;

public class RequestName {
    private static final String ALL = "all";

    private final String requestName;

    public RequestName(String requestName, UserNames userNames) {
        validateRequestName(requestName, userNames);
        this.requestName = requestName;
    }

    public void validateRequestName(String requestName, UserNames userNames) {
        boolean isNotAll = !requestName.equals(ALL);
        boolean isNotExist = !userNames.isExist(requestName);
        if (isNotAll && isNotExist) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
    }

    public boolean isNotAll() {
        return !Objects.equals(requestName, ALL);
    }

    public String getRequestName() {
        return requestName;
    }
}
