package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Prize;
import ladder.domain.Step;

public class LadderResponse {
    private final List<String> playerNames;
    private final List<List<Step>> lines;
    private final List<String> prizeNames;

    public LadderResponse(List<String> playerNames, List<List<Step>> lines, List<String> prizeNames) {
        this.playerNames = playerNames;
        this.lines = lines;
        this.prizeNames = prizeNames;
    }

    public static LadderResponse of(List<Player> players, Ladder ladder, List<Prize> prizes) {
        List<String> playerNames = convertPlayerNames(players);
        List<List<Step>> lines = convertLines(ladder);
        List<String> prizeNames = convertPrizeNames(prizes);
        return new LadderResponse(playerNames, lines, prizeNames);
    }

    private static List<String> convertPlayerNames(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }

    private static List<List<Step>> convertLines(Ladder ladder) {
        return ladder.getLines().stream()
                .map(Line::getSteps)
                .collect(toList());
    }

    private static List<String> convertPrizeNames(List<Prize> prizes) {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(toList());
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<List<Step>> getLines() {
        return lines;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }
}
