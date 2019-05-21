package ladder.domain;

import ladder.view.PlayerException;

import java.util.Objects;

/**
 * 참여자 클래스
 * <br> Player player = new Player("heebg")
 *
 * @author heebg, hyojaekim
 * @version 1.0 2019-05-15
 */
public class Player {
    private final String name;

    /**
     * 생성자
     *
     * @param name 참여자 이름
     * @throws IllegalArgumentException 이름 길이가 rule과 다를 때 발생
     */
    public Player(String name) {
        this.name = PlayerException.playerNameOverLength(name);
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
