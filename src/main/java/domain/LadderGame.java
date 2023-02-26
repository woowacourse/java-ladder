package domain;

import generator.LineGenerator;
import generator.RandomLineGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.OutputView;

public class LadderGame {

    private final Players playersInGame;
    private Ladder ladder;
    private final Results results;

    public LadderGame(Players players, Results results) {
        this.playersInGame = new Players(players.getPlayers());
        this.results = results;
    }

    public void makeLadder(Height height, int numberOfWalls) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Lines lines = makeLines(height, numberOfWalls, lineGenerator);

        this.ladder = new Ladder(lines, height);
    }

    private Lines makeLines(Height height, int numberOfWalls, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        int numberOfLine = numberOfWalls - 1;

        for (int i = 0; i < height.getHeight(); i++) {
            LineMaker lineMaker = new LineMaker(lineGenerator);
            List<LineStatus> lineStatuses = lineMaker.makeLineStatus(numberOfLine);
            lines.add(new Line(lineStatuses));
        }

        return new Lines(lines);
    }

    public void printLadder() {
        int width = Math.max(results.findMaxResultLength(), playersInGame.findMaxPlayerNameLength()) + 1;

        OutputView.printLadderMessage();
        OutputView.printPlayers(playersInGame, width);
        OutputView.printLadder(ladder, width);
        OutputView.printLadderResult(results, width);
    }

    public void playGame() {
        for (Line line : ladder.getLadder().getLines()) {
            crossLadder(line);
        }
    }

    private void crossLadder(Line line) {
        for (int index = 0; index < line.getLineStatuses().size(); index++) {
            changePosition(line, index);
        }
    }

    private void changePosition(Line line, int index) {
        if (line.getLineStatuses().get(index).getStatus()) {
            playersInGame.changePosition(index, index + 1);
        }
    }

    public Map<String, String> getLadderGameResult() {
        Map<String, String> ladderGameResult = new HashMap<>();

        for (int index = 0; index < playersInGame.getNumberOfPlayers(); index++) {
            ladderGameResult.put(playersInGame.getPlayers().get(index).getName(), results.getResultByIndex(index));
        }

        return ladderGameResult;
    }
}
