package laddergame.domain.game;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.domain.LadderResult;
import laddergame.domain.LadderResultItem;
import laddergame.domain.PersonalName;
import laddergame.domain.PersonalNames;
import laddergame.domain.game.player.Player;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.line.Line;

public class LadderGame {
    private final List<Player> players;
    private final LadderResult ladderResult;

    public LadderGame(PersonalNames personalNames, LadderResult ladderResult) {
        this.ladderResult = ladderResult;
        this.players = initPlayers(personalNames);
    }

    public NamesWithItem moveAndGetResult(Ladder ladder) {
        Map<PersonalName, LadderResultItem> nameToItem = players.stream().collect(Collectors.toMap(
                player -> player.getPersonalName(),
                player -> moveAndGetResult(player, ladder)
        ));
        return new NamesWithItem(nameToItem);
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
        int currentPosition = player.getPosition().getValue();
        if (isRightPointFilled(line, currentPosition)) {
            player.moveRight();
            return;
        }
        if (isLeftPointFilled(line, currentPosition)) {
            player.moveLeft();
        }
    }

    private boolean isLeftPointFilled(Line line, int currentPosition) {
        boolean hasLeftSide = currentPosition > 0;
        return hasLeftSide && line.isPointFilledAt(currentPosition - 1);
    }

    private boolean isRightPointFilled(Line line, int currentPosition) {
        boolean hasRightSide = currentPosition < players.size() - 1;
        return hasRightSide && line.isPointFilledAt(currentPosition);
    }
}
