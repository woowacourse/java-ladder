package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LadderGame {

    private static final String PLAYER_NAME_NOT_FOUND_EXCEPTION_MESSAGE = "[ERROR] 게임 내의 참가자를 입력해주세요.";
    private static final String ALL_PRINT_AND_EXIT_CODE = "all";

    private final Players players;
    private final LadderSize ladderSize;
    private final Ladder ladder;
    private final Prize prize;
    private final Result result;

    public LadderGame(final List<String> names, final int height, final List<String> prizes, final BooleanGenerator booleanGenerator) {
        this.players = new Players(makePlayers(names));
        this.ladderSize = new LadderSize(names.size() - 1, height);
        this.ladder = new Ladder(ladderSize, booleanGenerator);
        this.prize = new Prize(prizes, names.size());
        this.result = new Result();
    }

    private List<Player> makePlayers(final List<String> names) {
        List<Player> players= new ArrayList<>();
        for(int startIndex = 0; startIndex < names.size(); startIndex++) {
            players.add(new Player(names.get(startIndex), startIndex));
        }
        return players;
    }

    public void start() {
        for (Player player: players.getPlayers()) {
            String playerName = player.getName();
            int startIndex = player.getStartIndex();

            int playerPrizeIndex = ladder.getEachPlayerPrize(0, startIndex);
            String gamePrize = prize.getPrizeByIndex(playerPrizeIndex);
            result.add(playerName, gamePrize);
        }
    }

    public boolean continueGame(final String playerName) {
        if (ALL_PRINT_AND_EXIT_CODE.equals(playerName)) {
            return false;
        }
        return true;
    }

    public HashMap<String, String> getGameResult(final String playerName) {
        validateWhomToKnowResult(playerName);
        if (playerName.equals(ALL_PRINT_AND_EXIT_CODE)) {
            return getGameResultByAll();
        }
        return getGameResultByPlayerName(playerName);
    }

    private void validateWhomToKnowResult(final String playerName) {
        if (!playerName.equals(ALL_PRINT_AND_EXIT_CODE) && !players.contains(playerName)) {
            throw new IllegalArgumentException(PLAYER_NAME_NOT_FOUND_EXCEPTION_MESSAGE);
        }
    }

    private HashMap<String, String> getGameResultByPlayerName(final String playerName) {
        HashMap<String, String> resultOfOnePlayer = new LinkedHashMap<>();
        String prize = result.get(playerName);
        resultOfOnePlayer.put(playerName, prize);
        return resultOfOnePlayer;
    }

    private HashMap<String, String> getGameResultByAll() {
        return result.result();
    }

    public List<String> getNames() {
        return players.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<String> getPrizes() {
        return prize.getPrizes();
    }
}
