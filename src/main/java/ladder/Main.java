package ladder;

import ladder.domain.*;
import ladder.view.OutputView;
import ladder.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Player> players = InputView.initPlayers();
        List<Reward> rewards = InputView.initRewards(players);

        System.out.println("사다리 결과");
        Ladder ladder = Ladder.create(InputView.initLadderHeight(), players.size());

        // Todo: 몇개 정도 선긋기를 시도하는게 좋을까?
        LadderDrawer.tryDraw(ladder, 2 * players.size());
        DrawnLadder drawnLadder = ladder.drawn();

        OutputView.printLadderGameBoard(drawnLadder, players, rewards);

        // LadderGame game = new LadderGame(drawnLadder, players, rewards);
        //
//        while(true) {
            InputView.readPlayer();

            System.out.println("결과를 보고 싶은 사람은?");

            Position position = Navigator.navigate(drawnLadder, drawnLadder.createFirstColumnPosition());

            System.out.println("실행 결과");
//        }
    }
}
