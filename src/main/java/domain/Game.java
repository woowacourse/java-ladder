package domain;

public class Game {

    private final Members members;
    private final Lines lines;
    private final Results results;

    private Game(Members members, Lines lines, Results results) {
        this.members = members;
        this.lines = lines;
        this.results = results;
    }

    public static Game of(Members members, Lines lines, Results results) {
        return new Game(members, lines, results);
    }

    public Members getMembers() {
        return members;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }
}
