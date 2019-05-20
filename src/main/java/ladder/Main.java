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
        int height = InputView.initLadderHeight();

        System.out.println("사다리 결과");

        int numRowPosition = 5;
        int numColumnPosition = 7;
        // Todo: 좀더 간단하게 생성하도록 도와주는 부분이 필요
        Ladder ladder = new Ladder(Stream.generate(() -> new HorizontalLine(Stream.generate(() -> Direction.NONE).limit(numColumnPosition).collect(Collectors.toList()))).limit(numRowPosition).collect(Collectors.toList()));

        // Todo: 몇개 정도 선긋기를 시도하는게 좋을까?
        LadderDrawer.tryDraw(ladder, 2 * (numColumnPosition + numRowPosition));

        DrawnLadder drawnLadder = ladder.drawn();
        OutputView.printDrawnLadder(drawnLadder);
        //
//        while(true) {
            System.out.println("결과를 보고 싶은 사람은?");

            Position position = Navigator.navigate(drawnLadder, drawnLadder.createFirstColumnPosition());

            System.out.println("실행 결과");
//        }
    }
}
