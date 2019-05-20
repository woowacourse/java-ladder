package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.play();
    }

    private void play() {
        Players players = InputView.inputPlayers();
        Items items = InputView.inputItems(players);
        int height = InputView.inputHeight();

        Ladder ladder = new LadderGenerator().generate(height, players.getSize());
        printLadder(players, items, ladder);

        List<Item> finalResult = ladder.play(items);
        printResult(players, finalResult);
    }

    private void printLadder(Players players, Items items, Ladder ladder) {
        OutputView.printNames(players);
        OutputView.printLadderBody(ladder);
        OutputView.printItems(items);
    }

    private void printResult(Players players, List<Item> finalResult) {
        Player participant;
        do {
            participant = InputView.inputParticipant(players);
            OutputView.printResult(participant, finalResult, players);
        } while (!participant.toString().equals("all"));
    }
}
