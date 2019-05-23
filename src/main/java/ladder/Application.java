package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private static final String PARTICIPANT_ALL = "all";

    public static void main(String[] args) {
        Application application = new Application();
        application.play();
    }

    private void play() {
        Players players = InputView.inputPlayers();
        Items items  = InputView.inputItems(players);
        int height = InputView.inputHeight();

        Ladder ladder = LadderGenerator.generate(height, players.getNumberOfPlayers(), new LineGenerator());
        LadderResult ladderResult = ladder.makeResult(players, items);

        printLadder(players, ladder, items);
        printResult(ladderResult, players);
    }

    private void printLadder(Players players, Ladder ladder, Items items) {
        OutputView.printPlayers(players);
        OutputView.printLadderBody(ladder);
        OutputView.printItems(items);
    }

    private void printResult(LadderResult ladderResult, Players players) {
        Player participant;
        do {
            participant = InputView.inputParticipant(players);
            OutputView.printResult(participant, ladderResult, players);
        } while (!participant.toString().equals(PARTICIPANT_ALL));
    }
}
