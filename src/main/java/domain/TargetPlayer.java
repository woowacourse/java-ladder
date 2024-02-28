package domain;

import java.util.List;

public class TargetPlayer {

    private final String name;

    public TargetPlayer(String name, List<String> names) {
        if (!names.contains(name) && !name.equals("all")) {
            throw new IllegalArgumentException("all 이나 기존 사용자 이름을 입력해야 합니다.");
        }
        this.name = name;
    }

    public boolean isAll() {
        return name.equals("all");
    }

    public String getName() {
        return this.name;
    }
}
