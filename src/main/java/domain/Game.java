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
}
