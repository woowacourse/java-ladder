package domain;

public class Game {

    private final Lines lines;
    private final Members members;

    public Game(Lines lines, Members members) {
        this.lines = lines;
        this.members = members;
    }

    public Lines getLines() {
        return lines;
    }

    public Members getMembers() {
        return members;
    }

    // TODO: 사다리 게임 실제 로직 -> LV 2
    // TODO: 게임 결과 만드는 로직 (우승자, 당첨 정보 등) -> LV 2
}
