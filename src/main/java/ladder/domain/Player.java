package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 사용자 클래스
 * <br> Player player = Player.newBuilder("name")
 *
 * @author heebg
 * @version 1.0 2019-05-17
 */
public class Player {
    private static final int CNT_MAX_INPUT_RANGE = 5;
    private static final int CNT_MIN_INPUT_RANGE = 1;
    private static final String SIGH_EX_NAME = "all";
    private static final String EX_INPUT_RANGE = "이름은 " + CNT_MIN_INPUT_RANGE + "글자~" + CNT_MAX_INPUT_RANGE + "글자 사이로 입력해야합니다.";
    private static final String EX_NAME_EXSIGN = SIGH_EX_NAME + "은 이름으로 사용할 수 없습니다.";

    private final String name;

    private Player(String name) {
        this.name = checkCondition(name);
    }

    /**
     * 생성자
     *
     * @param name 이름
     * @return
     */
    public static Player newBuilder(String name) {
        return new Player(name);
    }

    private String checkCondition(String name) {
        name = name.trim();
        makeThrow(StringUtils.isBlank(name), EX_INPUT_RANGE);
        makeThrow(name.length() > CNT_MAX_INPUT_RANGE, EX_INPUT_RANGE);
        makeThrow(name.equals(SIGH_EX_NAME), EX_NAME_EXSIGN);
        return name;
    }

    private void makeThrow(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
