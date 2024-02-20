package ladder.domain;

import java.util.List;

public class UserNames {
    public UserNames(List<UserName> userNames) {
        if (userNames.size() > 7) {
            throw new IllegalArgumentException("사용자는 7명 이하여야 합니다");
        }
    }
}
