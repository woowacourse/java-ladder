package domain;

import java.util.List;

public class TargetPlayer {

    private static final String ALL_COMMEND = "all";

    private final String name;

    public TargetPlayer(String name, List<String> names) {
        if (!names.contains(name) && !name.equals(ALL_COMMEND)) {
            String message = String.format("%s이나 기존 사용자 이름을 입력해야 합니다.", ALL_COMMEND);
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    public boolean isAll() {
        return name.equals(ALL_COMMEND);
    }

    public String getName() {
        return this.name;
    }
}
