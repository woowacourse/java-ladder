package domain;

import java.util.List;

public class Users {
    public Users(List<String> a) {
        if (a.size() < 2 || a.size() > 10) {
            throw new IllegalArgumentException("유저는 최소 2명 이상이다.");
        }
    }
}
