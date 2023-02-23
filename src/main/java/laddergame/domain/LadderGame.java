package laddergame.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final List<Player> players;
    private final LadderResult ladderResult;

    public LadderGame(PersonalNames personalNames, LadderResult ladderResult) {
        this.ladderResult = ladderResult;
        this.players = initPlayers(personalNames);
    }

    public NamesWithMatchedResult moveAndGetResult(Ladder ladder) {
        Map<PersonalName, LadderResultItem> nameToItem = players.stream().collect(Collectors.toMap(
                player -> player.getPersonalName(),
                player -> moveAndGetResult(player, ladder)
        ));
        return new NamesWithMatchedResult(nameToItem);
    }

    private List<Player> initPlayers(PersonalNames personalNames) {
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
        if (player.getPosition().getValue() < players.size() - 1 && line.isPointFilledAt(
                player.getPosition().getValue())) {
            player.moveRight();
            return;
        }
        if (player.getPosition().getValue() > 0 && line.isPointFilledAt(
                player.getPosition().getValue() - 1)) {
            player.moveLeft();
        }
    }
}
