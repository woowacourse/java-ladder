package laddergame.domain.gameelements;

public class Player {
    // TODO 이름 비교에 대한 책임 메서드
    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        validateReservedName(name);
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        position.moveLeft();
    }

    public void moveRight() {
        position.moveRight();
    }

    private void validateReservedName(Name playerName) {
        Name reservedName = Name.reservedName();

        if (playerName.equals(reservedName)) {
            throw new IllegalArgumentException("예약어 " + reservedName.getName() + "은 이름으로 지정할 수 없습니다.");
        }
    }

    public Position getPlayerPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
