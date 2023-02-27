package ladder.domain;

import java.util.List;

public class LadderGame {

    private static final String PLAYER_NAME_NOT_FOUND_EXCEPTION_MESSAGE = "[ERROR] 게임 내의 참가자를 입력해주세요.";
    private static final String ALL_PRINT_AND_EXIT_CODE = "all";
    private static final int LEFT = -1;
    private static final int STAY = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 1;

    private final PlayerNames playerNames;
    private final LadderSize ladderSize;
    private final Ladder ladder;
    private final Prize prize;
    private final ResultStorage resultStorage;

    public LadderGame(final List<String> names, final int height, final List<String> prizes, final BooleanGenerator booleanGenerator) {
        this.playerNames = new PlayerNames(names);
        this.ladderSize = new LadderSize(names.size() - 1, height);
        LadderMaker ladderMaker = new LadderMaker(ladderSize);

        this.ladder = ladderMaker.generate(booleanGenerator);
        this.prize = new Prize(prizes, names.size());
        this.resultStorage = new ResultStorage();
    }

    public void start() {
        for (int ladderLocation = 0; ladderLocation < playerNames.getPlayerCount(); ladderLocation++) {
            String playerName = playerNames.getNames().get(ladderLocation);
            String gamePrize = prize.getPrizes().get(getEachPlayerPrize(0, ladderLocation));
            resultStorage.add(gamePrize);
        }
    }

    private int getEachPlayerPrize(final int height, final int ladderLocation) {
        if (height >= ladderSize.getHeight()) {
            return ladderLocation;
        }
        int updatedLadderLocation = ladderLocation + decideRow(height, ladderLocation);

        if (ladderLocation == updatedLadderLocation) {
            return getEachPlayerPrize(height + DOWN, ladderLocation);
        }

        return getEachPlayerPrize(height + DOWN, updatedLadderLocation);
    }

    private int decideRow(final int height, final int ladderLocation) {
        if (ladderLocation == 0 || ladderLocation == playerNames.getPlayerCount() - 1) {
            return decideRowAtEndPoint(height, ladderLocation);
        }
        return decideRowAtNormal(height, ladderLocation);
    }

    private int decideRowAtEndPoint(final int height, final int ladderLocation) {
        if (ladderLocation == 0 && ladder.getLines().get(height).isConnectedAt(ladderLocation) == ConnectionStatus.CONNECTED) {
            return RIGHT;
        }

        if (ladderLocation == playerNames.getPlayerCount() - 1 && ladder.getLines().get(height).isConnectedAt(ladderLocation - 1) == ConnectionStatus.CONNECTED) {
            return LEFT;
        }

        return STAY;
    }

    private int decideRowAtNormal(final int height, final int ladderLocation) {
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

    public List<String> getPrizes() {
        return prize.getPrizes();
    }

    public ResultDto getGameResult(final String playerName) {
        validateWhomToKnowResult(playerName);
        if (playerName.equals(ALL_PRINT_AND_EXIT_CODE)) {
            return getGameResultByAll();
        }
        return getGameResultByPlayerName(playerName);
    }

    private void validateWhomToKnowResult(String playerName) {
        if (!playerName.equals(ALL_PRINT_AND_EXIT_CODE) && !playerNames.getNames().contains(playerName)) {
            throw new IllegalArgumentException(PLAYER_NAME_NOT_FOUND_EXCEPTION_MESSAGE);
        }
    }

    private ResultDto getGameResultByPlayerName(final String playerName) {
        return new ResultDto(List.of(playerName), List.of(resultStorage.get(playerNames.getNames().indexOf(playerName))), Boolean.FALSE);
    }

    private ResultDto getGameResultByAll() {
        return new ResultDto(playerNames.getNames(), resultStorage.getAll(), Boolean.TRUE);
    }
}
