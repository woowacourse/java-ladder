package domain;

import java.util.List;

public class TargetPlayerResult {

    private final String name;

    public TargetPlayerResult(String name, List<String> names) {
        if (!names.contains(name) && !name.equals("all")) {
            throw new IllegalArgumentException("all 이나 기존 사용자 이름을 입력해야 합니다.");
        }
        this.name = name;
    }

    public String getTargetPlayerName() {
        return null;
    }
}
