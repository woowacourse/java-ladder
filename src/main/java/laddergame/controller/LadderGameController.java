package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.Players;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import static laddergame.view.ExceptionHandledReader.retryUntilNoError;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        Players people = retryUntilNoError(() -> new Players(InputView.readNames()));
        Ladder ladder = retryUntilNoError(() -> makeLadder(people));
        Players results = retryUntilNoError(() -> makeResults(people));

        LadderGame ladderGame = new LadderGame(people, ladder, results);

        ResultView.printLadder(people, ladder, results);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static Players makeResults(Players people) {
        Players results = retryUntilNoError(() -> new Players(InputView.readGameResult()));
        validateElementsSameLength(people, results);
        return results;
    }

    private static Ladder makeLadder(Players people) {
        int peopleNumber = people.getPlayerNames().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static boolean printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return true;
    }

    // TODO 해당 검증이 컨트롤러의 책임인지 생각해보기
    private static void validateElementsSameLength(Players upperPlayers, Players lowerPlayers) {
        if (upperPlayers.getPlayerNames().size() != lowerPlayers.getPlayerNames().size()) {
            throw new IllegalArgumentException("게임 실행 결과와 게임 참여자의 수가 같지 않습니다");
        }
    }
}
