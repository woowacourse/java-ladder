package domain;

public class Game {

    private final Members members;
    private final Lines lines;

    private Game(Members members, Lines lines) {
        this.members = members;
        this.lines = lines;
    }

    public static Game of(Members members, Lines lines) {
        return new Game(members, lines);
    }

    public Members getMembers() {
        return members;
    }

    public Lines getLines() {
        return lines;
    }
}
