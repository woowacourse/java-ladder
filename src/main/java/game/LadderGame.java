package game;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.Block;
import model.Ladder;
import model.Line;
import model.Pass;
import model.Player;
import model.Players;

public class LadderGame {

    private final Ladder ladder;
    private final Map<Player, Integer> resultBoard = new LinkedHashMap<>();
    private final Players players;

    public LadderGame(List<String> results, Ladder ladder) {
        validatePlayersAndResultsHaveEqualNumber(results, ladder);
        this.ladder = ladder;
        this.players = ladder.getPlayers();
    }

    public void calculateFinalPosition() {
        initResultBoard();
        for (Line line : ladder.getLines()) {
            movePlayer(line);
        }
    }

    //시작 위치 초기화
    private void initResultBoard() {
        Players players = ladder.getPlayers();
        int playersNum = players.getPlayersNum();
        for (int i = 0; i < playersNum; i++) {
            resultBoard.put(players.getPlayers().get(i), i);
        }
    }

    private static void validatePlayersAndResultsHaveEqualNumber(List<String> results, Ladder ladder) {
        if (ladder.getPlayers().getPlayersName().size() != results.size()) {
            throw new IllegalArgumentException("결과 수와 사람 수가 다릅니다");
        }
    }

    //한 Line 에서 player 이동
    public void movePlayer(Line line) {
        List<Block> lineBlocks = line.getLine();
        for (Player player : players.getPlayers()) {
            int playerPosition = resultBoard.get(player);
            Block playerBlock = lineBlocks.get(playerPosition);
            reposition(player, playerPosition, playerBlock);
        }
    }

    private void reposition(Player player, int playerPosition, Block playerBlock) {
        if (playerBlock.getPass().equals(Pass.LEFT)) {
            resultBoard.put(player, playerPosition - 1);
        }
        if (playerBlock.getPass().equals(Pass.RIGHT)) {
            resultBoard.put(player, playerPosition + 1);
        }
    }

    public Map<String, Integer> getFinalPlayerResult(String targetName) {
        validatePlayerContainsTargetName(targetName);
        Map<String, Integer> copiedResultBoard = new LinkedHashMap<>();
        if (targetName.equals("all")) {
            putAllPlayerResults(copiedResultBoard);
            return copiedResultBoard;
        }
        putTargetPlayerResult(targetName, copiedResultBoard);
        return copiedResultBoard;
    }

    private void putTargetPlayerResult(String targetName, Map<String, Integer> copiedResultBoard) {
        copiedResultBoard.put(targetName, resultBoard.get(new Player(targetName)));
    }

    private void validatePlayerContainsTargetName(String targetName) {
        if (!resultBoard.containsKey(new Player(targetName))) {
            throw new IllegalArgumentException("해당 이름이 참가자 명단에 없습니다");
        }
    }

    private void putAllPlayerResults(Map<String, Integer> copiedResultBoard) {
        for (Entry<Player, Integer> playerIntegerEntry : resultBoard.entrySet()) {
            copiedResultBoard.put(playerIntegerEntry.getKey().getName(), playerIntegerEntry.getValue());
        }
    }
}
