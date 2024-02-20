package domain;

import java.util.Arrays;

public class Participants {

    public Participants(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("[ERROR] 참가자는 2명 이상이어야 합니다.");
        }
        if (names.length > 50) {
            throw new IllegalArgumentException("[ERROR] 참가자는 50명 이하여야 합니다.");
        }
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("[ERROR] 참가자 이름은 중복될 수 없습니다.");
        }
    }
}
