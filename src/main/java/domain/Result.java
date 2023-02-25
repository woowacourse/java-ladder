package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private final String prize;
    private String playerName;

    public Result(String prize) {
        this.prize = prize;
    }

    public static List<Result> createResults(List<String> inputResults) {
        return inputResults.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public String getPrize() {
        return prize;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void savePlayer(String playerName) {
        this.playerName = playerName;
    }
}
