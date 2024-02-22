package domain;

public class Game {

    private final Members members;
    private final Lines lines;

    public Game(Members members, Lines lines) {
        this.members = members;
        this.lines = lines;
    }

    public Members getMembers() {
        return members;
    }

    public Lines getLines() {
        return lines;
    }

    // 사다리 게임 실제 로직 -> LV 2
    // 게임 결과 만드는 로직 (우승자, 당첨 정보 등) -> LV 2
}
