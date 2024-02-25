package ladder.domain;

import java.util.Objects;

public class RequestName {
    private final String requestName;

    public RequestName(String requestName, UserNames userNames) {
        validateAvailable(requestName, userNames);
        this.requestName = requestName;
    }

    public void validateAvailable(String requestName, UserNames userNames) {
        boolean isNotAll = !requestName.equals("all");
        boolean isNotExist = !userNames.isExist(requestName);
        if (isNotAll && isNotExist) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
    }

    public boolean isAll() {
        return Objects.equals(requestName, "all");
    }

    public String getRequestName() {
        return requestName;
    }
}
