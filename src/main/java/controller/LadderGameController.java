package controller;

import domain.LadderGame;
import domain.connection.NonContinousConnectionGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderCreator;
import domain.line.RowLineGenerator;
import domain.player.PlayerName;
import domain.player.Players;
import domain.prize.Prizes;
import domain.result.LadderResult;
import view.InputView;
import view.ResultView;

public class LadderGameController {

    private final InputView inputView;
    private final InputMapper inputMapper;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, InputMapper inputMapper, ResultView resultView) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
        this.resultView = resultView;
    }

    public void run() {
        LadderGame ladderGame = createLadderGameFromInput();
        resultView.printLadder(ladderGame);
        repeatSingleTargetDrive(ladderGame);
        resultView.printResults(ladderGame.driveAll());
    }

    private LadderGame createLadderGameFromInput() {
        Players players = inputMapper.mapToNames(inputView.readNames());
        Height height = inputMapper.mapToHeight(inputView.readHeight());
        Prizes prizes = inputMapper.mapToPrizes(inputView.readResults());
        RowLineGenerator rowLineGenerator = new RowLineGenerator(new NonContinousConnectionGenerator());
        Ladder ladder = new LadderCreator().createLadder(rowLineGenerator, players.getPlayerCount(), height);

        return new LadderGame(ladder, players, prizes);
    }


    private void repeatSingleTargetDrive(LadderGame ladderGame) {
        PlayerName driverName = inputMapper.mapToName(inputView.readDriver());
        while (driverName.isNotSpecialKeyWord()) {
            LadderResult result = ladderGame.drive(driverName);
            resultView.printResult(result);
            driverName = inputMapper.mapToName(inputView.readDriver());
        }
    }
}
