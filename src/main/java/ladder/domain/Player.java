package ladder.domain;

/**
 * 플레이어의 이름과 위치를 가지는 클래스
 * <p>
 * Ladder 를 받아서 결과를 반환하는 역할을 가진다.
 * <p>
 * 이름을 반환해준다
 */
public class Player {

    private final PlayerName name;
    private final Position position;

    Player(String name, int position) {
        this.name = new PlayerName(name);
        this.position = Position.valueOf(position);
    }

    public String getName() {
        return name.getName();
    }

    Position calculateResult(Ladder ladder) {
        return ladder.calculateResult(position);
    }
}
