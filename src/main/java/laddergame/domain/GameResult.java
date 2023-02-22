package laddergame.domain;

public class GameResult {

    private final String name;
    private final String prizeValue;

    public GameResult(String name, String prizeValue) {
        this.name = name;
        this.prizeValue = prizeValue;
    }

    public String getName() {
        return name;
    }

    public String getPrizeValue() {
        return prizeValue;
    }
}
