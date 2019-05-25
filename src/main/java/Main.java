import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Players players = InputView.readPlayers();
        Rewards rewards = InputView.readRewards(players.size());
        Height height = InputView.readHeight();

        LadderBoard ladderBoard = LadderBoard.of(Ladder.create(height, players.size()), players, rewards);
        OutputView.printLadderBoard(ladderBoard);

        keepLadderBoardMatching(ladderBoard, players);
    }

    private static void keepLadderBoardMatching(LadderBoard ladderBoard, Players players) {
        while(true) {
            Player player = InputView.readExistPlayer(players);
            OutputView.printLadderMachingResults(ladderBoard.play(player));
        }
    }
}
