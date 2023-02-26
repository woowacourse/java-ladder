package model;

public class GameResult {

    private final String name;
    private final String ladderResult;

    public GameResult(String name, String ladderResult) {
        this.name = name;
        this.ladderResult = ladderResult;
    }

    public boolean matchesByName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public String getLadderResult() {
        return ladderResult;
    }
}
