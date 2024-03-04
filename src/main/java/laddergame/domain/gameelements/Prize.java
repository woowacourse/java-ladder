package laddergame.domain.gameelements;

public class Prize {
    // TODO 같은 포지션에 있는 객체인지 판단 메서드 만들기
    private final Name name;
    private final Position position;

    public Prize(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
