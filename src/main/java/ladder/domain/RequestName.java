package ladder.domain;

import java.util.Objects;

public class RequestName {
    private final String requestName;

    public RequestName(String requestName, UserNames userNames) {
        if (!requestName.equals("all") && !userNames.isExist(requestName)) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
        }
        this.requestName = requestName;
    }

    public boolean isAll() {
        return Objects.equals(requestName, "all");
    }

    public String getRequestName() {
        return requestName;
    }
}
