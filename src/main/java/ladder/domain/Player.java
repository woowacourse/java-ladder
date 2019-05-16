package ladder.domain;

import ladder.util.Const;
import ladder.util.Rule;

import java.util.Objects;

/**
 * 참여자 클래스
 * <br> Player player = new Player("heebg")
 * <br> Player player = new Player("heebg",2);
 *
 * @author heebg, hyojaekim
 * @version 1.0 2019-05-15
 */
public class Player {
    private final String name;
    private int position;

    /**
     * 생성자
     * <br> 사다리 번호 위치는 0으로 셋팅
     *
     * @param name 참여자 이름
     * @throws IllegalArgumentException 이름 길이가 rule과 다를 때 발생
     */
    public Player(String name) {
        this(name, Const.ZERO);
    }

    /**
     * 생성자
     *
     * @param name     참여자 이름
     * @param position 사다리 번호 위치
     * @throws IllegalArgumentException 이름 길이가 rule과 다를 때 발생
     */
    public Player(String name, int position) {
        this.name = Rule.rulePlayerNameLength(name);
        this.position = checkPosition(position);
    }

    private int checkPosition(int position) {
        if (position < Const.ZERO) {
            throw new IllegalArgumentException(Const.RUN_EX_PLAYER_POSITION);
        }
        return position;
    }

    /**
     * 이름 반환
     *
     * @return name 참여자 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 사다리 번호 위치 반환
     *
     * @return position 위치
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * 사다리 번호 위치 왼쪽으로 이동
     */
    public void moveLeftPosition() {
        --this.position;
    }

    /**
     * 사다리 번호 위치 오른쪽으로 이동
     */
    public void moveRightPosition() {
        ++this.position;
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
