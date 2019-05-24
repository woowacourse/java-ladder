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
//
//        keepLadderBoardMaching(ladderBoard, players);
//    }
//
//    private static void keepLadderBoardMaching(LadderBoard ladderBoard, Players players) {
//        while(true) {
//            Player player = InputView.readExistPlayer(players);
//            OutputView.printLadderMachingResults(ladderBoard.play(player));
//        }
    }
}

//    참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
//        pobi,honux,crong,jk
//
//        실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
//        꽝,5000,꽝,3000
//
//        최대 사다리 높이는 몇 개인가요?
//        5
//
//        사다리 결과
//
//        pobi  honux crong   jk
//        |-----|     |-----|
//        |     |-----|     |
//        |-----|     |     |
//        |     |-----|     |
//        |-----|     |-----|
//        꽝    5000  꽝    3000
//
//        결과를 보고 싶은 사람은?
//        pobi
//
//        실행 결과
//        꽝
//
//        결과를 보고 싶은 사람은?
//        all
//
//        실행 결과
//        pobi : 꽝
//        honux : 3000
//        crong : 꽝
//        jk : 5000
