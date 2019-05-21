package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.domain.Items;
import ladder.view.InputView;
import ladder.view.OutputView;

/**
 * @author heebg
 * @version 1.0 2019-05-19
 */
public class LadderApp {
    public static void main(String[] args) {
        Players players = InputView.inputPlayers(InputView.inputPlayersFromUser());
        Items items = InputView.inputItems(InputView.inputItemsFromUser(), players.size());
        int depth = InputView.inputDepth(InputView.inputDepthFromUser());

        Ladder ladder = Ladder.newInstance(players.size(),depth);
        LadderResult ladderResult = LadderResult.newInstance(players, items, ladder.executeResult());
        OutputView.outputLadderShape(players, ladder.draw(), items);
        OutputView.outputMatchItem(InputView.inputName(InputView.inputNameFromUser(), ladderResult));
    }
}
