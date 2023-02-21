package ladder.domain;

import java.util.List;

public class LadderGame {

    private static final int LEFT = -1;
    private static final int STAY = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 1;

    private final PlayerNames playerNames;
    private final Ladder ladder;
    private final LadderSize ladderSize;
    private final Result result;
    private final ResultStorage resultStorage;

    public LadderGame(List<String> names, int height, List<String> results, BooleanGenerator booleanGenerator) {
        this.playerNames = new PlayerNames(names);
        this.ladderSize = new LadderSize(names.size() - 1, height);
        LadderMaker ladderMaker = new LadderMaker(ladderSize);

        this.ladder = ladderMaker.generate(booleanGenerator);
        this.result = new Result(results, names.size());
        this.resultStorage = new ResultStorage();
    }

    public void start() {
        for (int ladderLocation = 0; ladderLocation < playerNames.getPlayerCount(); ladderLocation++) {
            String playerName = playerNames.getNames().get(ladderLocation);
            String gameResult = result.getResults().get(getEachPlayerResult(0, ladderLocation));
            resultStorage.add(gameResult);
        }
    }

    private int getEachPlayerResult(int height, int ladderLocation) {
        if (height >= ladderSize.getHeight()) {
            return ladderLocation;
        }
        int updatedLadderLocation = ladderLocation + decideRow(height, ladderLocation);

        if (ladderLocation == updatedLadderLocation) {
            return getEachPlayerResult(height + DOWN, ladderLocation);
        }

        return getEachPlayerResult(height + DOWN, updatedLadderLocation);
    }

    private int decideRow(int height, int ladderLocation) {
        if (ladderLocation == 0 || ladderLocation == playerNames.getPlayerCount() - 1) {
            return decideRowAtEndPoint(height, ladderLocation);
        }
        return decideRowAtNormal(height, ladderLocation);
    }

    private int decideRowAtEndPoint(int height, int ladderLocation) {
        if (ladderLocation == 0 && ladder.getLines().get(height).isConnectedAt(ladderLocation) == ConnectionStatus.CONNECTED) {
            return RIGHT;
        }

        if (ladderLocation == playerNames.getPlayerCount() - 1 && ladder.getLines().get(height).isConnectedAt(ladderLocation - 1) == ConnectionStatus.CONNECTED) {
            return LEFT;
        }

        return STAY;
    }

    private int decideRowAtNormal(int height, int ladderLocation) {
        if (ladder.getLines().get(height).isConnectedAt(ladderLocation) == ConnectionStatus.CONNECTED) {
            return RIGHT;
        }

        if (ladder.getLines().get(height).isConnectedAt(ladderLocation - 1) == ConnectionStatus.CONNECTED) {
            return LEFT;
        }

        return STAY;
    }

    public List<String> getNames() {
        return playerNames.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<String> getResults() {
        return result.getResults();
    }

    public ResultDto getGameResult(String playerName) {
        if(playerName.equals("all")) {
            return getGameResultByAll();
        }
        return getGameResultByPlayerName(playerName);
    }

    public ResultDto getGameResultByPlayerName(String playerName) {
        return new ResultDto(List.of(playerName), List.of(resultStorage.get(playerNames.getNames().indexOf(playerName))));
    }

    public ResultDto getGameResultByAll() {
        return new ResultDto(playerNames.getNames(), resultStorage.getAll());
    }
}
