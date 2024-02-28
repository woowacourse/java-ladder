package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import static laddergame.view.ExceptionHandledReader.retryUntilNoError;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        Elements people = retryUntilNoError(() -> new Elements(InputView.readNames()));
        Ladder ladder = retryUntilNoError(() -> makeLadder(people));
        Elements results = retryUntilNoError(() -> makeResults(people));

        LadderGame ladderGame = new LadderGame(people, ladder, results);

        ResultView.printLadder(people, ladder, results);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static Elements makeResults(Elements people) {
        Elements results = retryUntilNoError(() -> new Elements(InputView.readGameResult()));
        validateElementsSameLength(people, results);
        return results;
    }

    private static Ladder makeLadder(Elements people) {
        int peopleNumber = people.getElements().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static boolean printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return true;
    }

    private static void validateElementsSameLength(Elements upperElements, Elements lowerElements) {
        if (upperElements.getElements().size() != lowerElements.getElements().size()) {
            throw new IllegalArgumentException("게임 실행 결과와 게임 참여자의 수가 같지 않습니다");
        }
    }
}
