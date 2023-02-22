package laddergame.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final PersonalNames personalNames;
    private final LadderResult ladderResult;

    public LadderGame(PersonalNames personalNames, LadderResult ladderResult) {
        this.personalNames = personalNames;
        this.ladderResult = ladderResult;
    }

    public Map<String, String> moveAndGetResult(Ladder ladder) {
        List<Player> players = initPlayers();

        return players.stream().collect(Collectors.toMap(
                player -> player.getPersonalName().getValue(),
                player -> moveAndGetResult(player, ladder).getName()
        ));
    }

    private List<Player> initPlayers() {
        List<PersonalName> names = personalNames.getPersonalNames();
        List<Player> players = IntStream.range(0, names.size())
                .mapToObj(index -> new Player(names.get(index), index))
                .collect(Collectors.toList());
        return players;
    }

    private LadderResultItem moveAndGetResult(Player player, Ladder ladder) {
        for (final Line line : ladder.getLines()) {
            goDownOneLine(player, line);
        }
        return ladderResult.getResultItems().get(player.getPosition().getValue());
    }

    private void goDownOneLine(Player player, Line line) {
        if (player.getPosition().getValue() < personalNames.getPersonalNames().size() - 1 && line.doesRungExistsIndexOf(
                player.getPosition().getValue())) {
            player.moveRight();
            return;
        }
        if (player.getPosition().getValue() > 0 && line.doesRungExistsIndexOf(
                player.getPosition().getValue() - 1)) {
            player.moveLeft();
        }
    }
}
